package com.ancaiyun.service;

import com.ancaiyun.entity.FriendshipLink;
import com.ancaiyun.utils.Result;

import java.util.Map;

public interface FriendshipLinkService {
    /**
     * 分页查询友情连接
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum,Integer pageSize);

    /**
     * 添加友情连接
     * @param friendshipLink 友情连接对象
     * @return
     */
    Result addFriendshipLink(FriendshipLink friendshipLink);

    /**
     * 修改显示或隐藏的状态
     * @param id 主键id
     * @param isHidden 1：不隐藏2：隐藏
     * @return
     */
    Result updateFriendshipLinkIsHiddenStatus(String id,String isHidden);

    /**
     * 修改审核是否通过
     * @param id 主键id
     * @param status 审核状态0：出始状态1：审核通过2：审核不通过
     * @return
     */
    Result updateFriendshipLinkStatus(String id,String status);

    /**
     * 分页查询动态条件搜索
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @param params map参数，存放查询条件
     * @return
     */
    Result listPageBySelection(Integer pageNum, Integer pageSize, Map<String,Object> params);
}
