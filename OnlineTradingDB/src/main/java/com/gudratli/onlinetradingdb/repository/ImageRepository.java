package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.Advert;
import com.gudratli.onlinetradingdb.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long>
{
    List<Image> findByAdvert(Advert advert);
}
