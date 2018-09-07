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
 * <p>Description: 合同Mapper</p>
 * @author zhangzhanyang
 * @date 2018/5/29 18:34
 */
@Mapper
@Repository
public interface ContractMapper {
    /*
    * @Description 查询所有合同信息
    * @Date 19:37 2018/5/29
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll(Map<String, Object> params);

    /*
    * @Description 查询合同详情
    * @Date 19:47 2018/5/29
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);
    /*
    * @Description 删除合同信息
    * @Date 10:10 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
