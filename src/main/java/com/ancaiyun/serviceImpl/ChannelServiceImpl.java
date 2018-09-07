package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Channel;
import com.ancaiyun.mapper.ChannelMapper;
import com.ancaiyun.service.ChannelService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelMapper channelMapper;
    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Channel> channelList = channelMapper.selectAll();
            PageInfo<Channel> page = new PageInfo<>(channelList);
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
    public Result addChannel(Channel channel) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(channel.getChannelName())){
                code = "-3";
                msg = "栏目名称不能为空";
            }else if(StringUtils.isBlank(channel.getTplChannel())){
                code = "-4";
                msg = "栏目模板不能为空";
            }else{
                channel.setId(UUID.randomUUID().toString().replace("-", ""));
                channel.setDelFlag("0");
                channel.setCreateTime(new Date());
                channelMapper.insertSelective(channel);
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
