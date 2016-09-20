package com.alexander.testingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public final class IndexController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("home")
    public String home()
    {
        return "index";
    }
}
