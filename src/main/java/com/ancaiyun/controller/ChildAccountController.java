package com.ancaiyun.controller;

import com.ancaiyun.service.ChildAccountService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChildAccountController {
    @Autowired
    private ChildAccountService childAccountService;

    /**
     * 父账号查询子账号
     * @param params
     * memberId 会员id
     * @return
     */
    @RequestMapping(value = "v1/auth/child-accounts/member-id",method = RequestMethod.GET)
    public Result selectByMemberId(Integer pageNum,Integer pageSize,@RequestParam Map<String,Object> params) {
        return childAccountService.selectByMemberId(pageNum, pageSize,params);
    }
}
