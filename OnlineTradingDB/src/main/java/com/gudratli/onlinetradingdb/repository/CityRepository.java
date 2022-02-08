package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long>
{
    List<City> findByNameContaining (String name);
}
