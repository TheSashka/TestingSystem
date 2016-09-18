package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.ThemeMapper;
import com.alexander.testingsystem.model.Theme;

import java.util.List;

public final class ThemeDAOJDBCTemplate extends AbstractDAO<Theme>
{
    public ThemeDAOJDBCTemplate() {
        super();
    }

    public boolean insert(Theme theme)
    {
        String query = "insert into Theme (name) values (?)";
        Object[] values = new Object[]{ theme.getName() };
        return insert(query, values);
    }

    public boolean update(Theme theme)
    {
        String query = "update Theme set name=? where id=?";

        return update(query, theme);
    }

    public boolean deleteById(int id)
    {
        String query = "delete from Theme where id=?";

        return delete(query, id);
    }

    public Theme getById(int id)
    {
        String query = "select * from Theme where id = ?";

        return getByID(query, id, new ThemeMapper());
    }

    public List<Theme> getAll()
    {
        String query = "select * from User";
        return getAll(query, new ThemeMapper());
    }
}
