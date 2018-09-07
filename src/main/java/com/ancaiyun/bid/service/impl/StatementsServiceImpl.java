package com.ancaiyun.bid.service.impl;/**
 * <p>Title: StatementsServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/31 9:14
 */

import com.ancaiyun.bid.mapper.StatementMapper;
import com.ancaiyun.bid.mapper.StatementMaterialsMapper;
import com.ancaiyun.bid.service.StatementService;
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
 * <p>Title:StatementsServiceImpl</p>
 * <p>Description: 结算单service实现类</p>
 * @author zhangzhanyang
 * @date 2018/5/31 9:14
 */
@Transactional
@Service
public class StatementsServiceImpl implements StatementService {

    @Autowired
    private StatementMapper statementMapper;

    @Autowired
    private StatementMaterialsMapper statementMaterialsMapper;
    /*
    * @Description 查询全部结算单
    * @Date 9:34 2018/5/31
    * @Param 
    * @return 
    **/
    
    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            //查询全部结算单
            PageHelperNew.startPage(pageNum,pageSize);
            List<ModelMap> modelMaps = statementMapper.getAll(params);
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
    * @Description 查看结算单详情
    * @Date 10:34 2018/6/2
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
                //查看结算单详情
                ModelMap modelMap = statementMapper.getDetail(id);
                //查询结算单物资列表
                List<ModelMap> materialMap=statementMaterialsMapper.getByStatementsId(id);
                map.addAttribute("statement",modelMap);
                map.addAttribute("material",materialMap);
                result.setData(map);
                code = Constants.SUCCESS;
            }else{
                code="2";
                msg="id不能为空";
            }
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
    * @Description 删除结算单
    * @Date 10:35 2018/6/2
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
                //删除结算单
                Boolean flag = statementMapper.delete(id);
                if(flag) {
                    code = Constants.SUCCESS;
                    msg="成功";
                }else{
                    code="3";
                    msg="删除失败";
                }
            }else{
                code="2";
                msg="id不能为空";
            }
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
}
