package com.ancaiyun.bid.mapper;/**
 * <p>Title: PurchaserRecuritSupplierMapper</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 18:34
 */

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:PurchaserRecuritSupplierMapper</p>
 * <p>Description: 供应商招募Mapper</p>
 * @author zhangzhanyang
 * @date 2018/5/29 18:34
 */
@Mapper
@Repository
public interface PurchaserRecuritSupplierMapper {
    /*
    * @Description 查询全部招募信息
    * @Date 18:52 2018/5/29
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll( Map<String, Object> params);

    /*
    * @Description 查看招募详情信息
    * @Date 19:17 2018/5/29
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 删除供应商招募信息
    * @Date 9:55 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
