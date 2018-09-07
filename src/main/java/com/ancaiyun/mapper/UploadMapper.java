package com.ancaiyun.mapper;

import com.ancaiyun.entity.Upload;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UploadMapper {
    int deleteByPrimaryKey(String id);

    int insert(Upload record);

    int insertSelective(Upload record);

    Upload selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Upload record);

    int updateByPrimaryKey(Upload record);

    List<Upload> selectAll();

    List<Upload> selectByFileRealName(String fileRealName);
}