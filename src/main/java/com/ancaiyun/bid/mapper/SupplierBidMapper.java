package com.ancaiyun.bid.mapper;/**
 * <p>Title: SupplierBidMapper</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 12:06
 */

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title:SupplierBidMapper</p>
 * <p>Description: 投标报价Mapper</p>
 * @author zhangzhanyang
 * @date 2018/6/4 12:06
 */

@Mapper
@Repository
public interface SupplierBidMapper {
    /*
    * @Description 查看投标信息
    * @Date 14:50 2018/6/4
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll(String id);

    /*
    * @Description 查询投标信息详情
    * @Date 15:18 2018/6/4
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);
}
