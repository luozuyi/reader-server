package com.ancaiyun.bid.controller;/**
 * <p>Title: PurchaserBidController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 14:29
 */

import com.ancaiyun.bid.service.PurchaserBidService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:PurchaserBidController</p>
 * <p>Description: 招投标Controller</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 14:29
 */
@RestController
public class PurchaserBidController {

    @Autowired
    private PurchaserBidService purchaserBidService;

    /*
     * @Description 查询全部招标信息
     * @Date 16:46 2018/5/29
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/purchaser-bids", method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize, @RequestParam Map<String, Object> params) {
        return purchaserBidService.getAll(pageNum, pageSize, params);
    }

    /*
     * @Description 查询招投标详情
     * @Date 18:13 2018/5/29
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/purchaser-bids/details", method = RequestMethod.GET)
    public Result getDetail(String id) {
        return purchaserBidService.getDetail(id);
    }


    /*
     * @Description 删除招投标信息
     * @Date 9:10 2018/6/2
     * @Param
     * @return
     **/

    @RequestMapping(value = "v1/auth/purchaser-bids", method = RequestMethod.DELETE)
    public Result delecte(String id) {
        return purchaserBidService.delecte(id);
    }


    /*
     * @Description 正在招标看供应商
     * @Date 9:26 2018/6/4
     * @Param
     * @return
     **/
    @RequestMapping(value = "v1/auth/purchaser-bids/supplier-info", method = RequestMethod.GET)
    public Result getSupplier(Integer pageNum, Integer pageSize,String id) {
        return purchaserBidService.getSupplier(pageNum,pageSize,id);
    }


}
