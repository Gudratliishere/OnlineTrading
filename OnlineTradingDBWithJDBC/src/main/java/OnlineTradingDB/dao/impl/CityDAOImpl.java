package OnlineTradingDB.dao.impl;

import OnlineTradingDB.dao.inter.CityDAO;
import OnlineTradingDB.entity.City;

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

public class CityDAOImpl implements CityDAO
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(CityDAOImpl.class.getName()));

    public City add (City city)
    {
        String query = "insert into city(name) values(?);";
        String queryForId = "select LAST_INSERT_ID()";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getName());

            preparedStatement.execute();

            PreparedStatement preparedStatementForId =
                    connection.prepareStatement(queryForId);
            preparedStatementForId.execute();

            ResultSet resultSet = preparedStatementForId.getResultSet();
            if (resultSet.next())
                city.setId(resultSet.getLong(1));
            return city;
        } catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting new data to city table.", e);
            return null;
        }
    }

    public City update (City city)
    {
        String query = "update city set name = ? where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setLong(2, city.getId());
            if(!preparedStatement.execute())
                return city;
            else
                throw new Exception("Can not update city.");
        } catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Error occurred while updating city with '" + city.getId() +
                    "' id.", e);
            return null;
        }
    }

    public void remove (City city)
    {
        String query = "delete from city where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, city.getId());
            if (!preparedStatement.execute())
                return;
            else
                throw new Exception("Can not removing data from city.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while removing data from city with '" +
                    city.getId() + "' id.", ex);
        }
    }

    public City getById (Long id)
    {
        String query = "select * from city where id = ?";

        City city = null;
        try (Connection connection = connect())
        {
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             preparedStatement.setLong(1, id);
             preparedStatement.execute();

             ResultSet resultSet = preparedStatement.getResultSet();
             if (resultSet.next())
             {
                 city = new City();
                 fillCityWithRS(city, resultSet);
             }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from city with '" +
                    id + "' id.", ex);
        } finally
        {
            return city;
        }
    }

    private void fillCityWithRS (City city, ResultSet resultSet) throws SQLException
    {
        city.setId(resultSet.getLong("id"));
        city.setName(resultSet.getString("name"));
    }

    public List<City> getAll ()
    {
        String query = "select * from city";

        List<City> cities = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                City city = new City();
                fillCityWithRS(city ,resultSet);
                cities.add(city);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching all data from city.", ex);
        } finally
        {
            return cities;
        }
    }
}
