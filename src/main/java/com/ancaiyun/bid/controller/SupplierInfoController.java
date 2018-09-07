package com.ancaiyun.bid.controller;/**
 * <p>Title: SupplierInfoController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 11:40
 */

import com.ancaiyun.bid.service.SupplierInfoService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title:SupplierInfoController</p>
 * <p>Description: 供应商信息Controller</p>
 * @author zhangzhanyang
 * @date 2018/6/4 11:40
 */
@RestController
public class SupplierInfoController {

    @Autowired
    private SupplierInfoService supplierInfoService;

    /*
    * @Description 查看供应商信息详情
    * @Date 11:45 2018/6/4
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/supplier_infos", method = RequestMethod.GET)
    public Result getDetail(String id) {
        return supplierInfoService.getDetail(id);
    }
}
