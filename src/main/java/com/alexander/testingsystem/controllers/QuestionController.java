package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.AnswerDAOJDBCTemplate;
import com.alexander.testingsystem.dao.QuestionDAOJDBCTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    private QuestionDAOJDBCTemplate questionDAOJDBCTemplate = new QuestionDAOJDBCTemplate();

    @RequestMapping("question")
    public String question(Model model){
        model.addAttribute("questions", questionDAOJDBCTemplate.getAll());
        return "question";
    }

    @RequestMapping("delete/{id}")
    public String deleteQuestion(@PathVariable long id, Model model){
        AnswerDAOJDBCTemplate answerDAOJDBCTemplate = new AnswerDAOJDBCTemplate();
        answerDAOJDBCTemplate.deleteByQuestionId(id);
        questionDAOJDBCTemplate.deleteById(id);
        model.addAttribute("success", true);
        return "redirect:/question";
    }
}
