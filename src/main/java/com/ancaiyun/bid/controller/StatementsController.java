package com.ancaiyun.bid.controller;/**
 * <p>Title: StatementsController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 9:11
 */

import com.ancaiyun.bid.service.StatementService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:StatementsController</p>
 * <p>Description: 结算单Controler</p>
 * @author zhangzhanyang
 * @date 2018/5/31 9:11
 */
@RestController
public class StatementsController
{

    @Autowired
    private StatementService statementService;

    /*
    * @Description 查询全部的结算单
    * @Date 9:32 2018/5/31
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/statements",method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return statementService.getAll(pageNum,pageSize,params);
    }

    /*
    * @Description 查询结算单详情
    * @Date 9:43 2018/5/31
    * @Param 
    * @return 
    **/
    

    @RequestMapping(value = "v1/auth/statements/detail",method = RequestMethod.GET)
    public Result getDetail(String id){
        return statementService.getDetail(id);
    }

    /*
    * @Description 删除结算单
    * @Date 10:32 2018/6/2
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/statements",method = RequestMethod.DELETE)
    public Result detele(String id){
        return statementService.delete(id);
    }
}
