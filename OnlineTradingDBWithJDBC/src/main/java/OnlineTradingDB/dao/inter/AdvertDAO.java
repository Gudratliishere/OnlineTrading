package OnlineTradingDB.dao.inter;

import OnlineTradingDB.entity.*;

import java.util.List;

public interface AdvertDAO
{
    Advert add (Advert advert);
    Advert update (Advert advert);
    void remove (Advert advert);
    Advert getById (Long id);
    List<Advert> getAll ();
    List<Advert> getByName (String name);
    List<Advert> getByCity (City city);
    List<Advert> getByCityAndCategoryAndSubcategoryAndKindAndUsedAndPriceBetween (City city,
            Category category, Subcategory subcategory, Kind kind, Boolean used, Integer minPrice,
            Integer maxPrice, Integer minVote);
}
