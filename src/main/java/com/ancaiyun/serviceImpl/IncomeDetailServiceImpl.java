package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.IncomeDetail;
import com.ancaiyun.mapper.IncomeDetailMapper;
import com.ancaiyun.service.IncomeDetailService;
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
public class IncomeDetailServiceImpl implements IncomeDetailService {

    @Autowired
    private IncomeDetailMapper incomeDetailMapper;

    @Override
    public Result pageList(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNo, pageSize);
            List<IncomeDetail> incomeDetailList = incomeDetailMapper.getList(params);
            PageInfo<IncomeDetail> pageInfo = new PageInfo<>(incomeDetailList);
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
