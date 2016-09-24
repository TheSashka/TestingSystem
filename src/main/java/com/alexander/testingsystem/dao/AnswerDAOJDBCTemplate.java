package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.AnswerMapper;
import com.alexander.testingsystem.mapper.QuestionMapper;
import com.alexander.testingsystem.model.Answer;

import java.util.ArrayList;
import java.util.List;

public final class AnswerDAOJDBCTemplate extends AbstractDAO<Answer> {
    public AnswerDAOJDBCTemplate() {
        super();
    }

    public boolean insert(Answer answer) {
        String query = "insert into Answer (id_question, text, is_true) values (?, ?, ?)";
        Object[] values = new Object[]{ answer.getIdQuestion(), answer.getText(), answer.isTrue() };
        return insert(query, values);
    }

    public boolean update(Answer answer) {
        String query = "update Answer set id_question=?, text=?, is_true=? where id=?";
        Object[] values = new Object[]{ answer.getIdQuestion(), answer.getText(), answer.isTrue(), answer.getId() };
        return update(query, values);
    }

    public boolean deleteById(long id) {
        String query = "delete from Answer where id=?";

        return delete(query, id);
    }

    public Answer getById(long id) {
        String query = "select * from Answer where id = ?";

        return getByID(query, id, new AnswerMapper());
    }

    public List<Answer> getAll() {
        String query = "select * from Answer";

        return getAll(query, new AnswerMapper());
    }

    public List<String> getByQuestionId(long id)
    {
        String query = "select * from Answer where id_question =?";
        List<Answer> answers = getByOtherID(query, id, new AnswerMapper());
        List<String> textAnswers = new ArrayList<String>();
        for(Answer answer: answers)
        {
            textAnswers.add(answer.getText());
        }
        return textAnswers;
    }

    public List<Answer> getAnswersByQuestionId(long id)
    {
        String query = "select * from Answer where id_question =?";
        List<Answer> answers = getByOtherID(query, id, new AnswerMapper());
        return answers;
    }

}
