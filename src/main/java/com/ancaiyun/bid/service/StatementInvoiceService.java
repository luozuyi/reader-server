package com.ancaiyun.bid.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

/**
 * <p>Title: StatementInvoiceService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 10:53
 */
public interface StatementInvoiceService {
    Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result getDetail(String id);

    Result delete(String id);
}
