package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.*;
import com.alexander.testingsystem.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/startTesting")
    public String startTesting() {
        return "startTesting";
    }


    @RequestMapping(value="/test")
    public String test(Model model) {
        Answers answers = new Answers();
        List<Answer> answerArrayList = new ArrayList<Answer>();
        for(int i = 0; i < getMultipleChoice().size(); i++){
            answerArrayList.add(new Answer());
        }
        answers.setAnswers(answerArrayList);
        model.addAttribute("resultForm", answers);
        model.addAttribute("multipleChoices", getMultipleChoice());
        return "test";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@Valid @ModelAttribute("resultForm") Answers answers, BindingResult result,
                         Principal principal, Model model) {
        if (result.hasErrors()) {
            System.out.println("validation error occured in survey form");
            return "test";
        }
        User user = userDAOJDBCTemplate.getByLogin(principal.getName());
        Test test = new Test();
        test.setDate(new Date());
        test.setIdUser(user.getId());
        testDAOJDBCTemplate.insert(test);
        test.setId(testDAOJDBCTemplate.getByObject(new Object[]{user.getId(), "new"}).getId());
        for (Answer answer: answers.getAnswers()){
            if(answer.getId() != 0){
                History history = new History();
                answer.setIdQuestion(answerDAOJDBCTemplate.getById(answer.getId()).getIdQuestion());
                history.setIdAnswer(answer.getId());
                history.setIdQuestion(answer.getIdQuestion());
                history.setIdTest(test.getId());
                historyDAOJDBCTemplate.insert(history);
            }
        }
        test.setState("finished");
        testDAOJDBCTemplate.update(test);
        model.addAttribute("id", test.getId());
        return "redirect:/results/{id}";
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
