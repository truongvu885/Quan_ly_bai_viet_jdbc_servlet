package com.hocjavaweb.service.impl;

import com.hocjavaweb.DAO.ICategoryDAO;
import com.hocjavaweb.model.CategoryModel;
import com.hocjavaweb.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;
    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
