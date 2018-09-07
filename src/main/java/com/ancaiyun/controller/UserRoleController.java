package com.ancaiyun.controller;

import com.ancaiyun.service.UserRoleService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 给用户分配角色，可选择性
     * @param userId 用户id
     * @param roleIds 角色id数组
     * @return
     */
    @RequestMapping(value = "v1/auth/user-roles/selection",method = RequestMethod.POST)
    public Result addUserRole(String userId, @RequestParam(value = "roleIds[]") String[] roleIds) {
        return userRoleService.addUserRole(userId, roleIds);
    }
}
