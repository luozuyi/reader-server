package com.ancaiyun.bid.service.impl;/**
 * <p>Title: SupplierBidServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 12:04
 */

import com.ancaiyun.bid.mapper.PurchaserBidMapper;
import com.ancaiyun.bid.mapper.SupplierBidMapper;
import com.ancaiyun.bid.mapper.SupplierMaterialMapper;
import com.ancaiyun.bid.service.SupplierBidService;
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

import javax.jws.WebParam;
import java.util.List;

/**
 * <p>Title:SupplierBidServiceImpl</p>
 * <p>Description: 投标报价Service实现</p>
 *
 * @author zhangzhanyang
 * @date 2018/6/4 12:04
 */
@Transactional
@Service
public class SupplierBidServiceImpl implements SupplierBidService {

    @Autowired
    private SupplierBidMapper supplierBidMapper;

    @Autowired
    private PurchaserBidMapper purchaserBidMapper;

    @Autowired
    private SupplierMaterialMapper supplierMaterialMapper;
    /*
     * @Description 查看所有投标信息
     * @Date 14:35 2018/6/4
     * @Param
     * @return
     **/

    @Override
    public Result getAll(Integer pageNum, Integer pageSize, String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isNotBlank(id)) {
                //查询全部投标信息
                PageHelperNew.startPage(pageNum, pageSize);
                List<ModelMap> modelMaps = supplierBidMapper.getAll(id);
                PageInfo<ModelMap> page = new PageInfo<>(modelMaps);

                result.setData(page);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                code = "3";
                msg = "招标id不能为空";
            }
        } catch (
                Exception e)

        {
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
     * @Description 查询投标信息详情
     * @Date 15:16 2018/6/4
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
                //查询投标信息详情
                ModelMap model = new ModelMap();
                ModelMap modelMap = supplierBidMapper.getDetail(id);
                model.addAttribute("supplier", modelMap);
                String bidId = (String) modelMap.get("bidId");

                //查看投标物资
                List<ModelMap> modelMaps=supplierMaterialMapper.getBySupplierBid(id);
                model.addAttribute("material", modelMaps);
                if (StringUtils.isNotBlank(bidId)) {
                    //查看招标详情
                    ModelMap purModel = purchaserBidMapper.getDetail(bidId);
                    model.addAttribute("purchaserBid", purModel);
                    result.setData(model);
                    code = Constants.SUCCESS;
                    msg = "成功";
                } else {
                    code = "3";
                    msg = "数据查询失败";
                }
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
