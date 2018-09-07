package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.AdminPermisssion;
import com.ancaiyun.entity.AdminRole;
import com.ancaiyun.entity.AdminRolePermisssion;
import com.ancaiyun.mapper.AdminPermisssionMapper;
import com.ancaiyun.mapper.AdminRoleMapper;
import com.ancaiyun.mapper.AdminRolePermisssionMapper;
import com.ancaiyun.service.AdminRolePermisssionService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.Result;
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
public class AdminRolePermisssionServiceImpl implements AdminRolePermisssionService{
    @Autowired
    private AdminRolePermisssionMapper adminRolePermisssionMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private AdminPermisssionMapper adminPermisssionMapper;
    @Override
    public Result addAdminRolePermisssion(String adminRoleId, String[] adminPermisssionIds) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(adminRoleId)){
                code = "-3";
                msg = "请选择要分配的角色对象";
            }else if(adminPermisssionIds == null){
                code = "-4";
                msg = "请选择要分配的权限";
            }else{
                AdminRole adminRole_db = adminRoleMapper.selectByPrimaryKey(adminRoleId);
                if(adminRole_db == null){
                    code = "-5";
                    msg = "要分配的角色对象不存在";
                }else{
                    Boolean flag = true;
                    for (String adminPermisssionId:adminPermisssionIds) {
                        AdminPermisssion adminPermisssion_db = adminPermisssionMapper.selectByPrimaryKey(adminPermisssionId);
                        if(adminPermisssion_db == null){
                            flag = false;
                        }
                    }
                    if(!flag){
                        code = "-6";
                        msg = "存在不存在的权限";
                    }else{
                        List<AdminRolePermisssion> adminRolePermisssionList = adminRolePermisssionMapper.selectByAdminRoleId(adminRoleId);
                        for (AdminRolePermisssion adminRolePermisssion:adminRolePermisssionList) {
                            adminRolePermisssionMapper.deleteByPrimaryKey(adminRolePermisssion.getId());
                        }
                        for (String adminPermisssionId:adminPermisssionIds) {
                            AdminRolePermisssion adminRolePermisssion = new AdminRolePermisssion();
                            adminRolePermisssion.setDelFlag("0");
                            adminRolePermisssion.setId(UUID.randomUUID().toString().replace("-", ""));
                            adminRolePermisssion.setCreateTime(new Date());
                            adminRolePermisssion.setAdminRoleId(adminRoleId);
                            adminRolePermisssion.setAdminPermisssionId(adminPermisssionId);
                            adminRolePermisssionMapper.insertSelective(adminRolePermisssion);
                        }
                        code = Constants.SUCCESS;
                        msg = "成功";
                    }
                }
            }

        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
