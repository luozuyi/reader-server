package com.ancaiyun.bid.service.impl;/**
 * <p>Title: PurchaserRecuritSupplierServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 18:32
 */

import com.ancaiyun.bid.mapper.PurchaserRecuritSupplierMapper;
import com.ancaiyun.bid.mapper.SupplierInfoMapper;
import com.ancaiyun.bid.service.PurchaserRecuritSupplierService;
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
 * <p>Title:PurchaserRecuritSupplierServiceImpl</p>
 * <p>Description: 供应商招募service实现</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 18:32
 */

@Transactional
@Service
public class PurchaserRecuritSupplierServiceImpl implements PurchaserRecuritSupplierService {

    @Autowired
    private PurchaserRecuritSupplierMapper purchaserRecuritSupplierMapper;

    
    @Autowired
    private SupplierInfoMapper supplierInfoMapper;
    
    /*
     * @Description 查询全部招募信息
     * @Date 18:53 2018/5/29
     * @Param
     * @return
     **/

    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            //查询全部招募
            PageHelperNew.startPage(pageNum,pageSize);
            List<ModelMap> modelMaps = purchaserRecuritSupplierMapper.getAll(params);
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
    * @Description 查询供应商招募详情
    * @Date 9:51 2018/6/2
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
                //查询招募详情
                ModelMap modelMap = purchaserRecuritSupplierMapper.getDetail(id);
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
    * @Description 删除供应商招募
    * @Date 11:43 2018/6/2
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
                //删除供应商招募信息
                Boolean flag= purchaserRecuritSupplierMapper.delete(id);
                if(flag) {
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

    /*
    * @Description 查看所有报名供应商
    * @Date 16:47 2018/6/4
    * @Param 
    * @return 
    **/
    
    @Override
    public Result getAllSupplier(Integer pageNum, Integer pageSize, String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {


            if(StringUtils.isNotBlank(id)) {
                PageHelperNew.startPage(pageNum, pageSize);
                //查询全部报名供应商
                List<ModelMap> modelMaps =supplierInfoMapper.getAllSupplier(id);
                PageInfo<ModelMap> page = new PageInfo<>(modelMaps);
                result.setData(page);

                code = Constants.SUCCESS;
                msg = "成功";
            }else{
                code = "3";
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
