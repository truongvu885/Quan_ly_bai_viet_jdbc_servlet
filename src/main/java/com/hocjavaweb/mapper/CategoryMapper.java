package com.hocjavaweb.mapper;

import com.hocjavaweb.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel category = new CategoryModel();
        try {
            category.setId(rs.getLong("id"));
            category.setCode(rs.getString("code"));
            category.setName(rs.getString("name"));
            return category;
        } catch (SQLException e) {
            return null;
        }
    }
}
