package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Res;
import com.ancaiyun.entity.Role;
import com.ancaiyun.mapper.ResMapper;
import com.ancaiyun.mapper.RoleMapper;
import com.ancaiyun.service.ResService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ResServiceImpl implements ResService{
    @Autowired
    private ResMapper resMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Res> resList = resMapper.selectAll();
            PageInfo<Res> page = new PageInfo<>(resList);
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
    public Result listByRoleId(String roleId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            Role role_db = roleMapper.selectByPrimaryKey(roleId);
            if(role_db == null){
                code = "-3";
                msg = "请选择角色";
            }else{
                String type = role_db.getType();
                List<Res> resList = resMapper.selectByResModuleType(type);
                result.setData(resList);
                code = Constants.SUCCESS;
                msg = "成功";
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
