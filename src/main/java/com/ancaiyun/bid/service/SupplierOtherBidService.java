package com.ancaiyun.bid.service;

import com.ancaiyun.utils.Result;

/**
 * <p>Title: SupplierOtherBidService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 15:32
 */
public interface SupplierOtherBidService {

    Result getAll(Integer pageNum, Integer pageSize, String id);

    Result getDetail(String id);
}
