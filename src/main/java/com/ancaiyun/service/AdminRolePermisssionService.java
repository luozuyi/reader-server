package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface AdminRolePermisssionService {
    /**
     * 给角色分配权限
     * @param adminRoleId 角色id
     * @param adminPermisssionIds 权限id数组
     * @return
     */
    Result addAdminRolePermisssion(String adminRoleId,String[] adminPermisssionIds);
}
