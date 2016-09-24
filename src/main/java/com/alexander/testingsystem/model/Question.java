package com.alexander.testingsystem.model;

public final class Question extends AbstractEntity
{
    private String text;
    private int difficult;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }
}
