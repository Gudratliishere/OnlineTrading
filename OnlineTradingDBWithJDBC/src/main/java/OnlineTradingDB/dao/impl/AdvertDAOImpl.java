package OnlineTradingDB.dao.impl;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.*;
import OnlineTradingDB.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static OnlineTradingDB.configuration.Config.connect;
import static OnlineTradingDB.configuration.LoggerUtil.addFileWriter;

public class AdvertDAOImpl implements AdvertDAO
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(AdvertDAOImpl.class.getName()));
    private final CategoryDAO categoryDAO = Context.getCategoryDAO();
    private final SubcategoryDAO subcategoryDAO = Context.getSubcategoryDAO();
    private final KindDAO kindDAO = Context.getKindDAO();
    private final UserDAO userDAO = Context.getUserDAO();
    private final CityDAO cityDAO = Context.getCityDAO();

    @Override
    public Advert add (Advert advert)
    {
        String query = "insert into advert (name, description, price, used, publish_date, category, subcategory, kind, user, city) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        String queryForId = "select LAST_INSERT_ID();";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            fillPreparedStatement(preparedStatement, advert);
            preparedStatement.execute();

            PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);
            preparedStatementForId.execute();

            ResultSet resultSet = preparedStatementForId.getResultSet();
            if (resultSet.next())
                advert.setId(resultSet.getLong(1));
            return advert;
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting new data to advert.", ex);
            return null;
        }
    }

    @Override
    public Advert update (Advert advert)
    {
        String query = "update advert set name = ?, description = ?, price = ?, used = ?, publish_date = ?, category = ?, " +
                "subcategory = ?, kind = ?, user = ?, city = ? where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            fillPreparedStatement(preparedStatement, advert);
            preparedStatement.setLong(11, advert.getId());
            if (!preparedStatement.execute())
                return advert;
            else
                throw new Exception("Can not update advert.");

        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while updating advert with '" + advert.getId() + "' id.", ex);
            return null;
        }
    }

    private void fillPreparedStatement (PreparedStatement preparedStatement, Advert advert) throws SQLException
    {
        preparedStatement.setString(1, advert.getName());
        preparedStatement.setString(2, advert.getDescription());
        preparedStatement.setInt(3, advert.getPrice());
        preparedStatement.setBoolean(4, advert.getUsed());
        preparedStatement.setDate(5, new java.sql.Date(advert.getPublishDate().getTime()));
        preparedStatement.setLong(6, advert.getCategory().getId());
        preparedStatement.setLong(7, advert.getSubcategory().getId());
        preparedStatement.setLong(8, advert.getKind().getId());
        preparedStatement.setLong(9, advert.getUser().getId());
        preparedStatement.setLong(10, advert.getCity().getId());
    }

    @Override
    public void remove (Advert advert)
    {
        String query = "delete from advert where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, advert.getId());
            if (preparedStatement.execute())
                throw new Exception("Can not delete data.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while deleting data from advert with '" + advert.getId() + "' id.",
                    ex);
        }
    }

    @Override
    public Advert getById (Long id)
    {
        String query = "select * from advert where id = ?";

        Advert advert = null;
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next())
            {
                advert = new Advert();
                fillAdvertWithRS(advert, resultSet);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from advert with '" + id + "' id.", ex);
        }

        return advert;
    }

    @Override
    public List<Advert> getAll ()
    {
        String query = "select * from advert order by publish_date desc";

        List<Advert> adverts = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            readResultSetToList(preparedStatement.getResultSet(), adverts);
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching all data from advert.", ex);
        }

        return adverts;
    }

    @Override
    public List<Advert> getByName (String name)
    {
        String query = "select * from advert where name like ? order by publish_date desc";
        name = '%' + name + '%';

        List<Advert> adverts = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.execute();

            readResultSetToList(preparedStatement.getResultSet(), adverts);
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from advert with '" + name + "' name containing.",
                    ex);
        }

        return adverts;
    }

    @Override
    public List<Advert> getByCity (City city)
    {
        String query = "select * from advert where city = ? order by publish_date desc";

        List<Advert> adverts = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, city.getId());
            preparedStatement.execute();

            readResultSetToList(preparedStatement.getResultSet(), adverts);
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from advert with '" + city.getId() + "' id city.",
                    ex);
        }

        return adverts;
    }

    @Override
    public List<Advert> getByCityAndCategoryAndSubcategoryAndKindAndUsedAndPriceBetween (City city, Category category,
            Subcategory subcategory, Kind kind, Boolean used, Integer minPrice, Integer maxPrice)
    {
        StringBuilder query = new StringBuilder("select * from advert where 1 = 1");
        fillQueryStringForFilter(query, city, category, subcategory, kind, used, minPrice, maxPrice);
        query.append("  order by publish_date desc");

        List<Advert> adverts = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            setParametersForFilter(preparedStatement, city, category, subcategory, kind, used, minPrice, maxPrice);
            preparedStatement.execute();

            readResultSetToList(preparedStatement.getResultSet(), adverts);
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching filtered data from advert.", ex);
        }

        return adverts;
    }

    private void setParametersForFilter (PreparedStatement preparedStatement, City city, Category category,
            Subcategory subcategory, Kind kind, Boolean used, Integer minPrice, Integer maxPrice) throws SQLException
    {
        int index = 1;
        if (city != null)
            preparedStatement.setLong(index++, city.getId());
        if (category != null)
            preparedStatement.setLong(index++, category.getId());
        if (subcategory != null)
            preparedStatement.setLong(index++, subcategory.getId());
        if (kind != null)
            preparedStatement.setLong(index++, kind.getId());
        if (used != null)
            preparedStatement.setBoolean(index++, used);
        if (minPrice != null)
            preparedStatement.setInt(index++, minPrice);
        if (maxPrice != null)
            preparedStatement.setInt(index, maxPrice);
    }

    private void fillQueryStringForFilter (StringBuilder query, City city, Category category,
            Subcategory subcategory, Kind kind, Boolean used, Integer minPrice, Integer maxPrice)
    {
        if (city != null)
            query.append(" and city = ?");
        if (category != null)
            query.append(" and category = ?");
        if (subcategory != null)
            query.append(" and subcategory = ?");
        if (kind != null)
            query.append(" and kind = ?");
        if (used != null)
            query.append(" and used = ?");
        if (minPrice != null)
            query.append(" and price >= ?");
        if (maxPrice != null)
            query.append(" and price <= ?");
    }

    private void readResultSetToList (ResultSet resultSet, List<Advert> adverts) throws SQLException
    {
        while (resultSet.next())
        {
            Advert advert = new Advert();
            fillAdvertWithRS(advert, resultSet);
            adverts.add(advert);
        }
    }

    private void fillAdvertWithRS (Advert advert, ResultSet resultSet) throws SQLException
    {
        advert.setId(resultSet.getLong("id"));
        advert.setName(resultSet.getString("name"));
        advert.setDescription(resultSet.getString("description"));
        advert.setUsed(resultSet.getBoolean("used"));
        advert.setPrice(resultSet.getInt("price"));
        advert.setPublishDate(resultSet.getDate("publish_date"));
        advert.setCategory(categoryDAO.getById(resultSet.getLong("category")));
        advert.setSubcategory(subcategoryDAO.getById(resultSet.getLong("subcategory")));
        advert.setKind(kindDAO.getById(resultSet.getLong("kind")));
        advert.setUser(userDAO.getById(resultSet.getLong("user")));
        advert.setCity(cityDAO.getById(resultSet.getLong("city")));
    }
}
