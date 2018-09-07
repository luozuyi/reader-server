package com.ancaiyun.mapper;

import com.ancaiyun.entity.RoleResKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RoleResMapper {
    int deleteByPrimaryKey(RoleResKey key);

    int insert(RoleResKey record);

    int insertSelective(RoleResKey record);

    RoleResKey selectByRoleIdAndResId(RoleResKey record);

    List<RoleResKey> selectByRoleId(String roleId);
}