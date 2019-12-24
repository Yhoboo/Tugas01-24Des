package com.yhoboo.challenge3.service;

import com.yhoboo.challenge3.dao.UserDao;
import com.yhoboo.challenge3.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity findById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public UserEntity findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        userDao.insertUser(userEntity);
    }

    @Override
    public List<UserEntity> listByRoleId(int listRoleId) {
        return userDao.listByRoleId(listRoleId);
    }
}
