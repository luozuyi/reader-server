package com.ancaiyun.mapper;

import com.ancaiyun.entity.IncomeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IncomeDetailMapper {

    /**
     * 条件查询会员资金明细
     * @param params 查询参数
     * @return
     */
    public List<IncomeDetail> getList(Map<String,Object> params);

    /**
     * 添加资金明细
     * @param incomeDetail 资金明细
     * @return
     */
    public int insert(IncomeDetail incomeDetail);
}
