package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.FreezeDetail;
import com.ancaiyun.mapper.FreezeDetailMapper;
import com.ancaiyun.service.FreezeDetailService;
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
public class FreezeDetailServiceImpl implements FreezeDetailService {

    @Autowired
    private FreezeDetailMapper freezeDetailMapper;

    @Override
    public Result pageList(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNo, pageSize);
            List<FreezeDetail> freezeDetailList = freezeDetailMapper.getList(params);
            PageInfo<FreezeDetail> pageInfo = new PageInfo<>(freezeDetailList);
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
