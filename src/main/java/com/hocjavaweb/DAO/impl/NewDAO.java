package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.INewDAO;
import com.hocjavaweb.mapper.NewMapper;
import com.hocjavaweb.model.NewsModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        Long id = 0L;
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
            statement.setLong(3, newsModel.getCategory_id());
            statement.setString(1, newsModel.getTitle());
            statement.setString(2, newsModel.getContent());
            int rowAffected =  statement.executeUpdate();
            if(rowAffected == 1){
                resultSet = statement.getGeneratedKeys();
                if(resultSet.next()){
                    id = resultSet.getLong(1);
                }
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
               return null;
            }
            return null;
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    @Override
    public void update(NewsModel newsModel) {
        String sql = "update news set title";
    }
}
