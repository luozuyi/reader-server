package com.ancaiyun.mapper;

import com.ancaiyun.entity.OfflineRemittance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OfflineRemittanceMapper {

    /**
     * 条件查询所有线下充值记录
     * @param params 查询参数
     * @return
     */
    public List<OfflineRemittance> getList(Map<String,Object>params);

    /**
     * 根据id查询线下充值记录
     * @param id 主键jd
     * @return
     */
    public OfflineRemittance getById(String id);

    /**
     * 修改线下充值记录
     * @param offlineRemittance 线下充值
     * @return
     */
    public int update(OfflineRemittance offlineRemittance);
}
