package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface UserRoleService {
    /**
     * 给用户分配角色
     * @param userId 用户id
     * @param roleIds 角色id数组
     * @return
     */
    Result addUserRole(String userId, String[] roleIds);
}
