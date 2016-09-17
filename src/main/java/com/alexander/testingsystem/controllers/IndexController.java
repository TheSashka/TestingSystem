package com.alexander.testingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public final class IndexController
{
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/redirect", params = "registration")
    public String redirectRegister() {

        return "redirect:registration";
    }

    @RequestMapping(value = "/redirect", params = "enter")
    public String redirectProfile()
    {
        return "redirect:profile/home/";
    }

}
