package com.ancaiyun.controller;

import com.ancaiyun.service.MemberService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 动态分页查询会员
     * @param pageNum 当前页数
     * @param pageSize 一页显示多少条
     * @param params map参数条件
     * @return
     */
    @RequestMapping(value = "v1/auth/members/pagination/selection",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize, @RequestParam Map<String, Object> params) {
        return memberService.listPage(pageNum, pageSize, params);
    }

    /**
     * 详情
     * @param memberId 会员id
     * @return
     */
    @RequestMapping(value = "v1/auth/members/member-id",method = RequestMethod.GET)
    public Result detail(String memberId) {
        return memberService.detail(memberId);
    }
}
