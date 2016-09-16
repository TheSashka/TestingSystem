package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.HistoryMapper;
import com.alexander.testingsystem.model.History;
import org.apache.commons.dbcp.BasicDataSource;

public class HistoryDAOJDBCTemplate extends AbstractDAO<History>
{
    public HistoryDAOJDBCTemplate(final BasicDataSource dataSource) {
        super(dataSource);
    }

    public boolean insert(History history)
    {
        String query = "insert into History (id, id_question, id_answer, id_user) values (?, ?, ?, ?)";

        return update(query, history);
    }

    public History getById(int id)
    {
        String query = "select * from History where id = ?";

        return getByID(query, id, new HistoryMapper());
    }
}
