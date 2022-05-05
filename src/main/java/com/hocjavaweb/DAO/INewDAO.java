package com.hocjavaweb.DAO;

import com.hocjavaweb.model.NewsModel;

import java.util.List;

public interface INewDAO extends GenergicDAO<NewsModel>{
    List<NewsModel> findByCategoryId(Long categoryId);
    Long save(NewsModel newsModel);
    void update(NewsModel newsModel);
}
