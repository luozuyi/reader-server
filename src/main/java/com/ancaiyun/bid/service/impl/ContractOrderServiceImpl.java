package com.ancaiyun.bid.service.impl;/**
 * <p>Title: ContractOrderServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 20:02
 */

import com.ancaiyun.bid.mapper.ContractOrderMapper;
import com.ancaiyun.bid.mapper.MaterialMapper;
import com.ancaiyun.bid.service.ContractOrderService;
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
 * <p>Title:ContractOrderServiceImpl</p>
 * <p>Description: 合同订单service实现</p>
 * @author zhangzhanyang
 * @date 2018/5/29 20:02
 */
@Transactional
@Service
public class ContractOrderServiceImpl implements ContractOrderService {


    @Autowired
    private ContractOrderMapper contractOrderMapper;

   /* @Autowired
    private MaterialMapper materialMapper;*/

    /*
     * @Description 查看合同订单列表
     * @Date 20:19 2018/5/29
     * @Param
     * @return
     **/

    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            //查询全部合同订单
            PageHelperNew.startPage(pageNum,pageSize);
            List<ModelMap> modelMaps = contractOrderMapper.getAll(params);
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
    * @Description 查看合同订单详情
    * @Date 10:23 2018/6/2
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

                //查看合同订单详情
                ModelMap modelMap = contractOrderMapper.getDetail(id);

                //查询合同订单物资
               // List<ModelMap> materialMap=materialMapper.getByOrderId(id);

                map.addAttribute("contractOrder",modelMap);
               // map.addAttribute("material",materialMap);
                result.setData(map);
                code = Constants.SUCCESS;
                msg = "成功";
            }else{
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
    * @Description 删除合同订单
    * @Date 10:23 2018/6/2
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
                //删除合同订单
                Boolean flag = contractOrderMapper.delete(id);
                if(flag) {
                    code = Constants.SUCCESS;
                    msg = "成功";
                }else{
                    code="3";
                    msg="删除失败";
                }
            }else{
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
