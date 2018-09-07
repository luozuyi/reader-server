package com.ancaiyun.controller;

import com.ancaiyun.entity.Channel;
import com.ancaiyun.service.ChannelService;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    /**
     * 分页查询栏目
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @RequestMapping(value = "v1/auth/channels/pagination",method = RequestMethod.GET)
    public Result listPage(Integer pageNum, Integer pageSize) {
        return channelService.listPage(pageNum, pageSize);
    }

    /**
     * 添加栏目
     * @param channel
     * @return
     */
    @RequestMapping(value = "v1/auth/channels",method = RequestMethod.POST)
    public Result addChannel(Channel channel) {
        return channelService.addChannel(channel);
    }
}
