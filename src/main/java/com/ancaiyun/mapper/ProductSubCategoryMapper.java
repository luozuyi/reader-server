package com.ancaiyun.mapper;

import com.ancaiyun.entity.ProductSubCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductSubCategoryMapper {

    /**
     * 根据商品大类id查询商品子类型
     * @param ProductCategoryId 商品大类id
     * @return
     */
    List<ProductSubCategory> getListByProductCategoryId(String ProductCategoryId);

    /**
     * 根据父id查询商品子类
     * @param parentId 父id
     * @return
     */
    List<ProductSubCategory> getListByParentId(String parentId);

    /**
     * 添加商品子类
     * @param productSubCategory 商品子类
     * @return
     */
    int insert(ProductSubCategory productSubCategory);

    /**
     * 修改商品子类
     * @param productSubCategory 商品子类
     * @return
     */
    int update(ProductSubCategory productSubCategory);

    /**
     * 根据id查询子类
     * @param id
     * @return
     */
    ProductSubCategory getById(String id);
}
