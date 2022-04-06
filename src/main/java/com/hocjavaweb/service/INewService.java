package com.hocjavaweb.service;

import com.hocjavaweb.model.NewsModel;

import java.util.List;

public interface INewService {
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
}
