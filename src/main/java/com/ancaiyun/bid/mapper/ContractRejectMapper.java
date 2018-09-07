package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: ContractRejectMapper</p>
 * <p>Description:发货单Mapper </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/30 9:39
 */
@Mapper
@Repository
public interface ContractRejectMapper {
    /*
    * @Description 查询全部发货单
    * @Date 9:58 2018/5/30
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll( Map<String, Object> params);

    /*
    * @Description 查询发货单详情
    * @Date 10:03 2018/5/30
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 删除发货单
    * @Date 10:30 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
