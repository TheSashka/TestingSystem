package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.QuestionMapper;
import com.alexander.testingsystem.model.Question;

import java.util.List;

public final class QuestionDAOJDBCTemplate extends AbstractDAO<Question> {
    public QuestionDAOJDBCTemplate() {
        super();
    }

    public boolean insert(Question question) {
        String query = "insert into Question (id_theme, text, difficult) values (?, ?, ?)";
        Object[] values = new Object[]{question.getIdTheme(), question.getText(), question.getDifficult()};
        return insert(query, values);
    }

    public boolean update(Question question) {
        String query = "update Question set id_theme=?, text=?, difficult=? where id=?";
        return update(query, question);
    }

    public boolean deleteById(int id) {
        String query = "delete from Question where id=?";

        return delete(query, id);
    }

    public Question getById(int id) {
        String query = "select * from Question where id = ?";

        return getByID(query, id, new QuestionMapper());
    }

    public List<Question> getAll() {
        String query = "select * from Question";
        return getAll(query, new QuestionMapper());
    }
}
