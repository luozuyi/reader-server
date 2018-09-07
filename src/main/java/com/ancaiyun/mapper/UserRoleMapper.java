package com.ancaiyun.mapper;

import com.ancaiyun.entity.UserRoleKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    List<UserRoleKey> selectByUserId(String userId);
}