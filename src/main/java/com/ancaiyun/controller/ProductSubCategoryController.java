package com.ancaiyun.controller;

import com.ancaiyun.entity.ProductSubCategory;
import com.ancaiyun.service.ProductSubCategoryService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSubCategoryController {

    @Autowired
    private ProductSubCategoryService productSubCategoryService;

    /**
     * 根据商品一类id查询商品二类
     * @param id 商品大类id
     * @return
     */
    @GetMapping("v1/auth/product-sub-categorys")
    public Result getListByProductCategoryId(String id){
        return productSubCategoryService.getListByProductCategoryId(id);
    }

    /**
     * 添加商品二类
     * @param productSubCategory 商品子类
     * @param id 商品大类id
     * @return
     */
    @PostMapping("v1/auth/product-sub-categorys")
    public Result addproductCategory(ProductSubCategory productSubCategory, String id){
        return productSubCategoryService.addproductSubCategory(productSubCategory, id);
    }

    /**
     * 根据商品二类id查询商品三类
     * @param id 商品大类id
     * @return
     */
    @GetMapping("v1/auth/product-sub-categorys/three")
    public Result getThreeCategoryList(String id){
        return productSubCategoryService.getThreeCategoryList(id);
    }

    /**
     * 添加商品三类
     * @param productSubCategory 商品三类
     * @param id 二类id
     * @return
     */
    @PostMapping("v1/auth/product-sub-categorys/three")
    public Result addThreeCategory(ProductSubCategory productSubCategory, String id){
        return productSubCategoryService.addThreeCategory(productSubCategory, id);
    }

    /**
     * 根据id删除商品子类
     * @param id 商品子类id
     * @return
     */
    @DeleteMapping("v1/auth/product-sub-categorys")
    public Result deleteById(String id){
        return productSubCategoryService.deleteById(id);
    }

    /**
     * 根据id修改商品子类名称
     * @param id
     * @param pcName
     * @return
     */
    @PutMapping("v1/auth/product-sub-categorys")
    public Result updateProductSubCategoryById(String id, String pcName){
        return productSubCategoryService.updateProductSubCategoryById(id, pcName);
    }
}
