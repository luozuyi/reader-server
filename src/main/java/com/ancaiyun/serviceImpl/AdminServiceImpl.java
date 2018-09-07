package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Admin;
import com.ancaiyun.mapper.AdminMapper;
import com.ancaiyun.service.AdminService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.PatternUtil;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Result addAdmin(String adminName, String adminPassword, String adminRealName) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(adminName)){
                code = "-3";
                msg = "登陆名不能为空";
            }else if(StringUtils.isBlank(adminPassword)){
                code = "-4";
                msg = "密码不能为空";
            }else if(StringUtils.isBlank(adminRealName)){
                code = "-5";
                msg = "真实姓名不能为空";
            }else if(!PatternUtil.patternString(adminName, "username")){
                code = "-6";
                msg = "登陆名格式不正确";
            }else if(!PatternUtil.patternString(adminPassword, "password")){
                code = "-7";
                msg = "密码格式不正确";
            }else if(!PatternUtil.patternString(adminRealName, "realName")){
                code = "-8";
                msg = "真实姓名格式不正确";
            }else{
                Admin admin_db = adminMapper.selectByAdminName(adminName);
                if(admin_db != null){
                    code = "-5";
                    msg = "已存在";
                }else{
                    Admin admin = new Admin();
                    admin.setId(UUID.randomUUID().toString().replace("-", ""));
                    admin.setCreateTime(new Date());
                    admin.setDelFlag("0");
                    admin.setAdminName(adminName);
                    admin.setAdminPassword(adminPassword);
                    admin.setAdminRealName(adminRealName);
                    admin.setAdminStatus("0");
                    adminMapper.insertSelective(admin);
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
    public Result listPageBySelect(Integer pageNum,Integer pageSize,Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Admin> adminList = adminMapper.selectAllBySelect(params);
            PageInfo<Admin> page = new PageInfo<>(adminList);
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
    public Result updateAdminById(Admin admin) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(admin.getId())){
               code = "-3";
               msg = "请选择修改的对象";
            }else if(StringUtils.isBlank(admin.getAdminPassword())){
                code = "-4";
                msg = "密码不能为空";
            }else if(StringUtils.isBlank(admin.getAdminRealName())){
                code = "-5";
                msg = "真实姓名不能为空";
            }else if(!PatternUtil.patternString(admin.getAdminPassword(), "password")){
                code = "-6";
                msg = "密码格式不正确";
            }else if(!PatternUtil.patternString(admin.getAdminRealName(), "realName")){
                code = "-7";
                msg = "真实姓名格式不正确";
            }else{
                Admin db_admin = adminMapper.selectByPrimaryKey(admin.getId());
                if(db_admin == null){
                    code = "-8";
                    msg = "不存在修改的对象";
                }else{
                    db_admin.setAdminRealName(admin.getAdminRealName());
                    db_admin.setAdminPassword(admin.getAdminPassword());
                    adminMapper.updateByPrimaryKeySelective(db_admin);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
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
    public Result deleteById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "请选择删除的对象";
            }else{
                Admin db_admin = adminMapper.selectByPrimaryKey(id);
                if(db_admin == null){
                    code = "-4";
                    msg = "不存在删除的对象";
                }else{
                    db_admin.setDelFlag("1");
                    adminMapper.updateByPrimaryKeySelective(db_admin);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
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
    public Result updateAdminForbbindById(String id, String adminStatus) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "请选择要禁用的对象";
            }else{
                Admin db_admin = adminMapper.selectByPrimaryKey(id);
                if(db_admin == null){
                    code = "-4";
                    msg = "不存在禁用的对象";
                }else{
                    db_admin.setAdminStatus(adminStatus);
                    adminMapper.updateByPrimaryKeySelective(db_admin);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
