package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.TestDAOJDBCTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoriesController {
    @RequestMapping("histories")
    public String histories(Model model) {
        TestDAOJDBCTemplate testDAOJDBCTemplate = new TestDAOJDBCTemplate();
        model.addAttribute("histories", testDAOJDBCTemplate.getAll());
        return "histories";
    }
}
