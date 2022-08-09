package com.hocjavaweb.mapper;

import com.hocjavaweb.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewsModel>{
    @Override
    public NewsModel mapRow(ResultSet rs) {
        NewsModel news = new NewsModel();
        try {
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getString("title"));
            news.setThumbnail(rs.getString("thumbnail"));
            news.setSort_descri(rs.getString("sort_descri"));
            news.setContent(rs.getString("content"));
            news.setCategory_id(rs.getLong("category_id"));
            news.setCreatedDate(rs.getTimestamp("createddate"));
            news.setCreatedBy(rs.getString("createdby"));
            if(rs.getTimestamp("modifieddate")!=null){
                news.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if(rs.getString("modifiedby")!=null){
                news.setModifiedby(rs.getString("modifiedby"));
            }
            return news;
        } catch (SQLException e) {
           return null;
        }
    }
}
