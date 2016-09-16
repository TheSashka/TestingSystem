package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper extends AbstractMapper<Question> {

    public Question mapRow(ResultSet rs, int i) throws SQLException {
        Question question  = new Question();
        question.setId(rs.getLong("id"));
        question.setIdTheme(rs.getInt("id_theme"));
        question.setText(rs.getString("text"));
        question.setDifficult(rs.getInt("difficult"));
        return question;
    }
}
