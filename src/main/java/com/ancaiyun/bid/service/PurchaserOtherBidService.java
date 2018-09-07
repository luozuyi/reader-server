package com.ancaiyun.bid.service;

import com.ancaiyun.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>Title: PurchaserOtherBidService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 10:14
 */
public interface PurchaserOtherBidService {
    Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result getDetail(String id);

    Result delete(String id);
}
