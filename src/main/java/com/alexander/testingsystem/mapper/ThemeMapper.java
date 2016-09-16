package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.Theme;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThemeMapper extends AbstractMapper<Theme> {

    public Theme mapRow(ResultSet resultSet, int i) throws SQLException {

        Theme theme = new Theme();
        theme.setId(resultSet.getLong("id"));
        theme.setName(resultSet.getString("name"));
        return theme;
    }
}
