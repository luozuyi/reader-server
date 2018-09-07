package com.ancaiyun.controller;

import com.ancaiyun.service.AdminRolePermisssionService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRolePermisssionController {
    @Autowired
    private AdminRolePermisssionService adminRolePermisssionService;

    /**
     * 给角色分配权限，可以多选
     * @param adminRoleId 角色id
     * @param adminPermisssionIds 权限id数组
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-role-permisssions/selection",method = RequestMethod.POST)
    public Result addAdminRolePermisssion(String adminRoleId, @RequestParam(value = "adminPermisssionIds[]") String[] adminPermisssionIds){
       return adminRolePermisssionService.addAdminRolePermisssion(adminRoleId, adminPermisssionIds);
    }
}
