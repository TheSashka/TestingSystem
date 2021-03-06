package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import com.alexander.testingsystem.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public final class ProfileController {

    private UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();

    @RequestMapping("/profile")
    public String profile(Model model, Principal principal) {
        model.addAttribute("user", userDAOJDBCTemplate.getByLogin(principal.getName()));
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST, value = "save/{id}")
    public String doUpdate(@ModelAttribute("user") User user, @PathVariable Integer id, Model model)
    {
        user.setId(id.longValue());
        if(user.getPassword().isEmpty())
        {
            user.setPassword(userDAOJDBCTemplate.getById(id).getPassword());
        }
        else
        {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
        }
        userDAOJDBCTemplate.update(user);
        model.addAttribute("user", user);
        return "redirect:/login";
    }
}
