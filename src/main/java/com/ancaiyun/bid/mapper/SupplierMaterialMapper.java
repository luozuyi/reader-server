package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title: SupplierMaterialMapper</p>
 * <p>Description:物资关联Mapper </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/5 14:15
 */
@Repository
@Mapper
public interface SupplierMaterialMapper {
    /*
    * @Description 查看投标物资列表
    * @Date 18:47 2018/6/5
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getBySupplierBid(String id);

    /*
    * @Description 查询报价物资列表
    * @Date 10:59 2018/6/6
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getOtherBid(String id);


    /*
    * @Description 查看发货物资列表
    * @Date 11:22 2018/6/6
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByRejecttId(String id);
}
