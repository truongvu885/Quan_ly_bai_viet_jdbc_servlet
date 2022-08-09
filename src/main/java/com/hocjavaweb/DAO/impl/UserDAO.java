package com.hocjavaweb.DAO.impl;

import com.hocjavaweb.DAO.IUserDAO;
import com.hocjavaweb.mapper.UserMapper;
import com.hocjavaweb.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String passWord, int status) {
        StringBuilder sql = new StringBuilder("select * from user as u ") ;
        sql.append(" inner join role as r on r.id = u.role_id");
        sql.append(" where userName = ? and password = ? and status = ?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), userName,passWord,status);
       // return query(sql, new UserMapper);
        return !users.isEmpty() ? users.get(0) : null ;
    }
}
