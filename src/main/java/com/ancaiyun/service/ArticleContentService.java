package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface ArticleContentService {
    /**
     * 分页查询文章内容
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum,Integer pageSize);
}
