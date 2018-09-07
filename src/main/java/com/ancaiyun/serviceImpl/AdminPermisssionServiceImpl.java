package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.AdminPermisssion;
import com.ancaiyun.mapper.AdminPermisssionMapper;
import com.ancaiyun.service.AdminPermisssionService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class AdminPermisssionServiceImpl implements AdminPermisssionService{
    @Autowired
    private AdminPermisssionMapper adminPermisssionMapper;
    @Override
    public Result addAdminPermisssion(AdminPermisssion adminPermisssion) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(adminPermisssion.getAction())){
                code = "-3";
                msg = "action不能为空";
            }else if(StringUtils.isBlank(adminPermisssion.getName())){
                code = "-4";
                msg = "资源名称不能为空";
            }else if(StringUtils.isBlank(adminPermisssion.getLevel())){
                code = "-5";
                msg = "等级不能为空";
            }else if(StringUtils.isBlank(adminPermisssion.getType())){
                code = "-6";
                msg = "类型不能为空";
            }else if(StringUtils.isBlank(adminPermisssion.getUrl())){
                code = "-7";
                msg = "资源不能为空";
            }else if(StringUtils.isBlank(adminPermisssion.getMethod())){
                code = "-8";
                msg = "请求方式不能为空";
            }else{
                AdminPermisssion adminPermisssion_db = adminPermisssionMapper.selectByUrlAndMethod(adminPermisssion);
                if(adminPermisssion_db != null){
                    code = "-9";
                    msg = "已经添加过";
                }else{
                    adminPermisssion.setId(UUID.randomUUID().toString().replace("-", ""));
                    adminPermisssion.setCreateTime(new Date());
                    adminPermisssion.setDelFlag("0");
                    adminPermisssionMapper.insertSelective(adminPermisssion);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
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

    @Override
    public Result deleteAdminPermisssion(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "请选择要删除的权限";
            }else {
                AdminPermisssion adminPermisssion = adminPermisssionMapper.selectByPrimaryKey(id);
                if(adminPermisssion == null){
                    code = "-4";
                    msg = "删除的权限对象不存在";
                }else{
                    adminPermisssion.setDelFlag("1");
                    adminPermisssionMapper.updateByPrimaryKeySelective(adminPermisssion);
                    code = "-5";
                    msg = "成功";
                }
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

    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<AdminPermisssion> adminPermisssionList = adminPermisssionMapper.sellectAll();
            PageInfo<AdminPermisssion> page = new PageInfo<>(adminPermisssionList);
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
}
