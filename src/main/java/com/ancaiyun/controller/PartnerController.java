package com.ancaiyun.controller;

import com.ancaiyun.entity.Partner;
import com.ancaiyun.service.PartnerService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    /**
     * 添加合作伙伴
     * @param partner 合作伙伴对象
     * partner.getCompanyTel()联系人电话
     * partner.getCompanyWebsite()网站
     * partner.getCompanyConstacts() 联系人
     * @return
     */
    @RequestMapping(value = "v1/auth/partners",method = RequestMethod.POST)
    public Result addPartner(Partner partner){
        return partnerService.addPartner(partner);
    }

    /**
     * 分页查询合作伙伴
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/partners/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize) {
        return partnerService.listPage(pageNum, pageSize);
    }
}
