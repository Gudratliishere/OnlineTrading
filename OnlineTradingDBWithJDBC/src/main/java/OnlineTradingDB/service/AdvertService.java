package OnlineTradingDB.service;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.AdvertDAO;
import OnlineTradingDB.entity.Advert;
import OnlineTradingDB.entity.City;
import OnlineTradingDB.util.AdvertFilter;

import java.util.List;

public class AdvertService
{
    private final AdvertDAO advertDAO = Context.getAdvertDAO();

    public Advert add (Advert advert)
    {
        return advertDAO.add(advert);
    }

    public Advert update (Advert advert)
    {
        return advertDAO.update(advert);
    }

    public void remove (Advert advert)
    {
        advertDAO.remove(advert);
    }

    public Advert getById (Long id)
    {
        return advertDAO.getById(id);
    }

    public List<Advert> getAll ()
    {
        return advertDAO.getAll();
    }

    public List<Advert> getByName (String name)
    {
        return advertDAO.getByName(name);
    }

    public List<Advert> getByCity (City city)
    {
        return advertDAO.getByCity(city);
    }

    public List<Advert> getByFilter (AdvertFilter advertFilter)
    {
        return advertDAO.getByCityAndCategoryAndSubcategoryAndKindAndUsedAndPriceBetween(
                advertFilter.getCity(), advertFilter.getCategory(), advertFilter.getSubcategory(),
                advertFilter.getKind(), advertFilter.getUsed(), advertFilter.getMinPrice(),
                advertFilter.getMaxPrice()
                                                                                        );
    }
}
