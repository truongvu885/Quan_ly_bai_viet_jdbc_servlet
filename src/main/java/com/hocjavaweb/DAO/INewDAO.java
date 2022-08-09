package com.hocjavaweb.DAO;

import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.paging.Pageble;

import java.util.List;

public interface INewDAO extends GenergicDAO<NewsModel>{
    NewsModel findOne(Long id);
    List<NewsModel> findByCategoryId(Long categoryId);
    Long save(NewsModel newsModel);
    void update(NewsModel UpdateNewsModel);
    void delete(Long ids);
    List<NewsModel> findAll(Pageble pageble);
    int getTotalItem();
}
