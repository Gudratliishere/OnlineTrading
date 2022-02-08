package OnlineTradingDB.configuration;

import OnlineTradingDB.dao.impl.CityDAOImpl;
import OnlineTradingDB.dao.inter.CityDAO;

public class Context
{
    private static CityDAO cityDAO = null;

    public static CityDAO getCityDAO ()
    {
        if (cityDAO == null)
            cityDAO = new CityDAOImpl();

        return cityDAO;
    }
}
