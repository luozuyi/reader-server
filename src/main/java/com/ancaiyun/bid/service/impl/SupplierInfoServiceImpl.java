package com.ancaiyun.bid.service.impl;/**
 * <p>Title: SupplierInfoServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 11:41
 */

import com.ancaiyun.bid.mapper.SupplierInfoMapper;
import com.ancaiyun.bid.service.SupplierInfoService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;

/**
 * <p>Title:SupplierInfoServiceImpl</p>
 * <p>Description: 供应商信息Service实现</p>
 * @author zhangzhanyang
 * @date 2018/6/4 11:41
 */
@Service
@Transactional
public class SupplierInfoServiceImpl implements SupplierInfoService {

    @Autowired
    private SupplierInfoMapper supplierInfoMapper;

    /*
    * @Description 查看供应商信息详情
    * @Date 11:46 2018/6/4
    * @Param 
    * @return 
    **/
    
    @Override
    public Result getDetail(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isNotBlank(id)) {
                //查询供应商信息详情
                ModelMap modelMap = supplierInfoMapper.getDetail(id);
                result.setData(modelMap);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                code = "2";
                msg = "id不能为空";
            }

        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
