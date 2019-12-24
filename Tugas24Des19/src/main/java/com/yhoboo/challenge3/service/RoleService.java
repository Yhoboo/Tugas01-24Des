package com.yhoboo.challenge3.service;

import com.yhoboo.challenge3.entity.RoleEntity;

public interface RoleService {

    public RoleEntity findByRoleId(int roleId);
    public RoleEntity findByRoleName(String roleName);

    public void insertRole(RoleEntity roleEntity);
}
