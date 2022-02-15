package OnlineTradingDB.service;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CityDAO;
import OnlineTradingDB.entity.City;

import java.util.List;

public class CityService
{
    private final CityDAO cityDAO = Context.getCityDAO();

    public City add (City city)
    {
        return cityDAO.add(city);
    }

    public City update (City city)
    {
        return  cityDAO.update(city);
    }

    public void remove (City city)
    {
        cityDAO.remove(city);
    }

    public City getById (Long id)
    {
        return cityDAO.getById(id);
    }

    public List<City> getAll ()
    {
        return cityDAO.getAll();
    }
}
