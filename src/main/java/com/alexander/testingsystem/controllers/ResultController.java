package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.AnswerDAOJDBCTemplate;
import com.alexander.testingsystem.dao.HistoryDAOJDBCTemplate;
import com.alexander.testingsystem.dao.QuestionDAOJDBCTemplate;
import com.alexander.testingsystem.model.History;
import com.alexander.testingsystem.model.QuestionAndAnswer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public final class ResultController
{
    private HistoryDAOJDBCTemplate historyDAOJDBCTemplate = new HistoryDAOJDBCTemplate();

    @RequestMapping("results/{id}")
    public String result(@PathVariable long id, Model model) {
        QuestionDAOJDBCTemplate questionDAOJDBCTemplate = new QuestionDAOJDBCTemplate();
        AnswerDAOJDBCTemplate answerDAOJDBCTemplate = new AnswerDAOJDBCTemplate();
        ArrayList<QuestionAndAnswer> questionAndAnswers = new ArrayList<QuestionAndAnswer>();

        for(History history: historyDAOJDBCTemplate.getAllById(id)) {
            QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
            questionAndAnswer.setQuestion(questionDAOJDBCTemplate.getById(history.getIdQuestion()).getText());
            questionAndAnswer.setAnswer(answerDAOJDBCTemplate.getById(history.getIdAnswer()).getText());
            questionAndAnswer.setIsTrue(answerDAOJDBCTemplate.getById(history.getIdAnswer()).getIsTrue());
            questionAndAnswers.add(questionAndAnswer);
        }
        model.addAttribute("results", questionAndAnswers);
        return "results";
    }
}
