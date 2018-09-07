package com.ancaiyun.bid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title: SupplierOtherBidMapper</p>
 * <p>Description: 供应商报价Mapper</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 15:36
 */
@Repository
@Mapper
public interface SupplierOtherBidMapper {
    /*
    * @Description 查询全部报价信息
    * @Date 16:00 2018/6/4
    * @Param 
    * @return 
    **/
    
    List<ModelMap> getAll(String id);

    /*
    * @Description 查看供应商报价信息详情
    * @Date 16:21 2018/6/4
    * @Param 
    * @return 
    **/
    
    ModelMap getDetail(String id);

    /**
     * <p>Title: SupplierMaterialMapper</p>
     * <p>Description: 投标,报价及发货单物资Mapper</p>
     *
     * @author zhangzhanyang
     * @date 2018/6/5 18:27
     */
    @Mapper
    @Repository
    interface SupplierMaterialMapper {



    }
}
