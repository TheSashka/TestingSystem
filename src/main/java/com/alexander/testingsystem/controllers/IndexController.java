package com.alexander.testingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController
{
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/redirect", params = "register")
    public String redirectRegister() {

        return "redirect:register";
    }

    @RequestMapping(value = "/redirect", params = "enter")
    public String redirectProfile()
    {
        return "redirect:profile/home/";
    }

}
