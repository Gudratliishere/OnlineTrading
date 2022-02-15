package OnlineTradingDB.service;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.UserDAO;
import OnlineTradingDB.entity.User;

import java.util.List;

public class UserService
{
    private final UserDAO userDAO = Context.getUserDAO();

    public User add (User user)
    {
        return userDAO.add(user);
    }

    public User update (User user)
    {
        return userDAO.update(user);
    }

    public void remove (User user)
    {
        userDAO.remove(user);
    }

    public User getById (Long id)
    {
        return userDAO.getById(id);
    }

    public List<User> getAll ()
    {
        return userDAO.getAll();
    }

    public List<User> getByName (String name)
    {
        return userDAO.getByName(name);
    }
}
