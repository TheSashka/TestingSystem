package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.History;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class HistoryMapper extends AbstractMapper<History> {

    public History mapRow(ResultSet rs, int i) throws SQLException {
        History history    = new History();
        history.setId(rs.getLong("id"));
        history.setIdQuestion(rs.getInt("id_question"));
        history.setIdAnswer(rs.getInt("id_answer"));
        history.setIdTest(rs.getInt("id_test"));
        return history;
    }
}
