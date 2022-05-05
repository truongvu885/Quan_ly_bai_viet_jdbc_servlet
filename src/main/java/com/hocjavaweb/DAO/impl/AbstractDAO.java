package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.GenergicDAO;
import com.hocjavaweb.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenergicDAO<T> {
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
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //open connection
        Connection connection = getConnection();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                //set parameter
                setParameter(statement, parameters);
                while (resultSet.next()) {
                    results.add(rowMapper.mapRow(resultSet));
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

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                }
                else if(parameter instanceof String)
                {
                    statement.setString(index, (String) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
