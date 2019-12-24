package com.yhoboo.challenge3.service;

import com.yhoboo.challenge3.entity.UserEntity;

import java.util.List;

public interface UserService {

    public UserEntity findById (int userId);
    public UserEntity findByName (String username);
    public void insertUser(UserEntity userEntity);

    public List<UserEntity> listByRoleId (int listRoleId);

}
