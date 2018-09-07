package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title: StatementMaterialsMapper</p>
 * <p>Description: 结算单,对账单物资Material</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/6 12:01
 */
@Repository
@Mapper
public interface StatementMaterialsMapper {

    /*
    * @Description 查询结算单物资列表
    * @Date 15:53 2018/6/6
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByStatementsId(String id);

    /*
    * @Description 查询对账单物资列表
    * @Date 16:10 2018/6/6
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAccountId(String id);

    /*
    * @Description 查看对账单的结算物资
    * @Date 16:27 2018/6/6
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getByStatementAccountId(String id);
}
