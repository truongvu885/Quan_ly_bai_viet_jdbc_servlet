package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.INewDAO;
import com.hocjavaweb.mapper.NewMapper;
import com.hocjavaweb.model.NewsModel;

import java.util.List;

public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "select * from news where category_id = ?";
        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) {
        String sql = "insert into news(title,content,category_id) values (?,?,?)";
        return insert(sql,newsModel.getTitle(),newsModel.getContent(),newsModel.getCategory_id());
    }

    @Override
    public void update(NewsModel newsModel) {
        String sql = "update news set title";
    }
}
