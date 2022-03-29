package com.hocjavaweb.DAO;

import com.hocjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();
}
