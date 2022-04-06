package com.hocjavaweb.DAO;

import com.hocjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenergicDAO<CategoryModel> {
    List<CategoryModel> findAll();
}
