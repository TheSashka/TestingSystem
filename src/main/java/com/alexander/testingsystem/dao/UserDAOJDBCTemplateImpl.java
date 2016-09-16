package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.UserMapper;
import com.alexander.testingsystem.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserDAOJDBCTemplateImpl extends AbstractDAO<User> {

    public UserDAOJDBCTemplateImpl() {
        super();
    }

    public boolean insert(User user)
    {
        String query = "insert into User (login, email, password) values(?, ?, ?)";
        Object[] values = new Object[]{user.getLogin(), user.getEmail(), user.getPassword()};
        return insert(query, values);
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
