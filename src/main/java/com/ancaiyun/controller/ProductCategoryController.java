package com.ancaiyun.controller;

import com.ancaiyun.entity.ProductCategory;
import com.ancaiyun.service.ProductCategoryService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 分页查询商品类型
     * @param pageNum 当前页数
     * @param pageSize 一页显示多少条
     * @return
     */
    @GetMapping("v1/auth/product-categorys")
    public Result listPage(Integer pageNum, Integer pageSize){
        return productCategoryService.listPage(pageNum, pageSize);
    }

    /**
     * 添加商品类型
     * @param productCategory 商品类型
     * @return
     */
    @PostMapping("v1/auth/product-categorys")
    public Result addproductCategory(ProductCategory productCategory){
        return productCategoryService.addproductCategory(productCategory);
    }

    /**
     * 根据id删除商品类型
     * @param id 主键id
     * @return
     */
    @DeleteMapping("v1/auth/product-categorys")
    public Result deleteById(String id){
        return productCategoryService.deleteById(id);
    }

    /**
     * 根据id修改商品类型
     * @param id 主键id
     * @param typeName 类型名称
     * @return
     */
    @PutMapping("v1/auth/product-categorys")
    public Result updateProductCategoryById(String id, String typeName){
        return productCategoryService.updateProductCategoryById(id, typeName);
    }
}
