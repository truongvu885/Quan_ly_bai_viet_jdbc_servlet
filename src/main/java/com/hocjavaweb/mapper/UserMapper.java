package com.hocjavaweb.mapper;

import com.hocjavaweb.model.RoleModel;
import com.hocjavaweb.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel>{

    @Override
    public UserModel mapRow(ResultSet rs) {
        UserModel userModel = new UserModel();

        try {
            userModel.setId(rs.getLong("id"));
            userModel.setUserName(rs.getString("userName"));
            userModel.setPassWord((rs.getString("password")));
            userModel.setFullName(rs.getString("fullname"));
            userModel.setStatus(rs.getInt("status"));
            userModel.setRole_id(rs.getLong("role_id"));
            try {
                RoleModel role = new RoleModel();
                role.setCode(rs.getString("code"));
                role.setName(rs.getString("name"));
                userModel.setRole(role);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
//            userModel.setCreatedDate(rs.getTimestamp("u.createddate"));
//            userModel.setCreatedBy(rs.getString("u.createdby"));
//            if(rs.getTimestamp("u.modifieddate")!=null){
//                userModel.setModifiedDate(rs.getTimestamp("u.modifieddate"));
//            }
//            if(rs.getString("u.modifiedby")!=null){
//                userModel.setModifiedby(rs.getString("u.modifiedby"));
//            }
            return userModel;
        } catch (SQLException e) {
            return null;
        }
    }
}
