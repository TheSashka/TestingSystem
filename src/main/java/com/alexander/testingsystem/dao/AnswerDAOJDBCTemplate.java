package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.AnswerMapper;
import com.alexander.testingsystem.model.Answer;
import org.apache.commons.dbcp.BasicDataSource;

import java.util.List;

public class AnswerDAOJDBCTemplate extends AbstractDAO<Answer> {
    public AnswerDAOJDBCTemplate() {
        super();
    }

    public boolean insert(Answer answer) {
        String query = "insert into Answer (id, id_question, text, is_true) values (?, ?, ?, ?)";
        return insert(query, new Object[]{});
    }

    public boolean update(Answer answer) {
        String query = "update Answer set id_question=?, text=?, is_true=? where id=?";
        return update(query, answer);
    }

    public boolean deleteById(int id) {
        String query = "delete from Answer where id=?";

        return delete(query, id);
    }

    public Answer getById(int id) {
        String query = "select * from Answer where id = ?";

        return getByID(query, id, new AnswerMapper());
    }

    public List<Answer> getAll() {
        String query = "select * from Answer";

        return getAll(query, new AnswerMapper());
    }
}
