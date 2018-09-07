package com.ancaiyun.controller;

import com.ancaiyun.service.MemberBankService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MemberBankManagerController {

    @Autowired
    private MemberBankService memberBankService;

    /**
     * 条件分页查询用户银行账号
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参数
     * @return
     */
    @GetMapping("v1/auth/member-banks")
    public Result pageList(Integer pageNo, Integer pageSize, @RequestParam Map<String, Object> params){
        return memberBankService.pageList(pageNo, pageSize, params);
    }
}
