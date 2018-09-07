package com.ancaiyun.mapper;

import com.ancaiyun.entity.Partner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PartnerMapper {
    int deleteByPrimaryKey(String partnerId);

    int insert(Partner record);

    int insertSelective(Partner record);

    Partner selectByPrimaryKey(String partnerId);

    int updateByPrimaryKeySelective(Partner record);

    int updateByPrimaryKeyWithBLOBs(Partner record);

    int updateByPrimaryKey(Partner record);

    List<Partner> selectAll();
}