package com.ancaiyun.serviceImpl;

import com.ancaiyun.mapper.BankMapper;
import com.ancaiyun.mapper.MemberBankMapper;
import com.ancaiyun.mapper.MemberMapper;
import com.ancaiyun.mapper.UserMapper;
import com.ancaiyun.service.MemberBankService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MemberBankServiceImpl implements MemberBankService {

    @Autowired
    private MemberBankMapper memberBankMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BankMapper bankMapper;

    @Override
    public Result pageList(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNo, pageSize);
            if (params.containsKey("username")){
                String  username = (String) params.get("username");
                String userId = userMapper.selectByUsername(username).getId();
                String memberId = memberMapper.selectByUserId(userId).getId();
                params.put("username", memberId);
            }
            List<Map<String, Object>> mapList = memberBankMapper.getList(params);
            /*List<ModelMap> modelMaps = new ArrayList<>();
            for (MemberBank memberBank : memberBankList) {
                ModelMap modelMap = new ModelMap();
                String userId = memberMapper.selectByPrimaryKey(memberBank.getMemberId()).getUserId();
                String username = userMapper.selectByPrimaryKey(userId).getUsername();
                String bankName = bankMapper.getById(memberBank.getBankId()).getBankName();
                modelMap.addAttribute("username",username);
                modelMap.addAttribute("bankName",bankName);
                modelMap.addAttribute("cardCode",memberBank.getCardCode());
                modelMap.addAttribute("createTime",memberBank.getCreateTime());
                modelMaps.add(modelMap);
            }*/
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mapList);
            result.setData(pageInfo);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
