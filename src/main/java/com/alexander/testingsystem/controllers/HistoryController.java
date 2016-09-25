package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.TestDAOJDBCTemplate;
import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public final class HistoryController
{
    @RequestMapping("history")
    public String history(Model model, Principal principal) {
        UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();
        TestDAOJDBCTemplate testDAOJDBCTemplate = new TestDAOJDBCTemplate();
        model.addAttribute("histories", testDAOJDBCTemplate.getByUserId(
                userDAOJDBCTemplate.getByLogin(principal.getName()).getId()));
        return "history";
    }

    @RequestMapping("histories")
    public String histories(Model model) {
        TestDAOJDBCTemplate testDAOJDBCTemplate = new TestDAOJDBCTemplate();
        model.addAttribute("histories", testDAOJDBCTemplate.getAll());
        return "history";
    }
}
