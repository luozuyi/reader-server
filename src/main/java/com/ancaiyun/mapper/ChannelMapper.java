package com.ancaiyun.mapper;

import com.ancaiyun.entity.Channel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChannelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    List<Channel> selectAll();
}