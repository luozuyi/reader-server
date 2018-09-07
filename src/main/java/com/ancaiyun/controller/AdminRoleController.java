package com.ancaiyun.controller;

import com.ancaiyun.entity.AdminRole;
import com.ancaiyun.service.AdminRoleService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRoleController {
    @Autowired
    private AdminRoleService adminRoleService;

    /**
     * 新增管理员角色
     * @param roleName 角色名称
     * @param info 角色描述
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-roles",method = RequestMethod.POST)
    public Result addAdminRole(String roleName,String info){
        return adminRoleService.addAdminRole(roleName, info);
    }

    /**
     * 分页查询角色列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-roles/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize){
        return adminRoleService.listPage(pageNum, pageSize);
    }

    /**
     * 修改管理员角色
     * @param adminRole
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-roles",method = RequestMethod.PUT)
    public Result updateAdminRoleById(AdminRole adminRole){
        return adminRoleService.updateAdminRoleById(adminRole);
    }

    /**
     * 删除管理员角色 假删除
     * @param id 主键id
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-roles",method = RequestMethod.DELETE)
    public Result deleteById(String id){
        return adminRoleService.deleteById(id);
    }
}
