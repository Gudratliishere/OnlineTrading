package OnlineTradingDB.dao.impl;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CategoryDAO;
import OnlineTradingDB.dao.inter.SubcategoryDAO;
import OnlineTradingDB.entity.Category;
import OnlineTradingDB.entity.Subcategory;

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

public class SubcategoryDAOImpl implements SubcategoryDAO
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(SubcategoryDAOImpl.class.getName()));
    private final CategoryDAO categoryDAO = Context.getCategoryDAO();

    @Override
    public Subcategory add (Subcategory subcategory)
    {
        String query = "insert into subcategory (name, category) values(?, ?);";
        String queryForId = "select LAST_INSERT_ID();";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subcategory.getName());
            preparedStatement.setLong(2, subcategory.getCategory().getId());
            preparedStatement.execute();

            PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);
            preparedStatementForId.execute();

            ResultSet resultSet = preparedStatementForId.getResultSet();
            if (resultSet.next())
                subcategory.setId(resultSet.getLong(1));

            return subcategory;
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting new data to subcategory.", ex);
            return null;
        }
    }

    @Override
    public Subcategory update (Subcategory subcategory)
    {
        String query = "update subcategory set name = ?, category = ? where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subcategory.getName());
            preparedStatement.setLong(2, subcategory.getCategory().getId());
            preparedStatement.setLong(3, subcategory.getId());

            if (!preparedStatement.execute())
                return subcategory;
            else
                throw new Exception("Can not update subcategory.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while updating subcategory with '" + subcategory.getId() + "' id.",
                    ex);
            return null;
        }
    }

    @Override
    public void remove (Subcategory subcategory)
    {
        String query = "delete from subcategory where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, subcategory.getId());

            if (preparedStatement.execute())
                throw new Exception("Can not delete data from subcategory.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE,
                    "Error occurred while deleting data from subcategory with '" + subcategory.getId() + "' id.", ex);
        }
    }

    @Override
    public Subcategory getById (Long id)
    {
        String query = "select * from subcategory where id = ?";

        Subcategory subcategory = null;
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next())
            {
                subcategory = new Subcategory();
                fillSubcategoryWithRS(subcategory, resultSet);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from subcategory with '" + id + "' id.", ex);
        }

        return subcategory;
    }

    @Override
    public List<Subcategory> getAll ()
    {
        String query = "select * from subcategory";

        List<Subcategory> subcategories = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                Subcategory subcategory = new Subcategory();
                fillSubcategoryWithRS(subcategory, resultSet);
                subcategories.add(subcategory);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching all data from subcategory.", ex);
        }

        return subcategories;
    }

    @Override
    public List<Subcategory> getByCategory (Category category)
    {
        String query = "select * from subcategory where category = ?";

        List<Subcategory> subcategories = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, category.getId());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                Subcategory subcategory = new Subcategory();
                fillSubcategoryWithRS(subcategory, resultSet);
                subcategories.add(subcategory);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from subcategory with '" + category.getId() +
                    "' id category.", ex);
        }

        return subcategories;
    }

    private void fillSubcategoryWithRS (Subcategory subcategory, ResultSet resultSet) throws SQLException
    {
        subcategory.setId(resultSet.getLong("id"));
        subcategory.setName(resultSet.getString("name"));
        subcategory.setCategory(categoryDAO.getById(resultSet.getLong("category")));
    }
}
