package com.alexander.testingsystem.dao;


import com.alexander.testingsystem.mapper.TestMapper;
import com.alexander.testingsystem.model.Test;

import java.util.List;

public final class TestDAOJDBCTemplate extends AbstractDAO<Test> {
    public TestDAOJDBCTemplate() {
        super();
    }

    public boolean insert(Test test){
        String query = "insert into Test(id_user, date) value (?, ?)";
        Object[] values = new Object[]{test.getIdUser(), test.getDate()};
        return insert(query, values);
    }

    public Test getById(long id){
        String query = "select * from Test where id = ?";
        return getByID(query, id, new TestMapper());
    }

    public Test getByObject(Object[] objects){
        String query = "select * from Test where id_user =? and date=?";
        return getByObject(query, objects, new TestMapper());
    }

    public List<Test> getByUserId(long user_id){
        String query = "select * from Test where id_user = ?";
        return getByOtherID(query, user_id, new TestMapper());
    }

    public List<Test> getAll(){
        String query = "select * from Test";
        return getAll(query, new TestMapper());
    }
}
