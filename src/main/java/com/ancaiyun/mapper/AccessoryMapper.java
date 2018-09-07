package com.ancaiyun.mapper;

import com.ancaiyun.entity.Accessory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccessoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Accessory record);

    int insertSelective(Accessory record);

    Accessory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Accessory record);

    int updateByPrimaryKey(Accessory record);
}