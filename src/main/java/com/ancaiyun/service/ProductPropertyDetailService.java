package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

public interface ProductPropertyDetailService {

    /**
     *
     * @param pageNum 当前页数
     * @param pageSize 每页显示多少条
     * @param productPropertyId 商品属性id
     * @return
     */
    Result getPageListByProductPropertyId(Integer pageNum, Integer pageSize, String productPropertyId);

    /**
     * 添加属性详情
     * @param value 详情值
     * @param productPropertyId 属性id
     * @return
     */
    Result addProductPropertyDetail(String value, String productPropertyId);

    /**
     * 根据id删除属性详情
     * @param id 主键id
     * @return
     */
    Result deleteById(String id);
}
