package com.gudratli.onlinetradingdb;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class OnlineTradingDbApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run(OnlineTradingDbApplication.class, args);
    }
}
