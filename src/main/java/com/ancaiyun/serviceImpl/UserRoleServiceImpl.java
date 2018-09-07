package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Role;
import com.ancaiyun.entity.User;
import com.ancaiyun.entity.UserRoleKey;
import com.ancaiyun.mapper.RoleMapper;
import com.ancaiyun.mapper.UserMapper;
import com.ancaiyun.mapper.UserRoleMapper;
import com.ancaiyun.service.UserRoleService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Transactional
@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Result addUserRole(String userId, String[] roleIds) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(userId)){
                code = "-3";
                msg = "请选择要分配的用户";
            }else if(roleIds == null){
                code = "-4";
                msg = "请选择分配的角色";
            }else{
                User user = userMapper.selectByPrimaryKey(userId);
                Boolean flag = true;
                for (String roleId:roleIds) {
                    Role role = roleMapper.selectByPrimaryKey(roleId);
                    if(role == null){
                        flag = false;
                    }
                }
                if(user == null){
                    code = "-5";
                    msg ="不存在要分配的用户对象";
                }else if(!flag){
                    code = "-6";
                    msg ="存在找不到的角色对象";
                }else{
                    List<UserRoleKey> userRoleKeyList_db = userRoleMapper.selectByUserId(userId);
                    for (UserRoleKey userRoleKey:userRoleKeyList_db) {
                        userRoleMapper.deleteByPrimaryKey(userRoleKey);
                    }
                    for (String roleId:roleIds) {
                        UserRoleKey userRoleKey = new UserRoleKey();
                        userRoleKey.setUserId(userId);
                        userRoleKey.setRoleId(roleId);
                        userRoleMapper.insertSelective(userRoleKey);
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
