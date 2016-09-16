package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends AbstractMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("login"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
