package com.ancaiyun.service;

import com.ancaiyun.entity.AdminRole;
import com.ancaiyun.utils.Result;

public interface AdminRoleService {
    /**
     * 添加后台角色
     * @param roleName 角色名称
     * @param info 角色描述
     * @return
     */
    Result addAdminRole(String roleName,String info);

    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);

    /**
     * 修改角色相关信息
     * @param adminRole 角色名称
     * @return
     */
    Result updateAdminRoleById(AdminRole adminRole);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Result deleteById(String id);
}
