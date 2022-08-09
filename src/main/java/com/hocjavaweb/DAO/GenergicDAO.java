package com.hocjavaweb.DAO;

import com.hocjavaweb.mapper.RowMapper;

import java.util.List;

public interface GenergicDAO<T> {
   <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
   void update(String sql, Object... parameter);
   Long insert(String sql, Object... parameter);
   int count(String sql,Object... parameters);
}
