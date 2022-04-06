package com.hocjavaweb.DAO;

import com.hocjavaweb.mapper.RowMapper;

import java.util.List;

public interface GenergicDAO<T> {
   List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
}
