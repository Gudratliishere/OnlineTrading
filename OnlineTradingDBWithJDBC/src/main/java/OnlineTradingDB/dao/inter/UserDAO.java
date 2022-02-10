package OnlineTradingDB.dao.inter;

import OnlineTradingDB.entity.User;

import java.util.List;

public interface UserDAO
{
    User add (User user);
    User update (User user);
    void remove (User user);
    User getById (Long id);
    List<User> getAll ();
    List<User> getByName (String name);
}
