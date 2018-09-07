package com.ancaiyun.bid.controller;/**
 * <p>Title: ContractOrderController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 19:59
 */

import com.ancaiyun.bid.service.ContractOrderService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:ContractOrderController</p>
 * <p>Description: 合同订单Controller</p>
 * @author zhangzhanyang
 * @date 2018/5/29 19:59
 */

@RestController
public class ContractOrderController {

    @Autowired
    private ContractOrderService contractOrderService;

    /*
    * @Description 合同订单列表
    * @Date 20:18 2018/5/29
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contract-orders",method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return contractOrderService.getAll(pageNum,pageSize,params);
    }

    /*
    * @Description 查询合同订单详情
    * @Date 20:27 2018/5/29
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contract-orders/detail",method = RequestMethod.GET)
    public Result getDetail(String id){
        return contractOrderService.getDetail(id);
    }


    /*
    * @Description 删除合同信息
    * @Date 10:14 2018/6/2
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contract-orders",method = RequestMethod.DELETE)
    public Result delete(String id){
        return contractOrderService.delete(id);
    }
}
