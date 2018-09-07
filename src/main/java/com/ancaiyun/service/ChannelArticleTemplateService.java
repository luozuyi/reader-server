package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

public interface ChannelArticleTemplateService {
    /**
     * 分页查询模板猎豹
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);

    /**
     * 添加模板
     * @param tplUrl 模板路径
     * @param type 模板类型 0：文章模板 1：栏目模板
     * @return
     */
    Result addChannelArticleTemplate(String tplUrl,String type);

    /**
     * 动态分页查询
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @param params 参数
     * @return
     */
    Result listPageBySelect(Integer pageNum, Integer pageSize, Map<String,Object> params);

    /**
     * 删除模板
     * @param id 主键id
     * @return
     */
    Result delChannelArticleTemplate(String id);
}
