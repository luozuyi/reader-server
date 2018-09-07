package com.ancaiyun.bid.mapper;/**
 * <p>Title: PurchaserOtherBidMapper</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 10:17
 */

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:PurchaserOtherBidMapper</p>
 * <p>Description: 竞价mapper</p>
 * @author zhangzhanyang
 * @date 2018/5/29 10:17
 */
@Mapper
@Repository
public interface PurchaserOtherBidMapper {
    /*
    * @Description 查询所有发布的竞价信息
    * @Date 11:32 2018/5/29
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll( Map<String, Object> params);

    /*
    * @Description 查询发布竞价详情
    * @Date 14:31 2018/5/29
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 删除竞价采购
    * @Date 9:55 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
