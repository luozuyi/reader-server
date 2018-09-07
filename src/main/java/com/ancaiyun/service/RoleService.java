package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface RoleService {
    /**
     * 添加角色
     * @param name 角色名称
     * @param type 角色类型
     * @return
     */
    Result addRole(String name,String type);

    /**
     * 分页查询角色列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum,Integer pageSize);
}
