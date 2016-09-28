package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import com.alexander.testingsystem.mailsender.CustomMailAPI;
import com.alexander.testingsystem.model.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public final class RegistrationController
{
    private final UserDAOJDBCTemplateImpl daojdbcTemplate = new UserDAOJDBCTemplateImpl();
    private final ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
    private final CustomMailAPI customMailAPI = (CustomMailAPI) context.getBean("customEmail");
    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }



    @RequestMapping
    public String registration()
    {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegistration(@Valid @ModelAttribute("user") User user, BindingResult result)
    {
        if (result.hasErrors()) {
            return "registration";
        }
        customMailAPI.noticeOfRegistration(user.getEmail(), user.getLogin());
        daojdbcTemplate.insert(user);
        return "redirect:/";
    }


    @RequestMapping("/availableLogin")
    @ResponseBody
    public String availableLogin(@RequestParam String login) {
        Boolean available = daojdbcTemplate.checkLogin(login) == 0;
        return available.toString();
    }

    @RequestMapping("/availableEmail")
    @ResponseBody
    public String availableEmail(@RequestParam String email) {
        Boolean available = daojdbcTemplate.checkEmail(email) == 0;
        return available.toString();
    }


}
