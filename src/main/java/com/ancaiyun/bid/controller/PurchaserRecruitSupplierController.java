package com.ancaiyun.bid.controller;/**
 * <p>Title: PurchaserRecruitSupplierController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 18:27
 */

import com.ancaiyun.bid.service.PurchaserRecuritSupplierService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:PurchaserRecruitSupplierController</p>
 * <p>Description: 招募Controller</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 18:27
 */
@RestController
public class PurchaserRecruitSupplierController {

    @Autowired
    private PurchaserRecuritSupplierService purchaserRecuritSupplierService;

    /*
     * @Description 查询全部供应商招募信息
     * @Date 18:49 2018/5/29
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/purchaser-recurit-suppliers", method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize, @RequestParam Map<String, Object> params) {
        return purchaserRecuritSupplierService.getAll(pageNum, pageSize, params);
    }

    /*
     * @Description 查询供应商招募详情
     * @Date 19:03 2018/5/29
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/purchaser-recurit-suppliers/details", method = RequestMethod.GET)
    public Result getDetail(String id) {
        return purchaserRecuritSupplierService.getDetail(id);
    }


    /*
     * @Description 删除供应商招募信息
     * @Date 9:49 2018/6/2
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/purchaser-recurit-suppliers", method = RequestMethod.DELETE)
    public Result delete(String id) {
        return purchaserRecuritSupplierService.delete(id);
    }

    /*
    * @Description 查看所有报名的供应商
    * @Date 16:21 2018/6/4
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/purchaser-recurit-suppliers/supplier", method = RequestMethod.GET)
    public Result getAllSupplier(Integer pageNum, Integer pageSize, String id) {
        return purchaserRecuritSupplierService.getAllSupplier(pageNum, pageSize, id);
    }
}
