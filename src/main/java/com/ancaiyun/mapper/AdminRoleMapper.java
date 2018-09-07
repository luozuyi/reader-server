package com.ancaiyun.mapper;

import com.ancaiyun.entity.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);

    AdminRole selectByRoleName(String roleName);

    List<AdminRole> selectAll();
}