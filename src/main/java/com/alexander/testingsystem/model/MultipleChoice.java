package com.alexander.testingsystem.model;

import java.util.List;

public final class MultipleChoice {
    private String question;
    private List<Answer> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public MultipleChoice(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public MultipleChoice()
    {

    }
}
