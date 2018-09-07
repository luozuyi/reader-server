package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

public interface ChildAccountService {
    /**
     * 通过父账号动态分页查询子账号列表
     * @param params map参数
     * memberId
     * @return
     */
    Result selectByMemberId(Integer pageNum, Integer pageSize,Map<String,Object> params);
}
