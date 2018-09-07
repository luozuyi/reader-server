package com.ancaiyun.bid.controller;

import com.ancaiyun.bid.service.SupplierBidService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: SupplierBidController</p>
 * <p>Description :投标报价Controller</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 12:02
 */
@RestController
public class SupplierBidController {

    @Autowired
    private SupplierBidService supplierBidService;

    /*
    * @Description 查询所有投标信息
    * @Date 14:32 2018/6/4
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/supplier-others", method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize,String id) {
        return supplierBidService.getAll(pageNum, pageSize,id);
    }

    /*
    * @Description 查询投标信息详情
    * @Date 15:14 2018/6/4
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/supplier-others/detail", method = RequestMethod.GET)
    public Result getDetail(String id) {
        return supplierBidService.getDetail(id);
    }
}
