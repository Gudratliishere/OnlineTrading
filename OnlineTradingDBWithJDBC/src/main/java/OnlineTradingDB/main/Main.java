package OnlineTradingDB.main;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CityDAO;
import OnlineTradingDB.entity.City;

public class Main
{
    public static void main (String[] args)
    {
        CityDAO cityDAO = Context.getCityDAO();

        City city = cityDAO.getById(6L);
        cityDAO.remove(city);
    }
}
