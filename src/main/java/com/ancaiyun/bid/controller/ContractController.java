package com.ancaiyun.bid.controller;/**
 * <p>Title: ContractController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 19:18
 */

import com.ancaiyun.bid.service.ContractService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:ContractController</p>
 * <p>Description: 合同Controller</p>
 * @author zhangzhanyang
 * @date 2018/5/29 19:18
 */
@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    /*
    * @Description 查询全部合同信息
    * @Date 19:35 2018/5/29
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contracts",method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return contractService.getAll(pageNum,pageSize,params);
    }

    /*
    * @Description 查询合同详细信息
    * @Date 19:42 2018/5/29
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contracts/detail",method = RequestMethod.GET)
    public Result getDetail(String id){
        return contractService.getDetail(id);
    }

    /*
    * @Description 删除合同信息
    * @Date 9:57 2018/6/2
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/contracts",method = RequestMethod.DELETE)
    public Result delete(String id){
        return contractService.delete(id);
    }
}
