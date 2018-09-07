package com.ancaiyun.serviceImpl;

import com.ancaiyun.bid.mapper.ProductSubCategoryRelevanceMapper;
import com.ancaiyun.entity.Accessory;
import com.ancaiyun.entity.Member;
import com.ancaiyun.entity.MemberExtraData;
import com.ancaiyun.entity.User;
import com.ancaiyun.mapper.AccessoryMapper;
import com.ancaiyun.mapper.MemberExtraDataMapper;
import com.ancaiyun.mapper.MemberMapper;
import com.ancaiyun.mapper.UserMapper;
import com.ancaiyun.service.MemberService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemberExtraDataMapper memberExtraDataMapper;
    @Autowired
    private AccessoryMapper accessoryMapper;
    @Autowired
    private ProductSubCategoryRelevanceMapper productSubCategoryRelevanceMapper;
    @Override
    public Result listPage(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            params.put("delFlag", "0");
            List<Map<String,Object>> mapList = new ArrayList<>();
            PageHelperNew.startPage(pageNum, pageSize);
            List<Map<String,Object>> maps = memberMapper.selectAllBySelectionResultMap(params);
            for (Map<String,Object> mapData:maps) {
                Map<String,Object> map = new HashMap<>();
                String userId = mapData.get("user_id").toString();
                String memberId = mapData.get("id").toString();
                User user = userMapper.selectByPrimaryKey(userId);
                Member member = memberMapper.selectByPrimaryKey(memberId);
                map.put("member", member);
                map.put("user", user);
                if(mapData.get("extra_data_id") !=null){
                    String extraDataId = mapData.get("extra_data_id").toString();
                    MemberExtraData memberExtraData = memberExtraDataMapper.selectByPrimaryKey(extraDataId);
                    map.put("memberExtraData", memberExtraData);
                }else{
                    map.put("memberExtraData", null);
                }
                mapList.add(map);
            }
            PageInfo<Map<String,Object>> page = new PageInfo<>(maps);
            page.setList(mapList);
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

    @Override
    public Result detail(String memberId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        Map<String,Object> map = new HashMap<>();
        try {
            if(StringUtils.isBlank(memberId)){
                code = "-3";
                msg = "会员id不能为空";
            }else{
                Member member = memberMapper.selectByPrimaryKey(memberId);
                if(member == null){
                    code = "-4";
                    msg = "会员不存在";
                }else{
                    String userId = member.getUserId();
                    User user = userMapper.selectByPrimaryKey(userId);
                    map.put("user", user);
                    map.put("member", member);
                    String extraDataId = member.getExtraDataId();
                    if(StringUtils.isBlank(extraDataId)){
                        map.put("memberExtraData", null);
                    }else{
                        MemberExtraData memberExtraData = memberExtraDataMapper.selectByPrimaryKey(extraDataId);
                        map.put("memberExtraData", memberExtraData);
                        String logoId = memberExtraData.getCompanyLogoId();
                        if(StringUtils.isNotBlank(logoId)){
                            Accessory logo = accessoryMapper.selectByPrimaryKey(logoId);
                            map.put("logo", logo);
                        }else{
                            map.put("logo", null);
                        }
                        String companyBusinessLicenseElectronicVersionId = memberExtraData.getCompanyBusinessLicenseElectronicVersion();
                        if(StringUtils.isNotBlank(companyBusinessLicenseElectronicVersionId)){
                            Accessory companyBusinessLicenseElectronicVersion = accessoryMapper.selectByPrimaryKey(companyBusinessLicenseElectronicVersionId);
                            map.put("companyBusinessLicenseElectronicVersion", companyBusinessLicenseElectronicVersion);
                        }else{
                            map.put("companyBusinessLicenseElectronicVersion", null);
                        }
                    }
                    List<ModelMap> productSubCategoryRelevance = productSubCategoryRelevanceMapper.getByRelevanceId(memberId);
                    map.put("productSubCategoryRelevance", productSubCategoryRelevance);
                    code = Constants.SUCCESS;
                    msg = "成功";
                    result.setData(map);
                }
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
}
