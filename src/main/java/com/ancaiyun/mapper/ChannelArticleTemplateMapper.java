package com.ancaiyun.mapper;

import com.ancaiyun.entity.ChannelArticleTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ChannelArticleTemplateMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChannelArticleTemplate record);

    int insertSelective(ChannelArticleTemplate record);

    ChannelArticleTemplate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChannelArticleTemplate record);

    int updateByPrimaryKey(ChannelArticleTemplate record);

    List<ChannelArticleTemplate> selectAll();

    ChannelArticleTemplate selectByTplUrl(String tplUrl);

    List<ChannelArticleTemplate> selectAllBySelect(Map<String,Object> params);
}