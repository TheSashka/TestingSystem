package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.UserMapper;
import com.alexander.testingsystem.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public final class UserDAOJDBCTemplateImpl extends AbstractDAO<User> {

    public UserDAOJDBCTemplateImpl() {
        super();
    }

    public boolean insert(User user) {
        String query = "insert into User (login, email, password) values(?, ?, ?)";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Object[] values = new Object[]{user.getLogin(), user.getEmail(), user.getPassword()};
        return insert(query, values);
    }

    public User getById(long id) {
        String query = "select * from User where id = ?";

        //using RowMapper anonymous class, we can create a separate RowMapper for reuse
        return getByID(query, id, new UserMapper());
    }

    public boolean update(User user) {
        String query = "update User set login=?, email=?, password=? where id=?";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Object[] values = new Object[]{user.getLogin(), user.getEmail(), user.getPassword(), user.getId()};
        return update(query, values);
    }

    public boolean deleteById(long id) {
        String query = "delete from User where id=?";

        return delete(query, id);
    }

    public List<User> getAll() {
        String query = "select * from User";
        return getAll(query, new UserMapper());
    }

    public int checkLogin(String login) {
        String query = "select count(*) from User where login=?";
        return getByObject(query, new Object[]{login});
    }

    public int checkEmail(String email) {
        String query = "select count(*) from User where email=?";
        return getByObject(query, new Object[]{email});
    }

    public int checkLoginAndPassword(String login, String password) {
        String query = "select count(*) from User where login=? and password=?";
        return getByObject(query, new Object[]{login, password});
    }

    public User getByLogin(String name) {
        String query = "select * from User where login=?";
        return getByObject(query, new Object[]{name}, new UserMapper());
    }

    public User getByEmail(String email) {
        String query = "select * from User where email=?";
        return getByObject(query, new Object[]{email}, new UserMapper());
    }
}
