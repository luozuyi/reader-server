package com.ancaiyun.bid.service;/**
 * <p>Title: StatementAccountService</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 9:56
 */

import com.ancaiyun.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <p>Title:StatementAccountService</p>
 * <p>Description: TODO</p>
 * @author zhangzhanyang
 * @date 2018/5/31 9:56
 */
public interface StatementAccountService {
    Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result getDetail(String id);

    Result delete(String id);
}
