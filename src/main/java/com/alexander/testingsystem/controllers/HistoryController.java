package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.TestDAOJDBCTemplate;
import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import com.alexander.testingsystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public final class HistoryController
{
    private TestDAOJDBCTemplate testDAOJDBCTemplate = new TestDAOJDBCTemplate();

    @RequestMapping("history")
    public String history(Model model, Principal principal) {
        UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();
        model.addAttribute("histories", testDAOJDBCTemplate.getByUserId(
                userDAOJDBCTemplate.getByLogin(principal.getName()).getId()));
        return "history";
    }

    @RequestMapping("histories")
    public String histories(Model model) {
        model.addAttribute("histories", testDAOJDBCTemplate.getAll());
        return "history";
    }
}
