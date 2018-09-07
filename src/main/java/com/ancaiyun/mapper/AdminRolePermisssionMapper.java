package com.ancaiyun.mapper;

import com.ancaiyun.entity.AdminRolePermisssion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRolePermisssionMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminRolePermisssion record);

    int insertSelective(AdminRolePermisssion record);

    AdminRolePermisssion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminRolePermisssion record);

    int updateByPrimaryKey(AdminRolePermisssion record);

    List<AdminRolePermisssion> selectByAdminRoleId(String adminRoleId);
}