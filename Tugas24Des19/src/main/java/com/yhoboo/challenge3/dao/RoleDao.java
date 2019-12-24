package com.yhoboo.challenge3.dao;

import com.yhoboo.challenge3.entity.RoleEntity;

public interface RoleDao {

    RoleEntity findByRoleId (int roleId);
    RoleEntity findByRoleName (String roleName);

    void insertRole(RoleEntity roleEntity);
}
