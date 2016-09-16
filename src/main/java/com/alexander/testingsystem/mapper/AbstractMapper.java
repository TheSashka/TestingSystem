package com.alexander.testingsystem.mapper;

import com.alexander.testingsystem.model.AbstractEntity;
import org.springframework.jdbc.core.RowMapper;

public abstract class AbstractMapper <E extends AbstractEntity> implements RowMapper<E> {
}
