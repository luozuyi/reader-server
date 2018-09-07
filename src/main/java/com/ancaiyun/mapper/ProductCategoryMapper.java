package com.ancaiyun.mapper;

import com.ancaiyun.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductCategoryMapper {

    /**
     * 查询所有商品类型
     * @return
     */
    List<ProductCategory> getList();

    /**
     * 添加商品类型
     * @param productCategory 商品类型
     * @return
     */
    int insert(ProductCategory productCategory);

    /**
     * 根据id修改商品类型
     * @param productCategory 商品类型
     * @return
     */
    int updateById(ProductCategory productCategory);

    /**
     * 查询所有数量
     * @return
     */
    int getCount();

    /**
     * 根据id查询商品类型
     * @param id 主键id
     * @return
     */
    ProductCategory getById(String id);

}
