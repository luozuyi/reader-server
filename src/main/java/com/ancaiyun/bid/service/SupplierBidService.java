package com.ancaiyun.bid.service;

import com.ancaiyun.utils.Result;

/**
 * <p>Title: SupplierBidService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 12:04
 */
public interface SupplierBidService {
    Result getAll(Integer pageNum, Integer pageSize,String id);

    Result getDetail(String id);
}
