package com.ancaiyun.service;

import com.ancaiyun.entity.Partner;
import com.ancaiyun.utils.Result;

public interface PartnerService {
    /**
     * 添加合作伙伴
     * @param partner 合作伙伴对象
     * @return
     */
    Result addPartner(Partner partner);

    /**
     * 分页查询公司合作伙伴
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);
}
