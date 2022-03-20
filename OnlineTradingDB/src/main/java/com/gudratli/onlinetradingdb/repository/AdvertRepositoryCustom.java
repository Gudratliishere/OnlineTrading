package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.*;

import java.util.List;

public interface AdvertRepositoryCustom
{
    List<Advert> findByCityAndCategoryAndSubcategoryAndKindAndUsedAndPriceBetween(City city,
            Category category, Subcategory subcategory, Kind kind, Boolean used, Integer minPrice,
            Integer maxPrice, Integer minVote);
}
