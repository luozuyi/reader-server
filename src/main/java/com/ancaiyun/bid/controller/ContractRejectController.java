package com.ancaiyun.bid.controller;/**
 * <p>Title: ContractRejectController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/30 9:09
 */

import com.ancaiyun.bid.service.ContractRejectService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:ContractRejectController</p>
 * <p>Description: 发货单Controller</p>
 * @author zhangzhanyang
 * @date 2018/5/30 9:09
 */
@RestController
public class ContractRejectController {


    @Autowired
    private ContractRejectService contractRejectService;

    /*
    * @Description 查询全部发货单
    * @Date 9:59 2018/5/30
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contract-rejects",method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return contractRejectService.getAll(pageNum,pageSize,params);
    }

    /*
    * @Description 查询发货单详情
    * @Date 10:00 2018/5/30
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contract-rejects/detail",method = RequestMethod.GET)
    public Result getDetail(String id){
        return contractRejectService.getDetail(id);
    }

    /*
    * @Description 删除发货单
    * @Date 10:26 2018/6/2
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contract-rejects",method = RequestMethod.DELETE)
    public Result delete(String id){
        return contractRejectService.delete(id);
    }
}
