package OnlineTradingDB.dao.inter;

import OnlineTradingDB.entity.City;

import java.util.List;

public interface CityDAO
{
    City add (City city);
    City update (City city);
    void remove (City city);
    City getById (Long id);
    List<City> getAll ();
}
