package com.alexander.testingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfileController
{
    @RequestMapping("home")
    public String home()
    {
        return "home";
    }

    @RequestMapping("history")
    public String history()
    {
        return "history";
    }

    @RequestMapping("test")
    public String test()
    {
        return "test";
    }

    @RequestMapping("settings")
    public String settings()
    {
        return "settings";
    }
    
}
