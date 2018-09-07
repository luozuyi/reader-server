package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: StatementInvoiceMapper</p>
 * <p>Description:发票Mappper </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 10:55
 */
@Mapper
@Repository
public interface StatementInvoiceMapper {
    /*
    * @Description 查询全部发票信息
    * @Date 11:38 2018/5/31
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll(Map<String, Object> params);

    /*
    * @Description 查询发票详情
    * @Date 11:40 2018/5/31
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /*
    * @Description 删除发票
    * @Date 10:50 2018/6/2
    * @Param 
    * @return 
    **/
    
    Boolean delete(String id);
}
