package com.alexander.testingsystem.controllers;

import com.alexander.testingsystem.dao.AnswerDAOJDBCTemplate;
import com.alexander.testingsystem.dao.QuestionDAOJDBCTemplate;
import com.alexander.testingsystem.model.Answer;
import com.alexander.testingsystem.model.MultipleChoice;
import com.alexander.testingsystem.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public final class QuestionController {

    @RequestMapping("question")
    public String question(Model model){
        MultipleChoice multipleChoice = new MultipleChoice();
        List<Answer> answerList = new ArrayList<Answer>();
        answerList.add(new Answer());
        answerList.add(new Answer());
        answerList.add(new Answer());
        answerList.add(new Answer());
        multipleChoice.setAnswers(answerList);
        model.addAttribute("multipleChoice", multipleChoice);
        return "question";
    }

    @RequestMapping(value = "addQuestion", method = RequestMethod.POST)
    public String addQuestion(@Valid @ModelAttribute MultipleChoice multipleChoice,
                              BindingResult bindingResult, Model model ) {
        if (bindingResult.hasErrors()) {
            return "question";
        }
        Question question = new Question();
        question.setText(multipleChoice.getQuestion());
        question.setDifficult(multipleChoice.getDifficult());
        QuestionDAOJDBCTemplate questionDAOJDBCTemplate = new QuestionDAOJDBCTemplate();
        questionDAOJDBCTemplate.insert(question);
        question.setId(questionDAOJDBCTemplate.getByText(multipleChoice.getQuestion()).getId());

        AnswerDAOJDBCTemplate answerDAOJDBCTemplate = new AnswerDAOJDBCTemplate();
        for (Answer answer: multipleChoice.getAnswers()) {
            if(!answer.getText().isEmpty()) {
                answer.setIdQuestion(question.getId());
                answerDAOJDBCTemplate.insert(answer);
            }
        }
        model.addAttribute("success", true);
        return "redirect:question";
    }

}
