package com.ancaiyun.controller;

import com.ancaiyun.service.ProductPropertyDetailService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPropertyDetailController {

    @Autowired
    private ProductPropertyDetailService productPropertyDetailService;

    /**
     * 根据属性id分页查询属性详情
     * @param pageNum 当前页数
     * @param pageSize 每页显示多少条数
     * @param productPropertyId 商品属性id
     * @return
     */
    @GetMapping("v1/auth/product-property-details")
    public Result getPageListByProductPropertyId(Integer pageNum, Integer pageSize, String productPropertyId){
        return productPropertyDetailService.getPageListByProductPropertyId(pageNum, pageSize, productPropertyId);
    }

    /**
     * 添加属性详情
     * @param value 详情值
     * @param productPropertyId 属性id
     * @return
     */
    @PostMapping("v1/auth/product-property-details")
    public Result addProductPropertyDetail(String value, String productPropertyId){
        return productPropertyDetailService.addProductPropertyDetail(value, productPropertyId);
    }

    /**
     * 根据id删除属性详情
     * @param id 主键id
     * @return
     */
    @DeleteMapping("v1/auth/product-property-datails")
    public Result deleteById(String id){
        return productPropertyDetailService.deleteById(id);
    }
}
