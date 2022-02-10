package OnlineTradingDB.configuration;

import OnlineTradingDB.dao.impl.CategoryDAOImpl;
import OnlineTradingDB.dao.impl.CityDAOImpl;
import OnlineTradingDB.dao.impl.SubcategoryDAOImpl;
import OnlineTradingDB.dao.impl.UserDAOImpl;
import OnlineTradingDB.dao.inter.CategoryDAO;
import OnlineTradingDB.dao.inter.CityDAO;
import OnlineTradingDB.dao.inter.SubcategoryDAO;
import OnlineTradingDB.dao.inter.UserDAO;

public class Context
{
    private static CityDAO cityDAO = null;
    private static UserDAO userDAO = null;
    private static CategoryDAO categoryDAO = null;
    private static SubcategoryDAO subcategoryDAO = null;

    public static SubcategoryDAO getSubcategoryDAO ()
    {
        if (subcategoryDAO == null)
            subcategoryDAO = new SubcategoryDAOImpl();

        return subcategoryDAO;
    }

    public static CategoryDAO getCategoryDAO ()
    {
        if (categoryDAO == null)
            categoryDAO = new CategoryDAOImpl();

        return categoryDAO;
    }

    public static UserDAO getUserDAO ()
    {
        if (userDAO == null)
            userDAO = new UserDAOImpl();

        return userDAO;
    }

    public static CityDAO getCityDAO ()
    {
        if (cityDAO == null)
            cityDAO = new CityDAOImpl();

        return cityDAO;
    }
}
