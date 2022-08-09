package com.hocjavaweb.service;

import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.paging.Pageble;

import java.util.List;

public interface INewService {
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel updateNewsModel);
    void delete(Long[] ids);
    List<NewsModel> findAll(Pageble pageble);
    int getTotalItem();
}
