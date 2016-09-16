package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.UserMapper;
import com.alexander.testingsystem.model.User;
import org.apache.commons.dbcp.BasicDataSource;

import java.util.List;


public class UserDAOJDBCTemplateImpl extends AbstractDAO<User> {

    public UserDAOJDBCTemplateImpl(final BasicDataSource dataSource) {
        super(dataSource);
    }

    public boolean insert(User user) {
        String query = "insert into User (id, login, email, password) values (?, ?, ?, ?)";

        return insert(query, user);
    }

    public User getById(int id) {
        String query = "select * from User where id = ?";

        //using RowMapper anonymous class, we can create a separate RowMapper for reuse
        return getByID(query, id, new UserMapper());
    }

    public boolean update(User user) {
        String query = "update User set login=?, email=?, password=? where id=?";

        return update(query, user);
    }

    public boolean deleteById(int id) {
        String query = "delete from User where id=?";

        return delete(query, id);
    }

    public List<User> getAll() {
        String query = "select * from User";
        return getAll(query, new UserMapper());
    }
}
