package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.AbstractEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractMapper <E extends AbstractEntity> implements RowMapper<E> {
    //TODO: SetId
    //TODO: Убрать ссылки у бара если не залогинен.
    //TODO: сделать свой тэг

}
