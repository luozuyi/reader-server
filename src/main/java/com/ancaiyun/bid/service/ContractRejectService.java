package com.ancaiyun.bid.service;

import com.ancaiyun.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>Title: ControllerRejectService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/30 9:11
 */
public interface ContractRejectService {
    Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result getDetail(String id);

    Result delete(String id);
}
