package com.ancaiyun.serviceImpl;

import com.ancaiyun.mapper.ChildAccountMapper;
import com.ancaiyun.service.ChildAccountService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class ChildAccountServiceImpl implements ChildAccountService{
    @Autowired
    private ChildAccountMapper childAccountMapper;
    @Override
    public Result selectByMemberId(Integer pageNum,Integer pageSize,Map<String,Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            Map<String,Object> map = new HashMap<>();
            String memberId = params.get("memberId").toString();
            Map<String,Object> mapParent = childAccountMapper.selectParentByMemberId(memberId);
            String userId = mapParent.get("userId").toString();
            params.put("userId", userId);
            PageHelperNew.startPage(pageNum, pageSize);
            List<Map<String,Object>> mapList = childAccountMapper.selectChildListByUserId(params);
            PageInfo page = new PageInfo(mapList);
            map.put("user", mapParent);
            map.put("page", page);
            result.setData(map);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
