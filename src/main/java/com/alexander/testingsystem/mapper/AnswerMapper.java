package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class AnswerMapper extends AbstractMapper<Answer> {

    public Answer mapRow(ResultSet rs, int i) throws SQLException {
        Answer answer     = new Answer();
        answer.setId(rs.getLong("id"));
        answer.setIdQuestion(rs.getInt("id_question"));
        answer.setText(rs.getString("text"));
        answer.setIsTrue(rs.getBoolean("is_true"));
        return answer;
    }
}
