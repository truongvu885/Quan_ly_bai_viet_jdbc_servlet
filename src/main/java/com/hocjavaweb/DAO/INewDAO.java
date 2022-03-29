package com.hocjavaweb.DAO;

import com.hocjavaweb.model.NewsModel;

import java.util.List;

public interface INewDAO {
    List<NewsModel> findByCategoryId(Long categoryId);
}
