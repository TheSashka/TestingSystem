package com.alexander.testingsystem.model;

import java.util.List;

public final class MultipleChoice {
    private String question;
    private List<Answer> answers;
    private long idQuestion;
    private int difficult;

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

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

    public MultipleChoice(String question, List<Answer> answers, long idQuestion) {
        this.question = question;
        this.answers = answers;
        this.idQuestion = idQuestion;
    }

    public MultipleChoice() {
    }
}
