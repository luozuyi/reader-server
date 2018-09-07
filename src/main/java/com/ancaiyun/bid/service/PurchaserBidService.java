package com.ancaiyun.bid.service;/**
 * <p>Title: PurchaserBidService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 14:30
 */

import com.ancaiyun.utils.Result;

import java.util.Map;

/**
 * <p>Title:PurchaserBidService</p>
 * <p>Description: TODO</p>
 * @author zhangzhanyang
 * @date 2018/5/29 14:30
 */
public interface PurchaserBidService {
    Result getAll(Integer pageNum, Integer pageSize,Map<String, Object> params);

    Result getDetail(String id);

    Result delecte(String id);

    Result getSupplier(Integer pageNum, Integer pageSize, String id);
}
