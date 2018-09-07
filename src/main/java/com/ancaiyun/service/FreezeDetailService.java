package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

public interface FreezeDetailService {

    /**
     * 分页条件查询会员冻结明细
     * @param pageNo 当前页数
     * @param pageSize 每页显示多少条
     * @param params 查询参赛
     * @return
     */
    Result pageList(Integer pageNo, Integer pageSize, Map<String,Object> params);
}
