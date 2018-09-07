package com.ancaiyun.mapper;

import com.ancaiyun.entity.MemberBank;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MemberBankMapper {

    /**
     * 条件查询用户银行账号
     * @param params 查询参数
     * @return
     */
    public List<Map<String, Object>> getList(Map<String,Object> params);
}
