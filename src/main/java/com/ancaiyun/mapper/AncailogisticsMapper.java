package com.ancaiyun.mapper;

import com.ancaiyun.entity.Ancailogistics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AncailogisticsMapper {

    /**
     * 查询所有物流信息
     * @return
     */
    List<Ancailogistics> getList();
}
