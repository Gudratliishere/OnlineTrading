package com.gudratli.onlinetradingdb;

import com.gudratli.onlinetradingdb.entity.City;
import com.gudratli.onlinetradingdb.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtil
{
    public static List<City> generateCities()
    {
        return IntStream.range(0, 5)
                .mapToObj(i -> new City(i + "City"))
                .collect(Collectors.toList());
    }
}
