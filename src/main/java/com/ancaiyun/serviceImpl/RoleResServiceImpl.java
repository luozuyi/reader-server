package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Res;
import com.ancaiyun.entity.Role;
import com.ancaiyun.entity.RoleResKey;
import com.ancaiyun.mapper.ResMapper;
import com.ancaiyun.mapper.RoleMapper;
import com.ancaiyun.mapper.RoleResMapper;
import com.ancaiyun.service.RoleResService;
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
public class RoleResServiceImpl implements RoleResService{
    @Autowired
    private RoleResMapper roleResMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResMapper resMapper;
    @Override
    public Result addRoleRes(String roleId, String[] resIds) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(roleId)){
                code = "-3";
                msg = "请选择要分配的角色";
            }else if(resIds == null){
                code = "-4";
                msg = "请选择分配的资源";
            }else{
                Role role_db = roleMapper.selectByPrimaryKey(roleId);
                Boolean flag = true;
                for (String resId:resIds) {
                    Res res_db = resMapper.selectByPrimaryKey(resId);
                    if(res_db == null){
                        flag = false;
                    }
                }
                if(role_db == null){
                    code = "-5";
                    msg ="不存在要分配的角色对象";
                }else if(!flag){
                    code = "-6";
                    msg ="存在找不到的权限对象";
                }else{
                    List<RoleResKey> roleResKeyList_db = roleResMapper.selectByRoleId(roleId);
                    for (RoleResKey roleResKey:roleResKeyList_db) {
                        roleResMapper.deleteByPrimaryKey(roleResKey);
                    }
                    for (String resId:resIds) {
                        RoleResKey roleResKey = new RoleResKey();
                        roleResKey.setResId(resId);
                        roleResKey.setRoleId(roleId);
                        roleResMapper.insertSelective(roleResKey);
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
