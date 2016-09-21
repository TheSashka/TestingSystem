package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public final class ProfileController {

    private UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();

    @RequestMapping("/profile")
    public String profile(Model model, Principal principal) {
        String login = principal.getName();
        model.addAttribute("user", userDAOJDBCTemplate.getByLogin(login));
        return "profile";
    }
}
