package com.gudratli.onlinetradingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController
{
    @GetMapping("/account")
    public ModelAndView index ()
    {
        ModelAndView modelAndView = new ModelAndView("account");
        return modelAndView;
    }
}
