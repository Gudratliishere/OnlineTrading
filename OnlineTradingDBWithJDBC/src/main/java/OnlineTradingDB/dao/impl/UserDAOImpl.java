package OnlineTradingDB.dao.impl;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CityDAO;
import OnlineTradingDB.dao.inter.UserDAO;
import OnlineTradingDB.entity.User;

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

public class UserDAOImpl implements UserDAO
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(UserDAOImpl.class.getName()));
    private final CityDAO cityDAO = Context.getCityDAO();

    @Override
    public User add (User user)
    {
        String query = "insert into user (name, surname, mail, password, phone, city) values (?, ?, ?, ?, ?, ?)";
        String queryForId = "select LAST_INSERT_ID()";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setLong(6, user.getCity().getId());
            preparedStatement.execute();

            PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);
            preparedStatementForId.execute();
            ResultSet resultSet = preparedStatementForId.getResultSet();
            if (resultSet.next())
                user.setId(resultSet.getLong(1));
            return user;
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting new data to user.", ex);
            return null;
        }
    }

    @Override
    public User update (User user)
    {
        String query = "update user set name = ?, surname = ?, mail = ?, phone = ?, password = ?, city = ? where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setLong(6, user.getCity().getId());
            preparedStatement.setLong(7, user.getId());
            preparedStatement.execute();

            return user;
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while updating user with '" + user.getId() + "' id.", ex);
            return null;
        }
    }

    @Override
    public void remove (User user)
    {
        String query = "delete from user where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.execute();
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while deleting user with '" + user.getId() + "' id.", ex);
        }
    }

    @Override
    public User getById (Long id)
    {
        String query = "select * from user where id = ?";

        User user = null;
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next())
            {
                user = new User();
                fillUserWithRS(user, resultSet);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from user with '" + id + "' id.", ex);
        }

        return user;
    }

    @Override
    public List<User> getAll ()
    {
        String query = "select * from user";

        List<User> users = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                User user = new User();
                fillUserWithRS(user, resultSet);
                users.add(user);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching all data from user.", ex);
        }

        return users;
    }

    @Override
    public List<User> getByName (String name)
    {
        String query = "select * from user where name like ?";
        name = '%' + name + '%';

        List<User> users = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())
            {
                User user = new User();
                fillUserWithRS(user, resultSet);
                users.add(user);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching user with '" + name + "' name.", ex);
        }

        return users;
    }

    private void fillUserWithRS (User user, ResultSet resultSet) throws SQLException
    {
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setPhone(resultSet.getString("phone"));
        user.setMail(resultSet.getString("mail"));
        user.setPassword(resultSet.getString("password"));
        user.setCity(cityDAO.getById(resultSet.getLong("city")));
    }
}
