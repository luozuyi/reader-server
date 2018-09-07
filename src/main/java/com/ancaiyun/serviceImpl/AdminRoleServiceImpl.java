package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.AdminAdminRole;
import com.ancaiyun.entity.AdminRole;
import com.ancaiyun.mapper.AdminAdminRoleMapper;
import com.ancaiyun.mapper.AdminRoleMapper;
import com.ancaiyun.service.AdminRoleService;
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
public class AdminRoleServiceImpl implements AdminRoleService{
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private AdminAdminRoleMapper adminAdminRoleMapper;
    @Override
    public Result addAdminRole(String roleName,String info) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(roleName)){
                code = "-3";
                msg = "角色名称不能为空";
            }else if(StringUtils.isBlank(info)){
                code = "-4";
                msg = "角色描述不能为空";
            }else{
                AdminRole adminRole_db = adminRoleMapper.selectByRoleName(roleName);
                if(adminRole_db != null){
                    code = "-5";
                    msg = "该角色已存在";
                }else{
                    AdminRole adminRole = new AdminRole();
                    adminRole.setId(UUID.randomUUID().toString().replace("-", ""));
                    adminRole.setCreateTime(new Date());
                    adminRole.setDelFlag("0");
                    adminRole.setRoleName(roleName);
                    adminRole.setInfo(info);
                    adminRoleMapper.insertSelective(adminRole);
                    code = Constants.SUCCESS;
                    msg = "添加成功";
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
            List<AdminRole> adminRoleList = adminRoleMapper.selectAll();
            PageInfo<AdminRole> page = new PageInfo<>(adminRoleList);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result updateAdminRoleById(AdminRole adminRole) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(adminRole.getId())){
                code = "-3";
                msg = "修改对象不能为空";
            }else if(StringUtils.isBlank(adminRole.getRoleName())){
                code = "-4";
                msg = "角色名称不能为空";
            }else if(StringUtils.isBlank(adminRole.getInfo())){
                code = "-5";
                msg = "角色描述不能为空";
            }else{
                AdminRole adminRole_db = adminRoleMapper.selectByPrimaryKey(adminRole.getId());
                if(adminRole_db == null){
                    code = "-6";
                    msg = "修改对象不存在";
                }else{
                    adminRole_db.setInfo(adminRole.getRoleName());
                    adminRole_db.setInfo(adminRole.getInfo());
                    adminRoleMapper.updateByPrimaryKeySelective(adminRole_db);
                    code = Constants.SUCCESS;
                    msg = "添加成功";
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
    public Result deleteById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "删除对象id不能为空";
            }else{
                AdminRole adminRole_db = adminRoleMapper.selectByPrimaryKey(id);
                if(adminRole_db == null){
                    code = "-4";
                    msg = "删除对象不存在";
                }else{
                    adminRole_db.setDelFlag("1");
                    adminRoleMapper.updateByPrimaryKeySelective(adminRole_db);
                    List<AdminAdminRole> adminAdminRoleList = adminAdminRoleMapper.selectByAdminRoleId(id);
                    for (AdminAdminRole adminAdminRole:adminAdminRoleList) {
                        adminAdminRoleMapper.deleteByPrimaryKey(adminAdminRole.getId());
                    }
                    code = Constants.SUCCESS;
                    msg = "删除成功";
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
