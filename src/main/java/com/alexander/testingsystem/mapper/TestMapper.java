package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class TestMapper extends AbstractMapper<com.alexander.testingsystem.model.Test> {
    public Test mapRow(ResultSet resultSet, int i) throws SQLException {
        Test test = new Test();
        test.setId(resultSet.getLong("id"));
        test.setIdUser(resultSet.getInt("id_user"));
        test.setDate(resultSet.getDate("date"));
        return test;
    }
}
