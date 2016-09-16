package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.QuestionMapper;
import com.alexander.testingsystem.model.Question;
import org.apache.commons.dbcp.BasicDataSource;

import java.util.List;

public class QuestionDAOJDBCTemplate extends AbstractDAO<Question> {
    public QuestionDAOJDBCTemplate(final BasicDataSource dataSource) {
        super(dataSource);
    }

    public boolean insert(Question question) {
        String query = "insert into Question (id, id_theme, text, difficult) values (?, ?, ?, ?)";

        return insert(query, question);
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
        String query = "select * from User";
        return getAll(query, new QuestionMapper());
    }
}
