package com.ancaiyun.controller;

import com.ancaiyun.service.RoleService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     * @param name 角色名称
     * @param type 角色类型
     * @return
     */
    @RequestMapping(value = "v1/auth/roles",method = RequestMethod.POST)
    public Result addRole(String name, String type) {
        return roleService.addRole(name, type);
    }

    /**
     * 分页查询角色列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/roles/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize) {
        return roleService.listPage(pageNum, pageSize);
    }
}
