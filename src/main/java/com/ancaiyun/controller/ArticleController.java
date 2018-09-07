package com.ancaiyun.controller;

import com.ancaiyun.entity.Article;
import com.ancaiyun.service.ArticleService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 分页查询文章列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/articles/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize) {
        return articleService.listPage(pageNum, pageSize);
    }

    /**
     * 删除文章
     * @param id 主键id
     * @return
     */
    @RequestMapping(value = "v1/auth/articles",method = RequestMethod.DELETE)
    public Result delById(String id) {
        return articleService.delById(id);
    }

    /**
     * 添加文章
     * @param article 文章对象
     * @param content 文章内容
     * @return
     */
    @RequestMapping(value = "v1/auth/articles",method = RequestMethod.POST)
    public Result addArticle(Article article, String content) {
        return articleService.addArticle(article, content);
    }

    /**
     * 修改文章
     * @param article 文章对象
     * @param content 文章内容
     * @return
     */
    @RequestMapping(value = "v1/auth/articles",method = RequestMethod.PUT)
    public Result updateArticle(Article article, String content) {
        return articleService.updateArticle(article, content);
    }
}
