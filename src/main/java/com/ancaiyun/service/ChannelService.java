package com.ancaiyun.service;

import com.ancaiyun.entity.Channel;
import com.ancaiyun.utils.Result;

public interface ChannelService {
    /**
     * 分页查询栏目
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result listPage(Integer pageNum, Integer pageSize);

    /**
     * 添加栏目
     * @param channel 栏目对象
     * @return
     */
    Result addChannel(Channel channel);
}
