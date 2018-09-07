package com.ancaiyun.mapper;

import com.ancaiyun.entity.MemberExtraData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberExtraDataMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberExtraData record);

    int insertSelective(MemberExtraData record);

    MemberExtraData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberExtraData record);

    int updateByPrimaryKeyWithBLOBs(MemberExtraData record);

    int updateByPrimaryKey(MemberExtraData record);

}