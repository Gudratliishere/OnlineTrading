package com.gudratli.onlinetradingdb;

import com.gudratli.onlinetradingdb.entity.*;
import com.gudratli.onlinetradingdb.repository.AdvertRepository;
import com.gudratli.onlinetradingdb.service.*;
import com.gudratli.onlinetradingdb.util.AdvertFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
public class OnlineTradingDbApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run(OnlineTradingDbApplication.class, args);
    }

    final CityService cityService;
    final UserService userService;
    final CategoryService categoryService;
    final SubcategoryService subcategoryService;
    final KindService kindService;
    final AdvertService advertService;
    final AdvertRepository advertRepository;
    final ImageService imageService;

    @Bean
    public CommandLineRunner run ()
    {
        return args ->
        {
//            Advert advert = new Advert("he", categoryService.getById(5L),
//                    subcategoryService.getById(1L), kindService.getById(2L),
//                    250, cityService.getById(2L), "satiram da",
//                    userService.getById(2L), false);
//            advertService.add(advert);
            Date date = new Date();
            System.out.println(date);
        };
    }
}
