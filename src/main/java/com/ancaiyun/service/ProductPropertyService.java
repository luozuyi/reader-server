package com.ancaiyun.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

public interface ProductPropertyService {

    /**
     * 根据三类id分页查询属性
     * @param pageNum 当前页数
     * @param pageSize 每页多少条
     * @param params 查询参数
     * @return
     */
    Result getPageListByProductSubCategoryId(Integer pageNum, Integer pageSize, Map<String, String> params);

    /**
     * 添加商品属性
     * @param params 查询参数
     * @return
     */
    Result addProductProperty(Map<String, String> params);

    /**
     * 根据id删除属性
     * @param id 属性id
     * @return
     */
    Result deleteById(String id);

    /**
     * 分页查询所有属性
     * @param pageNum 当前页数
     * @param pageSize 一页显示多少条
     * @return
     */
    Result pageList(Integer pageNum, Integer pageSize);
}
