package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

public interface MemberService {
    /**
     * 分页查询会员相关信息
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @param params 参数map
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize, Map<String,Object> params);

    /**
     * 审核详情
     * @param memberId 会员id
     * @return
     */
    Result detail(String memberId);
}
