package com.ancaiyun.service;

import com.ancaiyun.entity.Admin;
import com.ancaiyun.utils.Result;

import java.util.Map;

public interface AdminService {
    /**
     * 添加后台管理员
     * @param adminName
     * @param adminPassword
     * @param adminRealName
     * @return
     */
    Result addAdmin(String adminName,String adminPassword,String adminRealName);

    /**
     * 动态分页查询管理员列表
     * @param params 参数的map
     * @return
     */
    Result listPageBySelect(Integer pageNum,Integer pageSize,Map<String, Object> params);

    /**
     * 修改管理员名称
     * @param admin
     * @return
     */
    Result updateAdminById(Admin admin);

    /**
     * 删除管理员 实际假删除
     * @param id
     * @return
     */
    Result deleteById(String id);

    /**
     * 禁用管理员
     * @param id 主键id
     * @param adminStatus
     * @return
     */
    Result updateAdminForbbindById(String id,String adminStatus);
}
