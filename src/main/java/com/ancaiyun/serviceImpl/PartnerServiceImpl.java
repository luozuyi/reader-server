package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Partner;
import com.ancaiyun.mapper.PartnerMapper;
import com.ancaiyun.service.PartnerService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class PartnerServiceImpl implements PartnerService{
    @Autowired
    private PartnerMapper partnerMapper;
    @Override
    public Result addPartner(Partner partner) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(partner.getCompanyTel())){
                code = "-3";
                msg = "联系人电话不能为空";
            }else if(StringUtils.isBlank(partner.getCompanyWebsite())){
                code = "-4";
                msg = "网站不能为空";
            }else if(StringUtils.isBlank(partner.getCompanyConstacts())){
                code = "-5";
                msg = "公司联系人不能为空";
            }else{
                partner.setPartnerId(UUID.randomUUID().toString().replace("-", ""));
                partner.setSubmitTime(new Date());
                partner.setDelFlag("0");
                partnerMapper.insertSelective(partner);
                code = Constants.SUCCESS;
                msg = "成功";
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Partner> partnerList = partnerMapper.selectAll();
            PageInfo<Partner> page = new PageInfo<>(partnerList);
            code = Constants.SUCCESS;
            msg = "成功";
            result.setData(page);
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
