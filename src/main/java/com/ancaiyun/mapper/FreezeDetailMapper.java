package com.ancaiyun.mapper;

import com.ancaiyun.entity.FreezeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FreezeDetailMapper {

    /**
     * 条件查询会员冻结明细
     * @param params 查询参数
     * @return
     */
    public List<FreezeDetail> getList(Map<String, Object> params);

    /**
     * 根据id查询冻结明细
     * @param id 主键id
     * @return
     */
    public FreezeDetail getById(String id);

    /**
     * 通过相关id和冻结类型查询冻结明细
     * @param relationId 相关id
     * @param freezeType 冻结类型
     * @return
     */
    public FreezeDetail getByRelationIdAndFreezeType(@Param("relationId") String relationId, @Param("freezeType") String freezeType);

    /**
     * 修改冻结明细
     * @param freezeDetail 冻结明细
     * @return
     */
    public int update(FreezeDetail freezeDetail);
}
