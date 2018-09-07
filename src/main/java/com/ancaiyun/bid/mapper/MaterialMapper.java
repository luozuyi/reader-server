package com.ancaiyun.bid.mapper;/**
 * <p>Title: MaterialMapper</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/5 8:47
 */

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title:MaterialMapper</p>
 * <p>Description: 物资Mapper</p>
 * @author zhangzhanyang
 * @date 2018/6/5 8:47
 */
@Mapper
@Repository
public interface MaterialMapper {
    /*
    * @Description 根据招标id查询发布的招标物资
    * @Date 9:08 2018/6/5
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByBid(String id);

    /*
    * @Description 根据竞价id查看竞价物资
    * @Date 9:24 2018/6/5
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByOtherBid(String id);

    /*
    * @Description 根据合同id查看合同物资列表
    * @Date 11:18 2018/6/5
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByContractId(String id);

    /*
    * @Description 根据合同订单id查看合同订单详情
    * @Date 11:41 2018/6/5
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByOrderId(String id);
}
