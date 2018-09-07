package com.ancaiyun.mapper;

import com.ancaiyun.entity.FriendshipLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FriendshipLinkMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendshipLink record);

    int insertSelective(FriendshipLink record);

    FriendshipLink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendshipLink record);

    int updateByPrimaryKeyWithBLOBs(FriendshipLink record);

    int updateByPrimaryKey(FriendshipLink record);

    List<FriendshipLink> selectAll();

    List<FriendshipLink> selectAllBySelection(Map<String,Object> params);
}