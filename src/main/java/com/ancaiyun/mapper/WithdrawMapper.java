package com.ancaiyun.mapper;

import com.ancaiyun.entity.Withdraw;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface WithdrawMapper {

    /**
     * 条件查询所有提现记录
     * @param params 查询参数
     * @return
     */
    public List<Withdraw> getList(Map<String, Object> params);

    /**
     * 根据id查询提现记录
     * @param id 主键id
     * @return
     */
    public Withdraw getById(String id);

    /**
     * 修改提现记录
     * @param withdraw
     * @return
     */
    public int update(Withdraw withdraw);
}
