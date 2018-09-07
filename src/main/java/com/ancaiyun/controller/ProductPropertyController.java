package com.ancaiyun.controller;

import com.ancaiyun.service.ProductPropertyService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductPropertyController {

    @Autowired
    private ProductPropertyService productPropertyService;

    /**
     * 根据三类id分页查询属性
     * @param pageNum 当前页数
     * @param pageSize 每页多少条
     * @param params 查询参数
     * @return
     */
    @GetMapping("v1/auth/product-propertys")
    public Result getPageListByProductSubCategoryId(Integer pageNum, Integer pageSize, @RequestParam Map<String, String> params){
        return productPropertyService.getPageListByProductSubCategoryId(pageNum , pageSize, params);
    }

    /**
     * 添加商品属性
     * @param params 查询参数
     * @return
     */
    @PostMapping("v1/auth/product-propertys")
    public Result addProductProperty(@RequestParam Map<String, String> params){
        return productPropertyService.addProductProperty(params);
    }

    /**
     * 根据id删除属性
     * @param id 属性id
     * @return
     */
    @DeleteMapping("v1/auth/product-propertys")
    public Result deleteById(String id){
        return productPropertyService.deleteById(id);
    }

    /**
     * 分页查询所有属性
     * @param pageNum 当前页数
     * @param pageSize 一页显示多少条
     * @return
     */
    @GetMapping("v1/auth/product-propertys/all")
    public Result pageList(Integer pageNum, Integer pageSize){
        return productPropertyService.pageList(pageNum, pageSize);
    }
}
