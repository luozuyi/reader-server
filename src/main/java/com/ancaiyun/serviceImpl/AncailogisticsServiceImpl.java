package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Ancailogistics;
import com.ancaiyun.mapper.AncailogisticsMapper;
import com.ancaiyun.service.AncailogisticsService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AncailogisticsServiceImpl implements AncailogisticsService {

    @Autowired
    private AncailogisticsMapper ancailogisticsMapper;

    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Ancailogistics> ancailogisticsList = ancailogisticsMapper.getList();
            PageInfo<Ancailogistics> page = new PageInfo<>(ancailogisticsList);
            result.setData(page);
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
