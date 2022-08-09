package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.INewDAO;
import com.hocjavaweb.mapper.NewMapper;
import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.paging.Pageble;

import java.util.ArrayList;
import java.util.List;

public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

    @Override
    public NewsModel findOne(Long id) {
        String sql = "select * from news where id = ?";
        List<NewsModel> news = query(sql, new NewMapper(), id);
        if (!news.isEmpty()) {
            return news.get(0);
        } else return null;
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "select * from news where category_id = ?";
        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) {
        String sql = "insert into news(title,thumbnail,sort_descri,content,category_id,createddate,createdby) values (?,?,?,?,?,?,?)";
        return insert(sql, newsModel.getTitle(),newsModel.getThumbnail(),newsModel.getSort_descri(),
                newsModel.getContent(), newsModel.getCategory_id(),newsModel.getCreatedDate(),newsModel.getCreatedBy());
    }

    @Override
    public void update(NewsModel UpdateNewsModel) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ? , thumbnail = ? , sort_descri = ?,");
        sql.append("content = ? , category_id = ?, ");
        sql.append("createddate = ? , createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), UpdateNewsModel.getTitle(), UpdateNewsModel.getThumbnail(), UpdateNewsModel.getSort_descri(), UpdateNewsModel.getContent(), UpdateNewsModel.getCategory_id(),
                UpdateNewsModel.getCreatedDate(), UpdateNewsModel.getCreatedBy(),
                UpdateNewsModel.getModifiedDate(),UpdateNewsModel.getModifiedby(), UpdateNewsModel.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from news where id = ?";
        update(sql,id);
    }

    @Override
    public List<NewsModel> findAll(Pageble pageble){
        StringBuilder sql = new StringBuilder("select * from news ");
        if(pageble.getSorter() != null){
            sql.append(" order by "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+" ");
        }
        if(pageble.getOffset() != null && pageble.getLimit() !=null){
            sql.append(" limit "+pageble.getOffset()+","+pageble.getLimit()+" ");
        }
            return query(sql.toString(),new NewMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "select count(*) from news";
        return count(sql);
    }
}
