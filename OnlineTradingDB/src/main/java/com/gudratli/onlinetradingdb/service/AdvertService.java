package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.entity.Advert;
import com.gudratli.onlinetradingdb.entity.City;
import com.gudratli.onlinetradingdb.repository.AdvertRepository;
import com.gudratli.onlinetradingdb.util.AdvertFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertService
{
    private final AdvertRepository advertRepository;

    public List<Advert> getAll ()
    {
        return advertRepository.findAll();
    }

    public Advert getById (Long id)
    {
        return advertRepository.findById(id).orElse(null);
    }

    public List<Advert> getByName (String name)
    {
        return advertRepository.findByNameContainingOrderByPublishDateDesc(name);
    }

    public List<Advert> getByFilter (AdvertFilter advertFilter)
    {
        return advertRepository.findByCityAndCategoryAndSubcategoryAndKindAndUsedAndPriceBetween(
                advertFilter.getCity(), advertFilter.getCategory(), advertFilter.getSubcategory(),
                advertFilter.getKind(), advertFilter.getUsed(), advertFilter.getMinPrice(),
                advertFilter.getMaxPrice());
    }

    public List<Advert> getByCity (City city)
    {
        return advertRepository.findByCityOrderByPublishDateDesc(city);
    }

    public Advert update (Advert advert)
    {
        return advertRepository.save(advert);
    }

    public Advert add (Advert advert)
    {
        return advertRepository.save(advert);
    }

    public void remove (Advert advert)
    {
        advertRepository.delete(advert);
    }
}
