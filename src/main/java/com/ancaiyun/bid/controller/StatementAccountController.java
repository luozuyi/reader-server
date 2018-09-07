package com.ancaiyun.bid.controller;/**
 * <p>Title: StatementAccountController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 9:55
 */

import com.ancaiyun.bid.service.StatementAccountService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:StatementAccountController</p>
 * <p>Description: 对账单Controller</p>
 * @author zhangzhanyang
 * @date 2018/5/31 9:55
 */
@RestController
public class StatementAccountController {

    @Autowired
    private StatementAccountService statementAccountService;

    /*
    * @Description 查询全部对账单
    * @Date 10:16 2018/5/31
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/statement-accounts",method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return statementAccountService.getAll(pageNum,pageSize,params);
    }


    /*
    * @Description 查询对账单详情
    * @Date 10:22 2018/5/31
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/statement-accounts/detail",method = RequestMethod.GET)
    public Result getDetail(String id){
        return statementAccountService.getDetail(id);
    }


    /*
    * @Description 删除对账单
    * @Date 10:40 2018/6/2
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/statement-accounts",method = RequestMethod.DELETE)
    public Result delete(String id){
        return statementAccountService.delete(id);
    }
}
