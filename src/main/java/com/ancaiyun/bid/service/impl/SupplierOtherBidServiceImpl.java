package com.ancaiyun.bid.service.impl;/**
 * <p>Title: SupplierOtherBidServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 15:33
 */

import com.ancaiyun.bid.mapper.SupplierMaterialMapper;
import com.ancaiyun.bid.mapper.SupplierOtherBidMapper;
import com.ancaiyun.bid.service.SupplierOtherBidService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>Title:SupplierOtherBidServiceImpl</p>
 * <p>Description: 供应商报价Service实现</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 15:33
 */
@Service
@Transactional
public class SupplierOtherBidServiceImpl implements SupplierOtherBidService {


    @Autowired
    private SupplierOtherBidMapper supplierOtherBidMapper;


    @Autowired
    private SupplierMaterialMapper supplierMaterialMapper;

    @Override
    public Result getAll(Integer pageNum, Integer pageSize, String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            //查询全部报价信息
            PageHelperNew.startPage(pageNum, pageSize);
            if (StringUtils.isNotBlank(id)) {
                List<ModelMap> modelMaps = supplierOtherBidMapper.getAll(id);
                PageInfo<ModelMap> page = new PageInfo<>(modelMaps);

                result.setData(page);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                code = "3";
                msg = "id不能为空";
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /*
     * @Description 查看供应商报价详情
     * @Date 16:10 2018/6/4
     * @Param
     * @return
     **/

    @Override
    public Result getDetail(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isNotBlank(id)) {
                ModelMap map=new ModelMap();

                //查询报价的详情信息
                ModelMap modelMap = supplierOtherBidMapper.getDetail(id);

                //查询报价物资
                List<ModelMap> materialMap=supplierMaterialMapper.getOtherBid(id);

                map.addAttribute("supplierOtherBid",modelMap);
                map.addAttribute("material",materialMap);
                result.setData(map);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                code = "2";
                msg = "id不能为空";
            }

        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
