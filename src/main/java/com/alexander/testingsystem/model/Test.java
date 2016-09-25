package com.alexander.testingsystem.model;


import java.util.Date;

public final class Test extends AbstractEntity
{
    private long idUser;
    private Date date;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
