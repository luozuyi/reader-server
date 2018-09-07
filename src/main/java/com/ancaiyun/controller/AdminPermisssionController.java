package com.ancaiyun.controller;

import com.ancaiyun.entity.AdminPermisssion;
import com.ancaiyun.service.AdminPermisssionService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminPermisssionController {
    @Autowired
    private AdminPermisssionService adminPermisssionService;

    /**
     * 新增权限
     * @param adminPermisssion 管理员权限对象
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-permisssions",method = RequestMethod.POST)
    public Result addAdminPermisssion(AdminPermisssion adminPermisssion){
        return adminPermisssionService.addAdminPermisssion(adminPermisssion);
    }

    /**
     * 删除后台管理员权限
     * @param id 主键id
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-permisssions",method = RequestMethod.DELETE)
    public Result deleteAdminPermisssion(String id){
        return adminPermisssionService.deleteAdminPermisssion(id);
    }

    /**
     * 分页查询后台权限列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/admin-permisssions/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize){
        return adminPermisssionService.listPage(pageNum, pageSize);
    }
}
