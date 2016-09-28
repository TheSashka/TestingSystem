package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public final class LoginController
{

    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/forgotPassword")
    public String forgotPassword(){
        return "forgotPassword";
    }

}
