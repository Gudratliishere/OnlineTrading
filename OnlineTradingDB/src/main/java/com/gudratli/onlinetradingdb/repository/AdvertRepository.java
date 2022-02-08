package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long>, AdvertRepositoryCustom
{
    List<Advert> findByNameContainingOrderByPublishDateDesc (String name);

    List<Advert> findByCityOrderByPublishDateDesc (City city);
}
