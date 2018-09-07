package com.ancaiyun.bid.controller;/**
 * <p>Title: SupplierOtherBidController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 15:31
 */

import com.ancaiyun.bid.service.SupplierOtherBidService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title:SupplierOtherBidController</p>
 * <p>Description: 供应商报价Controller</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 15:31
 */
@RestController
public class SupplierOtherBidController {

    @Autowired
    private SupplierOtherBidService supplierOtherBidService;

    /*
    * @Description 查询报价信息
    * @Date 15:51 2018/6/4
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/supplier-other-bids", method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize, String id) {
        return supplierOtherBidService.getAll(pageNum, pageSize, id);
    }

    /*
    * @Description 查看报价详情信息
    * @Date 16:07 2018/6/4
    * @Param 
    * @return 
    **/
    @RequestMapping(value = "v1/auth/supplier-other-bids/detail", method = RequestMethod.GET)
    public Result getDetail( String id) {
        return supplierOtherBidService.getDetail(id);
    }

}
