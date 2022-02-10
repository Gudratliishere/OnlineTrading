package OnlineTradingDB.main;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CityDAO;
import OnlineTradingDB.dao.inter.UserDAO;
import OnlineTradingDB.entity.City;
import OnlineTradingDB.entity.User;

public class Main
{
    public static void main (String[] args)
    {
        CityDAO cityDAO = Context.getCityDAO();

        City city = cityDAO.getById(4L);

        UserDAO userDAO = Context.getUserDAO();

        User user = userDAO.getById(4L);
        userDAO.remove(user);
    }
}
