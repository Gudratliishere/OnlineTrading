package OnlineTradingDB.dao.impl;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.KindDAO;
import OnlineTradingDB.dao.inter.SubcategoryDAO;
import OnlineTradingDB.entity.Kind;
import OnlineTradingDB.entity.Subcategory;
import sun.plugin.dom.core.CoreConstants;

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

public class KindDAOImpl implements KindDAO
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(KindDAOImpl.class.getName()));
    private final SubcategoryDAO subcategoryDAO = Context.getSubcategoryDAO();

    @Override
    public Kind add (Kind kind)
    {
        String query = "insert into kind(name, subcategory) values(?, ?);";
        String queryForId = "select LAST_INSERT_ID();";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kind.getName());
            preparedStatement.setLong(2, kind.getSubcategory().getId());
            preparedStatement.execute();

            PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);
            preparedStatementForId.execute();

            ResultSet resultSet = preparedStatementForId.getResultSet();
            if (resultSet.next())
                kind.setId(resultSet.getLong(1));

            return kind;
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting data to kind.", ex);
            return null;
        }
    }

    @Override
    public Kind update (Kind kind)
    {
        String query = "update kind set name = ?, subcategory = ? where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kind.getName());
            preparedStatement.setLong(2, kind.getSubcategory().getId());
            preparedStatement.setLong(3, kind.getId());
            if (!preparedStatement.execute())
                return kind;
            else
                throw new Exception("Can not update kind");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while updating kind with '" + kind.getId() + "' id.", ex);
            return null;
        }
    }

    @Override
    public void remove (Kind kind)
    {
        String query = "delete from kind where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, kind.getId());
            if (preparedStatement.execute())
                throw new Exception("Can not delete data.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while deleting data from kind with '" + kind.getId() + "' id.", ex);
        }
    }

    @Override
    public Kind getById (Long id)
    {
        String query = "select * from kind where id = ?";

        Kind kind = null;
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next())
            {
                kind = new Kind();
                fillKindWithRS(kind, resultSet);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from kind with '" + id + "' id.", ex);
        }

        return kind;
    }

    private void fillKindWithRS (Kind kind, ResultSet resultSet) throws SQLException
    {
        kind.setId(resultSet.getLong("id"));
        kind.setName(resultSet.getString("name"));
        kind.setSubcategory(subcategoryDAO.getById(resultSet.getLong("subcategory")));
    }

    @Override
    public List<Kind> getAll ()
    {
        String query = "select *from kind";

        List<Kind> kinds = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                Kind kind = new Kind();
                fillKindWithRS(kind, resultSet);
                kinds.add(kind);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching all data from kind.", ex);
        }

        return kinds;
    }

    @Override
    public List<Kind> getBySubcategory (Subcategory subcategory)
    {
        String query = "select * from kind where subcategory = ?";

        List<Kind> kinds = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, subcategory.getId());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                Kind kind = new Kind();
                fillKindWithRS(kind, resultSet);
                kinds.add(kind);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE,
                    "Error occurred while fetching data from kind with '" + subcategory.getId() + "' id subcategory",
                    ex);
        }

        return kinds;
    }
}
