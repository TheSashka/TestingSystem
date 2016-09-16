package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.AbstractMapper;
import com.alexander.testingsystem.model.AbstractEntity;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;


public class AbstractDAO<E extends AbstractEntity> {
    public AbstractDAO()
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
        this.jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
    }

    private JdbcTemplate jdbcTemplate;

    public boolean insert(final String query, final Object[] entity) {
        return jdbcTemplate.update(query, entity) != 0;
    }

    public boolean update(final String query, final E entity) {
        return jdbcTemplate.update(query, entity) != 0;
    }

    public boolean delete(final String query, final long id) {
        return jdbcTemplate.update(query, id) != 0;
    }

    public E getByID(final String query, final long id, final AbstractMapper<E> mapper) {
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    public List<E> getAll(final String query, final AbstractMapper<E> mapper) {
        return jdbcTemplate.query(query, mapper);
    }
}
