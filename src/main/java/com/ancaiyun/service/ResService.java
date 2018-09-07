package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface ResService {
    /**
     * 分页查询资源列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum,Integer pageSize);

    /**
     * 查询角色拥有的权限类型
     * @param roleId
     * @return
     */
    Result listByRoleId(String roleId);
}
