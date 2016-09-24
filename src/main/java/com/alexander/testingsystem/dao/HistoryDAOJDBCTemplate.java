package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.HistoryMapper;
import com.alexander.testingsystem.model.History;

import java.util.List;

public final class HistoryDAOJDBCTemplate extends AbstractDAO<History>
{
    public HistoryDAOJDBCTemplate() {
        super();
    }

    public boolean insert(History history)
    {
        String query = "insert into History (id_question, id_answer, id_test) values (?, ?, ?)";
        Object[] values = new Object[]{ history.getIdQuestion(), history.getIdAnswer(), history.getIdTest() };
        return insert(query, values);
    }

    public History getById(long id)
    {
        String query = "select * from History where id = ?";

        return getByID(query, id, new HistoryMapper());
    }

    public History getByIdTest(long idTest, long idQuestion){
        String query = "select * from History where id_test =? and id_question=?";
        return  getByObject(query, new Object[]{idTest, idQuestion}, new HistoryMapper());
    }

    public List<History> getAllbyId(long idTest){
        String query = "select * from History where id_test=?";
        return getByOtherID(query, idTest, new HistoryMapper());
    }

    public boolean update(History history){
        String query = "update History set id_answer=? where id_test=? and id_question=?";
        return update(query, new Object[]{history.getIdAnswer(), history.getIdTest(), history.getIdQuestion()});
    }
}
