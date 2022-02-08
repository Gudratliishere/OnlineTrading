package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.entity.City;
import com.gudratli.onlinetradingdb.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService
{
    private final CityRepository cityRepository;

    public List<City> getAll ()
    {
        return cityRepository.findAll();
    }

    public City getById (Long id)
    {
        return cityRepository.findById(id).orElse(null);
    }

    public List<City> getByName (String name)
    {
        return cityRepository.findByNameContaining(name);
    }

    public City update (City city)
    {
        return cityRepository.save(city);
    }

    public City add (City city)
    {
        return cityRepository.save(city);
    }

    public void remove (City city)
    {
        cityRepository.delete(city);
    }
}