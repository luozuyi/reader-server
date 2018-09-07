package com.ancaiyun.mapper;


import com.ancaiyun.entity.ProductPropertyDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductPropertyDetailMapper {

    /**
     * 根据商品属性id查询属性详情
     * @param productPropertyId 属性id
     * @return
     */
    public List<ProductPropertyDetail> getListByProductPropertyId(String productPropertyId);

    /**
     * 添加商品属性详情
     * @param productPropertyDetail 属性详情
     * @return
     */
    public int insert(ProductPropertyDetail productPropertyDetail);

    /**
     * 修改商品属性详情
     * @return 属性详情
     */
    public int update(ProductPropertyDetail productPropertyDetail);

    /**
     * 根据id查询商品属性详情
     * @param id 主键id
     * @return
     */
    public ProductPropertyDetail getById(String id);
}
