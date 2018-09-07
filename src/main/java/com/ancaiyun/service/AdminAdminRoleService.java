package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface AdminAdminRoleService {
    /**
     * 给用户分配角色，单一分配
     * @param adminId
     * @param adminRoleId
     * @return
     */
    Result addAdminAdminRole(String adminId,String adminRoleId);

    /**
     * 给用户分配角色，分配多个角色
     * @param adminId
     * @param adminRoleIds
     * @return
     */
    Result addAdminAdminRoles(String adminId,String[] adminRoleIds);
}
