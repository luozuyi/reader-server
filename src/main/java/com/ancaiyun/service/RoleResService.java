package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface RoleResService {
    /**
     * 给角色分配资源
     * @param roleId 角色id
     * @param resIds 资源id数组
     * @return
     */
    Result addRoleRes(String roleId,String[] resIds);
}
