package com.ancaiyun.bid.service.impl;/**
 * <p>Title: StatementAccountServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 9:59
 */

import com.ancaiyun.bid.mapper.StatementAccountMapper;
import com.ancaiyun.bid.mapper.StatementMaterialsMapper;
import com.ancaiyun.bid.service.StatementAccountService;
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
 * <p>Title:StatementAccountServiceImpl</p>
 * <p>Description: 对账单service实现类</p>
 * @author zhangzhanyang
 * @date 2018/5/31 9:59
 */
@Transactional
@Service
public class StatementAccountServiceImpl implements StatementAccountService {

    @Autowired
    private StatementAccountMapper statementAccountMapper;

    @Autowired
    private StatementMaterialsMapper statementMaterialsMapper;

    /*
    * @Description 查询全部对账单
    * @Date 10:19 2018/5/31
    * @Param 
    * @return 
    **/
    
    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            //查询全部对账单
            PageHelperNew.startPage(pageNum,pageSize);
            List<ModelMap> modelMaps = statementAccountMapper.getAll(params);
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
    * @Description 查询对账单详情
    * @Date 10:23 2018/5/31
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
                ModelMap map=new ModelMap();
                //查询对账单详情
                ModelMap modelMap = statementAccountMapper.getDetail(id);

                //查询对账单物资列表
                List<ModelMap> materialMap=statementMaterialsMapper.getAccountId(id);

                //查看对账单结算物资列表
                List<ModelMap> stateMap=statementMaterialsMapper.getByStatementAccountId(id);
                map.addAttribute("account",modelMap);
                map.addAttribute("accountMaterial",materialMap);
                map.addAttribute("stateMaterial",stateMap);
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
    * @Description 删除对账单
    * @Date 10:43 2018/6/2
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
                //删除对账单
                Boolean flag = statementAccountMapper.delete(id);
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
