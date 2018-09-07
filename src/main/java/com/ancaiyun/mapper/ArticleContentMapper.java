package com.ancaiyun.mapper;

import com.ancaiyun.entity.ArticleContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleContent record);

    int insertSelective(ArticleContent record);

    ArticleContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleContent record);

    int updateByPrimaryKeyWithBLOBs(ArticleContent record);

    List<ArticleContent> selectAll();
}