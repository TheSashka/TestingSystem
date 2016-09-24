package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import com.alexander.testingsystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserDetailController {

    @RequestMapping("user-detail/{id}")
    public String userDetail(@PathVariable long id, Model model){
        UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();
        User user = userDAOJDBCTemplate.getById(id);
        model.addAttribute("user", user);
        return "user-detail";
    }
}
