package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

public interface MemberBankService {

    /**
     * 条件分页查询用户银行账号
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参数
     * @return
     */
    Result pageList(Integer pageNo, Integer pageSize, Map<String, Object> params);
}
