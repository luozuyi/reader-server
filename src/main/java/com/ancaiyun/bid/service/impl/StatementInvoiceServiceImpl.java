package com.ancaiyun.bid.service.impl;/**
 * <p>Title: StatementInvoiceServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 10:54
 */

import com.ancaiyun.bid.mapper.StatementInvoiceMapper;
import com.ancaiyun.bid.service.StatementInvoiceService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:StatementInvoiceServiceImpl</p>
 * <p>Description: 发票service实现</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 10:54
 */
@Transactional
@Service
public class StatementInvoiceServiceImpl implements StatementInvoiceService {

    @Autowired
    private StatementInvoiceMapper statementInvoiceMapper;

    /*
     * @Description 查询全部发票信息
     * @Date 11:27 2018/5/31
     * @Param
     * @return
     **/

    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            //查询全部发票
            PageHelperNew.startPage(pageNum, pageSize);
            List<ModelMap> modelMaps = statementInvoiceMapper.getAll(params);
            PageInfo<ModelMap> page = new PageInfo<>(modelMaps);

            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
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

    /*
     * @Description 查询发票详情
     * @Date 11:37 2018/5/31
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
                //查询发票详情
                ModelMap modelMap = statementInvoiceMapper.getDetail(id);
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

    /*
     * @Description 删除发票
     * @Date 10:47 2018/6/2
     * @Param
     * @return
     **/

    @Override
    public Result delete(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isNotBlank(id)) {
                //删除发票信息
                Boolean flag = statementInvoiceMapper.delete(id);
                if (flag) {
                    code = Constants.SUCCESS;
                    msg = "成功";
                }else{
                    code="3";
                    msg="删除失败";
                }
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
