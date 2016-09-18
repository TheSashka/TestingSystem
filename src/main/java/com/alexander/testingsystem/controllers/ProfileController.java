package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.AnswerDAOJDBCTemplate;
import com.alexander.testingsystem.dao.QuestionDAOJDBCTemplate;
import com.alexander.testingsystem.model.MultipleChoice;
import com.alexander.testingsystem.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("profile")
public final class ProfileController
{
    private QuestionDAOJDBCTemplate questionDAOJDBCTemplate = new QuestionDAOJDBCTemplate();
    private AnswerDAOJDBCTemplate answerDAOJDBCTemplate = new AnswerDAOJDBCTemplate();
    @RequestMapping("home")
    public String home()
    {
        return "home";
    }

    @RequestMapping("history")
    public String history()
    {
        return "history";
    }

    @RequestMapping("test")
    public String test(Model model) {
        model.addAttribute("tests", getMultipleChoice());
        return "test";
    }

    @RequestMapping("settings")
    public String settings()
    {
        return "settings";
    }

    private List<MultipleChoice> getMultipleChoice() {
        List<MultipleChoice> multipleChoices = new ArrayList<MultipleChoice>();
        ArrayList<Question> questionList = new ArrayList<Question>(questionDAOJDBCTemplate.getAll());
        for (int i = 0; i < questionList.size(); i++)
        {
            multipleChoices.add(new MultipleChoice(questionList.get(i).getText(),
                     answerDAOJDBCTemplate.getByQuestionId(questionList.get(i).getId())));
        }
        return multipleChoices;
    }
}
