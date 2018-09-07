package com.ancaiyun.mapper;

import com.ancaiyun.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    List<Member> selectAllBySelection(Map<String, Object> params);

    List<Map<String,Object>> selectAllBySelectionResultMap(Map<String, Object> params);

    Member selectByExtraDataId(String exteaDataId);

    int updateExtraDataStatusByPrimaryKey(Member record);

    Member selectByUserId(String userId);
}