package com.ancaiyun.bid.service;/**
 * <p>Title: PurchaserRecuritSupplierService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 18:30
 */

import com.ancaiyun.utils.Result;

import java.util.Map;

/**
 * <p>Title:PurchaserRecuritSupplierService</p>
 * <p>Description: TODO</p>
 * @author zhangzhanyang
 * @date 2018/5/29 18:30
 */
public interface PurchaserRecuritSupplierService {
    Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result getDetail(String id);

    Result delete(String id);

    Result getAllSupplier(Integer pageNum, Integer pageSize, String id);
}
