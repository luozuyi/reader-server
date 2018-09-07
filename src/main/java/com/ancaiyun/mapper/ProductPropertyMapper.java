package com.ancaiyun.mapper;


import com.ancaiyun.entity.ProductProperty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProductPropertyMapper {

    /**
     * 根据三类id和属性名称模糊查询所有属性
     * @param params 查询参数
     * @return
     */
    public List<ProductProperty> getListByProductSubCategoryIdAndPropertyName(Map<String, String>params);

    /**
     * 根据属性名称和三类id查询商品属性
     * @param params 查询参数
     * @return
     */
    public ProductProperty getByPropertyNameAndProductSubCategoryId(Map<String,String>params);

    /**
     * 添加商品属性
     * @param productProperty 商品属性
     * @return
     */
    public int insert(ProductProperty productProperty);

    /**
     * 根据id查询商品属性
     * @param id 主键id
     * @return
     */
    public ProductProperty getById(String id);

    /**
     * 修改商品属性
     * @param productProperty 商品属性
     * @return
     */
    public int update(ProductProperty productProperty);


    /**
     * 查询所有属性
     * @return
     */
    public List<ProductProperty> getList();
}
