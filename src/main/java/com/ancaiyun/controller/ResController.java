package com.ancaiyun.controller;

import com.ancaiyun.service.ResService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResController {
    @Autowired
    private ResService resService;

    /**
     * 分页查询资源列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/ress/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize) {
        return resService.listPage(pageNum, pageSize);
    }

    /**
     * 角色id
     * @param roleId 角色id
     * @return
     */
    @RequestMapping(value = "v1/auth/ress/list",method = RequestMethod.GET)
    public Result listByRoleId(String roleId) {
        return resService.listByRoleId(roleId);
    }
}
