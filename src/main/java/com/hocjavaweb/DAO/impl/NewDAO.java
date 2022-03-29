package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.INewDAO;
import com.hocjavaweb.model.CategoryModel;
import com.hocjavaweb.model.NewsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewDAO implements INewDAO {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/newservlet_t3_2022";
            String user = "root";
            String passWord = "Truong@2102";
            return DriverManager.getConnection(url, user, passWord);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {

        List<NewsModel> results = new ArrayList<>();
        String sql = "select * from category";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //open connection
        Connection connection = getConnection();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    NewsModel news = new NewsModel();
                    news.setId(resultSet.getLong("id"));
                    news.setTitle(resultSet.getString("title"));
                    results.add(news);
                }
                return results;
            } catch (SQLException e) {
                return null;
            } finally {
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
        return null;
    }
}
