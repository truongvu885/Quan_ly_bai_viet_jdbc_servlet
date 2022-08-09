package com.hocjavaweb.service;

import com.hocjavaweb.model.UserModel;

public interface IUserService{
    UserModel findByUserNameAndPasswordAndStatus(String userName, String passWord, int status);
}
