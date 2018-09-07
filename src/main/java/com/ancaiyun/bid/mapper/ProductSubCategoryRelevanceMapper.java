package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title: ProductSubCategoryRelevanceMapper</p>
 * <p>Description: 招投标,竞价 合同 物资二类关联表</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/7 16:14
 */
@Repository
@Mapper
public interface ProductSubCategoryRelevanceMapper {
    /*
    * @Description 查询关联的物资二类列表
    * @Date 16:37 2018/6/7
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByRelevanceId(String id);
}
