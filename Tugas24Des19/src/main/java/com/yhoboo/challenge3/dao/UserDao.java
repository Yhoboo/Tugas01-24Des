package com.yhoboo.challenge3.dao;

import com.yhoboo.challenge3.entity.UserEntity;

import java.util.List;

public interface UserDao {

    UserEntity findById (int userId);
    UserEntity findByName (String username);
    void insertUser (UserEntity userEntity);

    List<UserEntity> listByRoleId(int listRoleId);
}
