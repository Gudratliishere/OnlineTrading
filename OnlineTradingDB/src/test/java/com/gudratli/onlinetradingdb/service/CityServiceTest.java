package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.TestUtil;
import com.gudratli.onlinetradingdb.entity.City;
import com.gudratli.onlinetradingdb.repository.CityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gudratli.onlinetradingdb.TestUtil.generateCities;
import static org.mockito.Mockito.*;

class CityServiceTest
{
    private CityRepository cityRepository;
    private CityService cityService;

    public void setup ()
    {
        cityRepository = mock(CityRepository.class);
        cityService = mock(CityService.class);
    }

    public void testGetAll_itShouldReturnCityList ()
    {
        List<City> cities = generateCities();
        when(cityRepository.findAll()).thenReturn(cities);

        List<City> result = cityService.getAll();

        Assertions.assertEquals(cities, result);
        verify(cityRepository).findAll();
    }
}