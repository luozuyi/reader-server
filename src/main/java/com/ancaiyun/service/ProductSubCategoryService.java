package com.ancaiyun.service;

import com.ancaiyun.entity.ProductSubCategory;
import com.ancaiyun.utils.Result;

public interface ProductSubCategoryService {

    /**
     * 根据商品大类id查询商品二类
     * @param id 商品大类id
     * @return
     */
    Result getListByProductCategoryId(String id);

    /**
     * 添加商品二类
     * @param productSubCategory 商品二类
     * @param id 商品大类id
     * @return
     */
    Result addproductSubCategory(ProductSubCategory productSubCategory, String id);

    /**
     * 根据商品二类id查询商品三类
     * @param id 商品大类id
     * @return
     */
    Result getThreeCategoryList(String id);

    /**
     * 添加商品三类
     * @param productSubCategory 商品三类
     * @param id 二类id
     * @return
     */
    Result addThreeCategory(ProductSubCategory productSubCategory, String id);

    /**
     * 根据id删除商品子类
     * @param id
     * @return
     */
    Result deleteById(String id);

    /**
     * 根据id修改商品子类名称
     * @param id
     * @param pcName
     * @return
     */
    Result updateProductSubCategoryById(String id, String pcName);

}
