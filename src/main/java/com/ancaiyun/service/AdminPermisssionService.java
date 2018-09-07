package com.ancaiyun.service;

import com.ancaiyun.entity.AdminPermisssion;
import com.ancaiyun.utils.Result;

public interface AdminPermisssionService {
    /**
     * 添加权限
     * @param adminPermisssion 权限对象
     * @return
     */
    Result addAdminPermisssion(AdminPermisssion adminPermisssion);

    /**
     * 删除权限
     * @param id 主键id
     * @return
     */
    Result deleteAdminPermisssion(String id);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result listPage(Integer pageNum,Integer pageSize);
}
