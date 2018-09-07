package com.ancaiyun.bid.service.impl;/**
 * <p>Title: ContractServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 19:20
 */

import com.ancaiyun.bid.mapper.ContractMapper;
import com.ancaiyun.bid.mapper.MaterialMapper;
import com.ancaiyun.bid.service.ContractService;
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
 * <p>Title:ContractServiceImpl</p>
 * <p>Description: 合同service实现</p>
 * @author zhangzhanyang
 * @date 2018/5/29 19:20
 */
@Transactional
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private MaterialMapper materialMapper;
    /*
    * @Description 查询全部合同信息
    * @Date 19:38 2018/5/29
    * @Param 
    * @return 
    **/
    
    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            //查询全部合同
            PageHelperNew.startPage(pageNum,pageSize);
            List<ModelMap> modelMaps = contractMapper.getAll(params);
            PageInfo<ModelMap> page = new PageInfo<>(modelMaps);

            result.setData(page);
            code=Constants.SUCCESS;
            msg="成功";
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
    * @Description 查询合同详细信息
    * @Date 19:43 2018/5/29
    * @Param 
    * @return 
    **/
    

    @Override
    public Result getDetail(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isNotBlank(id)) {
                ModelMap map=new ModelMap();


                //查询合同详情
                ModelMap modelMap = contractMapper.getDetail(id);

                //查询全部合同物资列表
                List<ModelMap> materialMap=materialMapper.getByContractId(id);

                map.addAttribute("contract",modelMap);
                map.addAttribute("material",materialMap);
                result.setData(map);
                code = Constants.SUCCESS;
                msg = "成功";
            }else{
                code ="2";
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
    * @Description 删除合同信息
    * @Date 9:58 2018/6/2
    * @Param 
    * @return 
    **/
    
    @Override
    public Result delete(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isNotBlank(id)) {
                //删除合同信息
                Boolean flag= contractMapper.delete(id);
               if(flag) {
                   code = Constants.SUCCESS;
                   msg = "成功";
               }else{
                   code="3";
                   msg="删除失败";
               }
            }else{
                code ="2";
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
