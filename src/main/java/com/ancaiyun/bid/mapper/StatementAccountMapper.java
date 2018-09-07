package com.ancaiyun.bid.mapper;/**
 * <p>Title: StatementAccountMapper</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 10:12
 */

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:StatementAccountMapper</p>
 * <p>Description: 对账单Mapper</p>
 * @author zhangzhanyang
 * @date 2018/5/31 10:12
 */
@Mapper
@Repository
public interface StatementAccountMapper {
    /*
    * @Description 查询全部对账单
    * @Date 10:19 2018/5/31
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll(Map<String, Object> params);

    /*
    * @Description 查询对账单详情
    * @Date 10:51 2018/5/31
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 删除对账单
    * @Date 10:46 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
