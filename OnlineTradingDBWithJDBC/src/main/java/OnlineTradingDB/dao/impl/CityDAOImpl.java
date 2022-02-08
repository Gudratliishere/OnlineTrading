package OnlineTradingDB.dao.impl;

import OnlineTradingDB.dao.inter.CityDAO;
import OnlineTradingDB.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static OnlineTradingDB.configuration.Config.connect;

public class CityDAOImpl implements CityDAO
{
    private static final Logger LOG = Logger.getLogger(CityDAOImpl.class.getName());

    public City add (City city)
    {
        String query = "insert into city(name) values(?); select LAST_INSERT_ID();";

        try (Connection connection = connect())
        {
            PreparedStatement stmt = connection.prepareCall(query);
            stmt.setString(1, city.getName());

            city.setId(Long.parseLong(stmt.executeQuery().getString(0)));
            return city;
        } catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting new data to city table.\n" +
                    e.getMessage() + '\n' + e.getStackTrace());
            return null;
        }
    }

    public City update (City city)
    {
        return null;
    }

    public void remove (City city)
    {

    }

    public City getById (Long id)
    {
        return null;
    }

    public List<City> getAll ()
    {
        return null;
    }
}
