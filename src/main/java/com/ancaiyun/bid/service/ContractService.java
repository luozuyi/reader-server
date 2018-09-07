package com.ancaiyun.bid.service;

import com.ancaiyun.utils.Result;

import java.util.Map;

/**
 * <p>Title: ContractService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 19:19
 */
public interface ContractService {
    Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result getDetail(String id);

    Result delete(String id);
}
