package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

    @RequestMapping("users")
    public String users(Model model) {
        UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();
        model.addAttribute("users", userDAOJDBCTemplate.getAll());
        return "users";
    }
}
