package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.GenergicDAO;
import com.hocjavaweb.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements GenergicDAO<T> {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    public Connection getConnection() {
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String passWord = resourceBundle.getString("passWord");
            return DriverManager.getConnection(url, user, passWord);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //open connection
        Connection connection = getConnection();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                //set parameter
                setParameter(statement, parameters);
                resultSet = statement.executeQuery();
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
                else if(parameter instanceof Integer){
                    statement.setInt(index,(Integer) parameter);
                }
                else if(parameter instanceof Timestamp){
                    statement.setTimestamp(index,(Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(String sql, Object... parameter) {
        Connection connection =null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement,parameter);
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
           if(connection!=null){
               try{
                   connection.rollback();
               }catch (SQLException e1){
                   e1.printStackTrace();
               }
           }
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameter) {
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet =null;
        Long id = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            setParameter(statement,parameter);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        }catch (SQLException e){
            if(connection!=null){
                try{
                    connection.rollback();
                }catch (SQLException e1){
                    return null;
                }
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
                if(resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    @Override
    public int count(String sql, Object... parameters) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //open connection
        Connection connection = getConnection();
        if (connection != null) {
            try {
                int count = 0;
                statement = connection.prepareStatement(sql);
                //set parameter
                setParameter(statement, parameters);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
                return count;
            } catch (SQLException e) {
                return 0;
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
                    return 0;
                }
            }
        }
        return 0;
    }
}
