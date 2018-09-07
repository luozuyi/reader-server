package com.ancaiyun.mapper;

import com.ancaiyun.entity.AdminPermisssion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminPermisssionMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminPermisssion record);

    int insertSelective(AdminPermisssion record);

    AdminPermisssion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminPermisssion record);

    int updateByPrimaryKey(AdminPermisssion record);

    AdminPermisssion selectByUrlAndMethod(AdminPermisssion record);

    List<AdminPermisssion> sellectAll();
}