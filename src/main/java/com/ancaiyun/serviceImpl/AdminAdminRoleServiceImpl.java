package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Admin;
import com.ancaiyun.entity.AdminAdminRole;
import com.ancaiyun.entity.AdminRole;
import com.ancaiyun.mapper.AdminAdminRoleMapper;
import com.ancaiyun.mapper.AdminMapper;
import com.ancaiyun.mapper.AdminRoleMapper;
import com.ancaiyun.service.AdminAdminRoleService;
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
public class AdminAdminRoleServiceImpl implements AdminAdminRoleService{
    @Autowired
    private AdminAdminRoleMapper adminAdminRoleMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Override
    public Result addAdminAdminRole(String adminId, String adminRoleId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(adminId)){
                code = "-3";
                msg = "请选择要分配的管理员";
            }else if(StringUtils.isBlank(adminRoleId)){
                code = "-4";
                msg = "请选择要分配的角色";
            }else{
                Admin admin = adminMapper.selectByPrimaryKey(adminId);
                AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(adminRoleId);
                if(admin == null){
                    code = "-5";
                    msg ="不存在要分配的管理员对象";
                }else if(adminRole == null){
                    code = "-6";
                    msg ="不存在要分配的角色";
                }else{
                    AdminAdminRole adminAdminRole = new AdminAdminRole();
                    adminAdminRole.setAdminId(adminId);
                    adminAdminRole.setAdminRoleId(adminRoleId);
                    AdminAdminRole adminAdminRole_db = adminAdminRoleMapper.selectByAdminIdAndAdminRoleId(adminAdminRole);
                    if(adminAdminRole_db != null){
                        code = "-7";
                        msg ="已分配过该角色";
                    }else{
                        adminAdminRole.setId(UUID.randomUUID().toString().replace("-", ""));
                        adminAdminRole.setDelFlag("0");
                        adminAdminRole.setCreateTime(new Date());
                        adminAdminRoleMapper.insertSelective(adminAdminRole);
                        code = Constants.SUCCESS;
                        msg = "成功";
                    }
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
    public Result addAdminAdminRoles(String adminId, String[] adminRoleIds) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(adminId)){
                code = "-3";
                msg = "请选择要分配的管理员";
            }else if(adminRoleIds == null){
                code = "-4";
                msg = "请选择分配的角色";
            }else{
                Admin admin = adminMapper.selectByPrimaryKey(adminId);
                Boolean flag = true;
                for (String adminRoleId:adminRoleIds) {
                    AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(adminRoleId);
                    if(adminRole == null){
                        flag = false;
                    }
                }
                if(admin == null){
                    code = "-5";
                    msg ="不存在要分配的管理员对象";
                }else if(!flag){
                    code = "-6";
                    msg ="存在找不到的角色对象";
                }else{
                    List<AdminAdminRole> adminAdminRoleList_db = adminAdminRoleMapper.selectByAdminId(adminId);
                    for (AdminAdminRole adminAdminRole:adminAdminRoleList_db) {
                        adminAdminRoleMapper.deleteByPrimaryKey(adminAdminRole.getId());
                    }
                    for (String adminRoleId:adminRoleIds) {
                        AdminAdminRole adminAdminRole = new AdminAdminRole();
                        adminAdminRole.setAdminId(adminId);
                        adminAdminRole.setAdminRoleId(adminRoleId);
                        adminAdminRole.setId(UUID.randomUUID().toString().replace("-", ""));
                        adminAdminRole.setDelFlag("0");
                        adminAdminRole.setCreateTime(new Date());
                        adminAdminRoleMapper.insertSelective(adminAdminRole);
                    }
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
}
