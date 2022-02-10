package OnlineTradingDB.dao.impl;

import OnlineTradingDB.dao.inter.CategoryDAO;
import OnlineTradingDB.entity.Category;

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

public class CategoryDAOImpl implements CategoryDAO
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(CategoryDAOImpl.class.getName()));

    @Override
    public Category add (Category category)
    {
        String query = "insert into category (name) values (?);";
        String queryForId = "select LAST_INSERT_ID()";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getName());
            preparedStatement.execute();

            PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);
            preparedStatementForId.execute();

            ResultSet resultSet = preparedStatementForId.getResultSet();
            if (resultSet.next())
                category.setId(resultSet.getLong(1));
            return category;
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting new data to category.", ex);
            return null;
        }
    }

    @Override
    public Category update (Category category)
    {
        String query = "update category set name = ? where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setLong(2, category.getId());

            if (!preparedStatement.execute())
                return category;
            else
                throw new Exception("Can not update category.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while updating category with '" + category.getId() + "' id.", ex);
            return null;
        }
    }

    @Override
    public void remove (Category category)
    {
        String query = "delete from category where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, category.getId());

            if (preparedStatement.execute())
                throw new Exception("Can not delete data.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE,
                    "Error occurred while deleting data from category with '" + category.getId() + "' id.", ex);
        }
    }

    @Override
    public Category getById (Long id)
    {
        String query = "select * from category where id = ?";

        Category category = null;
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next())
            {
                category = new Category();
                fillCategoryWithRS(category, resultSet);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from category with '" + id + "' id.", ex);
        }

        return category;
    }

    @Override
    public List<Category> getAll ()
    {
        String query = "select * from category";

        List<Category> categories = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                Category category = new Category();
                fillCategoryWithRS(category, resultSet);
                categories.add(category);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching all data from category.", ex);
        }

        return categories;
    }

    private void fillCategoryWithRS (Category category, ResultSet resultSet) throws SQLException
    {
        category.setId(resultSet.getLong("id"));
        category.setName(resultSet.getString("name"));
    }
}
