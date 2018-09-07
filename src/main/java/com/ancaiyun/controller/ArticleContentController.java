package com.ancaiyun.controller;

import com.ancaiyun.service.ArticleContentService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleContentController {
    @Autowired
    private ArticleContentService articleContentService;

    /**
     * 分页查询文章内容
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/artilce-contents/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize) {
        return articleContentService.listPage(pageNum, pageSize);
    }
}
