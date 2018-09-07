package com.ancaiyun.bid.controller;/**
 * <p>Title: PurchaserOtherBidController</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 10:12
 */

import com.ancaiyun.bid.service.PurchaserOtherBidService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Title:PurchaserOtherBidController</p>
 * <p>Description: 竞价Controller</p>
 * @author zhangzhanyang
 * @date 2018/5/29 10:12
 */
@RestController
public class PurchaserOtherBidController
{
    @Autowired
    private PurchaserOtherBidService purchaserOtherBidService;
    
    /*
    * @Description 查询所有的竞价采购
    * @Date 11:15 2018/5/29
    * @Param 
    * @return 
    **/
    @RequestMapping(value = "v1/auth/purchaser-other-bids",method = RequestMethod.GET)
    public Result getAll(Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return purchaserOtherBidService.getAll(pageNum,pageSize,params);
    }
    
    /*
    * @Description 查看竞价采购详情
    * @Date 14:10 2018/5/29
    * @Param 
    * @return 
    **/
    @RequestMapping(value = "v1/auth/purchaser-other-bids/details",method = RequestMethod.GET)
    public Result getDetail(String id){
        return purchaserOtherBidService.getDetail(id);
    }

    /*
    * @Description 删除竞价信息
    * @Date 9:55 2018/6/2
    * @Param 
    * @return 
    **/
    
    @RequestMapping(value = "v1/auth/purchaser-other-bids",method = RequestMethod.DELETE)
    public Result delete(String id){
        return purchaserOtherBidService.delete(id);
    }
    
}
