package com.alexander.testingsystem.model;

public abstract class AbstractEntity {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
