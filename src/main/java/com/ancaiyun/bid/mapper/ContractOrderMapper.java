package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: ContractOrderMapper</p>
 * <p>Description:合同订单mapper</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 20:04
 */
@Mapper
@Repository
public interface ContractOrderMapper {
    /*
    * @Description 查询合同订单列表
    * @Date 20:21 2018/5/29
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll(Map<String, Object> params);

    /*
    * @Description 查询合同订单详情
    * @Date 20:30 2018/5/29
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

   /*
   * @Description 删除合同订单
   * @Date 10:30 2018/6/2
   * @Param 
   * @return 
   **/
   
    
    Boolean delete(String id);
}
