package com.alexander.testingsystem.dao;

import com.alexander.testingsystem.mapper.AbstractMapper;
import com.alexander.testingsystem.model.AbstractEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public abstract class AbstractDAO<E extends AbstractEntity> {
    public AbstractDAO()
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
        this.jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
    }
    private JdbcTemplate jdbcTemplate;

    public boolean insert(final String query, final Object[] entity) {
        return jdbcTemplate.update(query, entity) != 0;
    }

    public boolean update(final String query, final Object[] entity) {
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

    public int getByObject(final String query, final Object[] item) {
        return jdbcTemplate.queryForObject(query, item, Integer.class);
    }

    public List<E> getByOtherID(final String query, final long id, final  AbstractMapper<E> mapper){
        return jdbcTemplate.query(query, new Object[]{id}, mapper);
    }

    public E getByObject(final  String query, final Object[] objects,  final  AbstractMapper<E> mapper)
    {
        return jdbcTemplate.queryForObject(query, objects, mapper);
    }
}
