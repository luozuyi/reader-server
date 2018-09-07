package com.ancaiyun.service;

import com.ancaiyun.utils.Result;
import jdk.nashorn.internal.parser.Token;

import java.util.Map;

public interface OfflineRemittanceService {

    /**
     * 分页条件查询线下充值记录
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参数
     * @return
     */
    Result pageList(Integer pageNo, Integer pageSize, Map<String,Object> params);

    /**
     * 根据id查询线下充值记录详情
     * @param id 主键id
     * @return
     */
    Result getById(String id);

    /**
     * 审核线下充值
     * @param id 主键id
     * @param status 审核状态
     * @param token 用户携带token
     * @return
     */
    Result approve(String id, String status, String token);
}
