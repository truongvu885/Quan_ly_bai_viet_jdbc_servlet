package com.hocjavaweb.service;

import com.hocjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
}
