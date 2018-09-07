package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

public interface WithdrawService {

    /**
     * 分页条件查询提现记录
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参赛
     * @return
     */
    Result pageList(Integer pageNo, Integer pageSize, Map<String,Object> params);

    /**
     * 审核提现
     * @param id 主键id
     * @param status 提现状态
     * @param note 提现备注
     * @param token 用户携带token
     * @return
     */
    Result approve(String id, String status, String note, String token);
}
