package com.ancaiyun.controller;

import com.ancaiyun.service.ChannelArticleTemplateService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChannelArticleTemplateController {
    @Autowired
    private ChannelArticleTemplateService channelArticleTemplateService;

    /**
     * 分页查询模板列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/channel-article-templates/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum,Integer pageSize){
        return channelArticleTemplateService.listPage(pageNum, pageSize);
    }

    /**
     * 添加模板
     * @param tplUrl 模板路径名称
     * @param type 模板类型 0：文章模板 1：栏目模板
     * @return
     */
    @RequestMapping(value = "v1/auth/channel-article-templates",method = RequestMethod.POST)
    public Result addChannelArticleTemplate(String tplUrl, String type){
        return channelArticleTemplateService.addChannelArticleTemplate(tplUrl, type);
    }

    /**
     * 动态分页条件查询模板
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @param params 参数map
     * @return
     */
    @RequestMapping(value = "v1/auth/channel-article-templates/pagination/selection",method = RequestMethod.GET)
    public Result listPageBySelect(Integer pageNum,Integer pageSize,@RequestParam Map<String, Object> params) {
        return channelArticleTemplateService.listPageBySelect(pageNum, pageSize, params);
    }

    /**
     * 删除模板
     * @param id 主键id
     * @return
     */
    @RequestMapping(value = "v1/auth/channel-article-templates",method = RequestMethod.DELETE)
    public Result delChannelArticleTemplate(String id) {
        return channelArticleTemplateService.delChannelArticleTemplate(id);
    }
}
