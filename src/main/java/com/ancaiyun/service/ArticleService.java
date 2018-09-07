package com.ancaiyun.service;

import com.ancaiyun.entity.Article;
import com.ancaiyun.utils.Result;

public interface ArticleService {
    /**
     * 分页查询文章列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);

    /**
     * 删除文章
     * @param id 主键id
     * @return
     */
    Result delById(String id);

    /**
     * 添加文章
     * @param article 文章对象
     * @param content 内容
     * @return
     */
    Result addArticle(Article article,String content);

    /**
     * 修改文章
     * @param article 文章对象
     * @param content 文章内容
     * @return
     */
    Result updateArticle(Article article,String content);
}
