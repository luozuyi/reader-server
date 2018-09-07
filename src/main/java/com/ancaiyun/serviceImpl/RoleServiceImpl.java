package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Role;
import com.ancaiyun.mapper.RoleMapper;
import com.ancaiyun.service.RoleService;
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
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Result addRole(String name, String type) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(name)){
                code = "-3";
                msg = "角色名称不能为空";
            }else if(StringUtils.isBlank(type)){
                code = "-4";
                msg = "角色类型不能为空";
            }else{
                Role role_db = roleMapper.selectByName(name);
                if(role_db != null){
                    code = "-5";
                    msg = "该角色已存在";
                }else{
                    Role role = new Role();
                    role.setId(UUID.randomUUID().toString().replace("-", ""));
                    role.setCreateTime(new Date());
                    role.setDelFlag("0");
                    role.setName(name);
                    role.setType(type);
                    roleMapper.insertSelective(role);
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
            List<Role> roleList = roleMapper.selectAll();
            PageInfo<Role> page = new PageInfo<>(roleList);
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
}
