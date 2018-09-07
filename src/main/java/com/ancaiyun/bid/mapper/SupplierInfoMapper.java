package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title: InvitedSuppliersMapper</p>
 * <p>Description: 供应商信息Mapper</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 9:46
 */
@Mapper
@Repository
public interface SupplierInfoMapper {
    /*
    * @Description 被邀请查看供应商列表
    * @Date 10:33 2018/6/4
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByBidId(String id);

    /*
    * @Description 公开招标查看供应商
    * @Date 10:51 2018/6/4
    * @Param
    * @return
    **/

    List<ModelMap> getByPurchaserBidId(String id);

    /*
    * @Description 查询供应商信息详情
    * @Date 11:59 2018/6/4
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 查看全部报名招募的供应商
    * @Date 17:05 2018/6/4
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAllSupplier(String id);
}
