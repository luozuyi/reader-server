package com.ancaiyun.mapper;

import com.ancaiyun.entity.AdminAdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminAdminRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminAdminRole record);

    int insertSelective(AdminAdminRole record);

    AdminAdminRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminAdminRole record);

    int updateByPrimaryKey(AdminAdminRole record);

    List<AdminAdminRole> selectByAdminId(String adminId);

    List<AdminAdminRole> selectByAdminRoleId(String adminRoleId);

    AdminAdminRole selectByAdminIdAndAdminRoleId(AdminAdminRole record);
}