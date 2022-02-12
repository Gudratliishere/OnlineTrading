package OnlineTradingDB.configuration;

import OnlineTradingDB.dao.impl.*;
import OnlineTradingDB.dao.inter.*;

public class Context
{
    private static CityDAO cityDAO = null;
    private static UserDAO userDAO = null;
    private static CategoryDAO categoryDAO = null;
    private static SubcategoryDAO subcategoryDAO = null;
    private static KindDAO kindDAO = null;

    public static KindDAO getKindDAO ()
    {
        if (kindDAO == null)
            kindDAO = new KindDAOImpl();

        return kindDAO;
    }

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
