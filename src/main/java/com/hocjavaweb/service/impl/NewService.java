package com.hocjavaweb.service.impl;

import com.hocjavaweb.DAO.INewDAO;
import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.service.INewService;

import javax.inject.Inject;
import java.util.List;

public class NewService implements INewService {

    @Inject
    private INewDAO newDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        Long newId = newDAO.save(newsModel);
        return newsModel;
    }
}
