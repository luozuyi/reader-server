package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.FriendshipLink;
import com.ancaiyun.mapper.FriendshipLinkMapper;
import com.ancaiyun.service.FriendshipLinkService;
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
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class FriendshipLinkServiceImpl implements FriendshipLinkService {
    @Autowired
    private FriendshipLinkMapper friendshipLinkMapper;

    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<FriendshipLink> friendshipLinkList = friendshipLinkMapper.selectAll();
            PageInfo<FriendshipLink> page = new PageInfo<>(friendshipLinkList);
            code = Constants.SUCCESS;
            msg = "成功";
            result.setData(page);
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result addFriendshipLink(FriendshipLink friendshipLink) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
           if(StringUtils.isBlank(friendshipLink.getFriendshipAddress())){
                code = "-3";
                msg = "网址不能为空";
            }else if(StringUtils.isBlank(friendshipLink.getFriendshipMobile())){
               code = "-4";
               msg = "电话不能为空";
           }else{
               friendshipLink.setId(UUID.randomUUID().toString().replace("-", ""));
               friendshipLink.setCreateTime(new Date());
               friendshipLink.setDelFlag("0");
               friendshipLink.setStatus("0");
               friendshipLink.setIsHidden("2");
               friendshipLinkMapper.insertSelective(friendshipLink);
               code = Constants.SUCCESS;
               msg = "成功";
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

    @Override
    public Result updateFriendshipLinkIsHiddenStatus(String id, String isHidden) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "请选择要操作的对象";
            }else if(StringUtils.isBlank(isHidden)){
                code = "-4";
                msg = "请选择操作";
            }else if(!"1".equals(isHidden) && !"2".equals(isHidden)){
                code = "-5";
                msg = "请正确选择是否显示状态";
            }else{
                FriendshipLink friendshipLink_db = friendshipLinkMapper.selectByPrimaryKey(id);
                if(friendshipLink_db == null){
                    code = "-6";
                    msg = "要操作的对象不存在";
                }else{
                    friendshipLink_db.setIsHidden(isHidden);
                    friendshipLinkMapper.updateByPrimaryKeySelective(friendshipLink_db);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result updateFriendshipLinkStatus(String id, String status) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "请选择要操作的对象";
            }else if(StringUtils.isBlank(status)){
                code = "-4";
                msg = "请选择操作";
            }else if(!"1".equals(status) && !"2".equals(status)){
                code = "-5";
                msg = "请正确选择是否审核通过状态";
            }else{
                FriendshipLink friendshipLink_db = friendshipLinkMapper.selectByPrimaryKey(id);
                if(friendshipLink_db == null){
                    code = "-6";
                    msg = "要操作的对象不存在";
                }else{
                    friendshipLink_db.setStatus(status);
                    friendshipLinkMapper.updateByPrimaryKeySelective(friendshipLink_db);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result listPageBySelection(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            params.put("delFlag", "0");
            PageHelperNew.startPage(pageNum, pageSize);
            List<FriendshipLink> friendshipLinkList = friendshipLinkMapper.selectAllBySelection(params);
            PageInfo<FriendshipLink> page = new PageInfo<>(friendshipLinkList);
            code = Constants.SUCCESS;
            msg = "成功";
            result.setData(page);
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
