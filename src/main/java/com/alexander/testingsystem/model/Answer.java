package com.alexander.testingsystem.model;

public final class Answer extends AbstractEntity
{
    private long idQuestion;
    private String text;
    private boolean is_true;

    public long getIdQuestion() {
        return idQuestion;
    }


    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsTrue() {
        return is_true;
    }

    public void setIsTrue(boolean aTrue) {
        is_true = aTrue;
    }
}
