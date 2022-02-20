package com.gudratli.onlinetradingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController
{
    @GetMapping("/index")
    public ModelAndView index ()
    {
        System.out.println("Hello world!");
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
