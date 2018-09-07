package com.ancaiyun.controller;

import com.ancaiyun.service.AdminAdminRoleService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAdminRoleController {
    @Autowired
    private AdminAdminRoleService adminAdminRoleService;

    /**
     * 给某个管理员分配某个权限
     * @param adminId 管理员
     * @param adminRoleId 管理员角色id
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-admin-roles",method = RequestMethod.POST)
    public Result addAdminAdminRole(String adminId, String adminRoleId){
        return adminAdminRoleService.addAdminAdminRole(adminId, adminRoleId);
    }

    /**
     *给管理员分配角色，可多选
     * @param adminId
     * @param adminRoleIds
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-admin-roles/secection",method = RequestMethod.POST)
    public Result addAdminAdminRoles(String adminId, @RequestParam(value = "adminRoleIds[]") String[] adminRoleIds){
        return adminAdminRoleService.addAdminAdminRoles(adminId, adminRoleIds);
    }
}
