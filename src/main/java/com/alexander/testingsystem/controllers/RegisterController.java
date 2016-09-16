package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import com.alexander.testingsystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController
{
    UserDAOJDBCTemplateImpl daojdbcTemplate = new UserDAOJDBCTemplateImpl();

    @RequestMapping("/register")
    public String register()
    {
        return "register";
    }

    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user)
    {
        daojdbcTemplate.insert(user);
        return "register";
    }




}
