package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.TestDAOJDBCTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    @RequestMapping("question")
    public String question(){

        return "question";
    }
}
