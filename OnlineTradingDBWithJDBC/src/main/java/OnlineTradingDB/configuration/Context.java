package OnlineTradingDB.configuration;

import OnlineTradingDB.dao.impl.*;
import OnlineTradingDB.dao.inter.*;
import OnlineTradingDB.entity.Advert;

public class Context
{
    private static CityDAO cityDAO = null;
    private static UserDAO userDAO = null;
    private static CategoryDAO categoryDAO = null;
    private static SubcategoryDAO subcategoryDAO = null;
    private static KindDAO kindDAO = null;
    private static AdvertDAO advertDAO = null;
    private static ImageDAO imageDAO = null;

    public static ImageDAO getImageDAO ()
    {
        if (imageDAO == null)
            imageDAO = new ImageDAOImpl();

        return imageDAO;
    }

    public static AdvertDAO getAdvertDAO ()
    {
        if (advertDAO == null)
            advertDAO = new AdvertDAOImpl();

        return advertDAO;
    }

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
