package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: StatementMapper</p>
 * <p>Description: 结算单Mapper</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 9:16
 */
@Mapper
@Repository
public interface StatementMapper {
    /*
    * @Description 查询全部的结算单
    * @Date 9:34 2018/5/31
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll( Map<String, Object> params);

    /*
    * @Description 查询结算单详情
    * @Date 9:58 2018/5/31
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 删除结算单
    * @Date 10:45 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
