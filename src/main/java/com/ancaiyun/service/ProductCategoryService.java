package com.ancaiyun.service;

import com.ancaiyun.entity.ProductCategory;
import com.ancaiyun.utils.Result;

public interface ProductCategoryService {

    /**
     * 分页查询商品类型
     * @param pageNum 当前页数
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);

    /**
     * 添加商品类型
     * @param productCategory 商品类型
     * @return
     */
    Result addproductCategory(ProductCategory productCategory);

    /**
     * 根据id删除商品类型
     * @param id 主键id
     * @return
     */
    Result deleteById(String id);

    /**
     * 根据id修改商品类型
     * @param id 主键id
     * @param typeName 类型名称
     * @return
     */
    Result updateProductCategoryById(String id, String typeName);
}
