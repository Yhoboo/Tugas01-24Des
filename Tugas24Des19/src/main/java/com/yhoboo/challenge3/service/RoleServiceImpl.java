package com.yhoboo.challenge3.service;

import com.yhoboo.challenge3.dao.RoleDao;
import com.yhoboo.challenge3.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public RoleEntity findByRoleId(int roleId) {
        return roleDao.findByRoleId(roleId);
    }

    @Override
    public RoleEntity findByRoleName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }

    @Override
    public void insertRole(RoleEntity roleEntity) {
        roleDao.insertRole(roleEntity);
    }
}
