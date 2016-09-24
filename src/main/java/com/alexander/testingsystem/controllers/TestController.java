package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.*;
import com.alexander.testingsystem.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public final class TestController
{
    private QuestionDAOJDBCTemplate questionDAOJDBCTemplate = new QuestionDAOJDBCTemplate();
    private AnswerDAOJDBCTemplate answerDAOJDBCTemplate = new AnswerDAOJDBCTemplate();
    private UserDAOJDBCTemplateImpl userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();
    private TestDAOJDBCTemplate testDAOJDBCTemplate = new TestDAOJDBCTemplate();
    private HistoryDAOJDBCTemplate historyDAOJDBCTemplate = new HistoryDAOJDBCTemplate();
    private int count = 0;
    private long idTest;


    @RequestMapping("/startTesting")
    public String startTesting(Model model, Principal principal) {
        model.addAttribute("id", userDAOJDBCTemplate.getByLogin(principal.getName()).getId());
        return "startTesting";
    }

    @RequestMapping("test/{id}")
    public String testing(@PathVariable long id, Model model){

        Test variableTest = new Test();
        variableTest.setIdUser(id);
        variableTest.setDate(new Date());
        testDAOJDBCTemplate.insert(variableTest);
        variableTest.setId(testDAOJDBCTemplate.getByObject(new Object[]{id, new Date()}).getId());
        idTest = variableTest.getId();
        return "redirect:/test";
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String test(@ModelAttribute("resultForm") Answer answer, Model model) {
        model.addAttribute("questionText", getMultipleChoice().get(count).getQuestion());
        model.addAttribute("answersText", new ArrayList<Answer>(getMultipleChoice().get(count).getAnswers()));
        model.addAttribute("resultForm", answer);
        return "test";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@Valid @ModelAttribute("resultForm") Answer answer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("validation error occured in survey form");
            return "test";
        }
        answer.setIdQuestion(answerDAOJDBCTemplate.getById(answer.getId()).getIdQuestion());
        History history = new History();
        history.setIdAnswer(answer.getId());
        history.setIdQuestion(answer.getIdQuestion());
        history.setIdTest(idTest);
        historyDAOJDBCTemplate.insert(history);
        count++;
        if(count < getMultipleChoice().size()) {
            return "redirect:/test";
        }
        else {
            count=0;
            model.addAttribute("id", idTest);
            return "redirect:/results/{id}";
        }
    }

    private List<MultipleChoice> getMultipleChoice() {
        List<MultipleChoice> multipleChoices = new ArrayList<MultipleChoice>();
        ArrayList<Question> questionList = new ArrayList<Question>(questionDAOJDBCTemplate.getAll());
        for (int i = 0; i < questionList.size(); i++) {
            multipleChoices.add(new MultipleChoice(questionList.get(i).getText(),
                    answerDAOJDBCTemplate.getAnswersByQuestionId(questionList.get(i).getId()),
                    questionList.get(i).getId()));
        }
        return multipleChoices;
    }
}
