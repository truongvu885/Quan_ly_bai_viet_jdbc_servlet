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
            return news;
        } catch (SQLException e) {
           return null;
        }
    }
}
