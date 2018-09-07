package com.ancaiyun.controller;

import com.ancaiyun.service.RoleResService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleResController {
    @Autowired
    private RoleResService roleResService;

    /**
     * 给角色分配资源res
     * @param roleId 角色id
     * @param resIds 资源id数组
     * @return
     */
    @RequestMapping(value = "v1/auth/role-ress/selection",method = RequestMethod.POST)
    public Result addRoleRes(String roleId, @RequestParam(value = "resIds[]") String[] resIds) {
        return roleResService.addRoleRes(roleId, resIds);
    }
}
