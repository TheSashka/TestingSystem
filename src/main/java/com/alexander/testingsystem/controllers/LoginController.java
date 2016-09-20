package com.alexander.testingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public final class LoginController
{
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

}
