package com.ancaiyun.bid.service;

import com.ancaiyun.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>Title: ContractOrderService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 20:00
 */
public interface ContractOrderService {
    Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result getDetail(String id);

    Result delete(String id);
}
