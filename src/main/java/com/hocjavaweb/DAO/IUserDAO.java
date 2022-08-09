package com.hocjavaweb.DAO;

import com.hocjavaweb.model.UserModel;

public interface IUserDAO extends GenergicDAO<UserModel> {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String passWord, int status);
}
