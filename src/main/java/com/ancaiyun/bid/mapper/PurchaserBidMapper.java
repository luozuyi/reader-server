package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: PurchaserBidMapper</p>
 * <p>Description:招投标Mapper </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 14:33
 */
@Mapper
@Repository
public interface PurchaserBidMapper {
    /*
    * @Description 查询全部招投标
    * @Date 18:17 2018/5/29
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll(Map<String, Object> params);

    /*
    * @Description 查看招投标详情
    * @Date 18:26 2018/5/29
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 删除招投标信息
    * @Date 9:28 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
