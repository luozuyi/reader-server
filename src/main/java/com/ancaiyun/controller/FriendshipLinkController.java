package com.ancaiyun.controller;

import com.ancaiyun.entity.FriendshipLink;
import com.ancaiyun.service.FriendshipLinkService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FriendshipLinkController {
    @Autowired
    private FriendshipLinkService friendshipLinkService;

    /**
     * 分页查询友情连接
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/friendship-links/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize){
        return friendshipLinkService.listPage(pageNum, pageSize);
    }

    /**
     * 添加友情连接
     * @param friendshipLink 友情连接对象
     * @return
     */
    @RequestMapping(value = "v1/auth/friendship-links",method = RequestMethod.POST)
    public Result addFriendshipLink(FriendshipLink friendshipLink) {
        return friendshipLinkService.addFriendshipLink(friendshipLink);
    }

    /**
     * 隐藏或显示友情连接
     * @param id 主键id
     * @param isHidden 隐藏状态 1：不隐藏2：隐藏
     * @return
     */
    @RequestMapping(value = "v1/auth/friendship-links/hidden-status",method = RequestMethod.PATCH)
    public Result updateFriendshipLinkIsHiddenStatus(String id, String isHidden) {
        return friendshipLinkService.updateFriendshipLinkIsHiddenStatus(id, isHidden);
    }

    /**
     * 友情连接审核是否通过
     * @param id 主键id
     * @param status 审核状态0：出始状态1：审核通过2：审核不通过
     * @return
     */
    @RequestMapping(value = "v1/auth/friendship-links/status",method = RequestMethod.PATCH)
    public Result updateFriendshipLinkStatus(String id, String status) {
        return friendshipLinkService.updateFriendshipLinkStatus(id, status);
    }

    /**
     * 动态分页查询
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @param params 动态参数map
     * @return
     */
    @RequestMapping(value = "v1/auth/friendship-links/pagination/selection",method = RequestMethod.GET)
    public Result listPageBySelection(Integer pageNum, Integer pageSize, @RequestParam Map<String, Object> params) {
        return friendshipLinkService.listPageBySelection(pageNum, pageSize, params);
    }
}
