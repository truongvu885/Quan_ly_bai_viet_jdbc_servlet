package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.ICategoryDAO;
import com.hocjavaweb.mapper.CategoryMapper;

import com.hocjavaweb.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from category ";
        return query(sql, new CategoryMapper());
    }
}
