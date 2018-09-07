package com.ancaiyun.mapper;

import com.ancaiyun.entity.ChildAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ChildAccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChildAccount record);

    int insertSelective(ChildAccount record);

    ChildAccount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChildAccount record);

    int updateByPrimaryKey(ChildAccount record);

    List<Map<String,Object>> selectChildListByUserId(Map<String,Object> params);

    Map<String,Object> selectParentByMemberId(String memberId);
}