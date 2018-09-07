package com.ancaiyun.mapper;

import com.ancaiyun.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectAll();

    Admin selectByAdminName(String adminName);

    List<Admin> selectAllBySelect(Map<String,Object> params);
}