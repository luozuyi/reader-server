package com.ancaiyun.controller;

import com.ancaiyun.entity.Admin;
import com.ancaiyun.service.AdminService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 添加后台管理员
     * @param adminName 后台登陆名
     * @param adminPassword 登陆密码
     * @param adminRealName 真实姓名
     * @return
     */
    @RequestMapping(value = "v1/auth/admins",method = RequestMethod.POST)
    public Result addAdmin(String adminName, String adminPassword, String adminRealName){
        return adminService.addAdmin(adminName, adminPassword, adminRealName);
    }

    /**
     * 带条件分页动态查询
     * @param params 参数的map
     * @return
     */
    @RequestMapping(value = "v1/auth/admins/pagination",method = RequestMethod.GET)
    public Result listPageBySelect(Integer pageNum,Integer pageSize,@RequestParam Map<String, Object> params){
        return adminService.listPageBySelect(pageNum,pageSize,params);
    }

    /**
     * 修改管理员部分信息
     * @param admin 管理员对象
     * @return
     */
    @RequestMapping(value = "v1/auth/admins/selection",method = RequestMethod.PUT)
    public Result updateAdminById(Admin admin){
        return adminService.updateAdminById(admin);
    }

    /**
     * 删除管理员
     * @param id 主键id
     * @return
     */
    @RequestMapping(value = "v1/auth/admins",method = RequestMethod.DELETE)
    public Result deleteById(String id){
        return adminService.deleteById(id);
    }

    /**
     * 禁用管理员
     * @param id 主键id
     * @return
     */
    @RequestMapping(value = "v1/auth/admins/forbidden",method = RequestMethod.PATCH)
    public Result updateAdminForbbindById(String id){
        return adminService.updateAdminForbbindById(id,"1");
    }
}
