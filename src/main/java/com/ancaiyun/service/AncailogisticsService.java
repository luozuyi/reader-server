package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface AncailogisticsService {

    /**
     * 一页显示多少条
     * @param pageNum 当前页数
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);
}
