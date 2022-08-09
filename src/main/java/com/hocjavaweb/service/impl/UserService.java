package com.hocjavaweb.service.impl;

import com.hocjavaweb.DAO.IUserDAO;
import com.hocjavaweb.model.UserModel;
import com.hocjavaweb.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {

    @Inject
    private IUserDAO userDAO;

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String passWord, int status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName,passWord,status);
    }
}
