package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import com.alexander.testingsystem.mailsender.CustomMailAPI;
import com.alexander.testingsystem.model.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ForgotPasswordController {

    private final ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
    private final CustomMailAPI customMailAPI = (CustomMailAPI) context.getBean("customEmail");

    @RequestMapping(value="/resetPassword" , method= RequestMethod.POST)
    public String resetPassword(@Valid @ModelAttribute("user") User user, BindingResult result){
        if (result.hasErrors()) {
            return "forgotPassword";
        }
        customMailAPI.resetPasswordMail(user.getEmail());
        return "checkMail";
    }

    @RequestMapping("/newPassword/{email}" )
    public String resetPassword(@PathVariable String email, Model model)
    {
        User user = new User();
        user.setEmail(email);
        model.addAttribute("user", user);
        return "newPassword";
    }
    @RequestMapping(value = "/settingNewPassword", method = RequestMethod.POST)
    public String settingNewPassword(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "settingNewPassword";
        }
        System.out.println(user.getEmail());
        UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();
        user.setId(userDAOJDBCTemplate.getByEmail(user.getEmail()).getId());
        user.setLogin(userDAOJDBCTemplate.getById(user.getId()).getLogin());
        userDAOJDBCTemplate.update(user);
        return "redirect:/";
    }
}
