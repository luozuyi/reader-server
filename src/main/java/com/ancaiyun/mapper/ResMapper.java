package com.ancaiyun.mapper;

import com.ancaiyun.entity.Res;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResMapper {
    int deleteByPrimaryKey(String id);

    int insert(Res record);

    int insertSelective(Res record);

    Res selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Res record);

    int updateByPrimaryKey(Res record);

    List<Res> selectByType(String type);

    List<Res> selectAll();

    List<Res> selectByResModuleType(String resModuleType);
}