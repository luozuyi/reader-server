package com.ancaiyun.bid.service.impl;/**
 * <p>Title: PurchaserBidServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 14:31
 */

import com.ancaiyun.bid.mapper.MaterialMapper;
import com.ancaiyun.bid.mapper.ProductSubCategoryRelevanceMapper;
import com.ancaiyun.bid.mapper.PurchaserBidMapper;
import com.ancaiyun.bid.mapper.SupplierInfoMapper;
import com.ancaiyun.bid.service.PurchaserBidService;
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
import java.util.Map;

/**
 * <p>Title:PurchaserBidServiceImpl</p>
 * <p>Description: 招投标Service实现</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 14:31
 */
@Transactional
@Service
public class PurchaserBidServiceImpl implements PurchaserBidService {

    @Autowired
    private PurchaserBidMapper purchaserBidMapper;

    @Autowired
    private SupplierInfoMapper supplierInfoMapper;

    @Autowired
    private ProductSubCategoryRelevanceMapper productSubCategoryRelevanceMapper;
    /*
     * @Description 查询所有招标信息
     * @Date 16:48 2018/5/29
     * @Param
     * @return
     **/

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            //查询全部招标
            PageHelperNew.startPage(pageNum, pageSize);
            List<ModelMap> modelMaps = purchaserBidMapper.getAll(params);
            PageInfo<ModelMap> page = new PageInfo<>(modelMaps);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
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
     * @Description 查询招投标详情
     * @Date 18:16 2018/5/29
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

                ModelMap map = new ModelMap();
                //查询招标详情
                ModelMap modelMap = purchaserBidMapper.getDetail(id);
                //查询招标物资
                List<ModelMap> materilMap = materialMapper.getByBid(id);

                //查询关联物资
                List<ModelMap> products=productSubCategoryRelevanceMapper.getByRelevanceId(id);
                map.addAttribute("productRelevance",products);
                map.addAttribute("purchaserBid", modelMap);
                map.addAttribute("materil", materilMap);
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

    /*
     * @Description 将招投标信息删除
     * @Date 9:13 2018/6/2
     * @Param
     * @return
     **/

    @Override
    public Result delecte(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isNotBlank(id)) {
                //查询全部招标
                Boolean flag = purchaserBidMapper.delete(id);
                if (flag) {
                    code = Constants.SUCCESS;
                    msg = "成功";
                } else {
                    code = "3";
                    msg = "下架失败";
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

    /*
     * @Description 查看供应商列表
     * @Date 10:32 2018/6/4
     * @Param
     * @return
     **/

    @Override
    public Result getSupplier(Integer pageNum, Integer pageSize, String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isNotBlank(id)) {
                ModelMap modelMap = purchaserBidMapper.getDetail(id);
                String type = (String) modelMap.get("type");
                if (StringUtils.isNotBlank(type)) {
                    //邀请招标
                    if ("1".equals(type)) {
                        //查询被邀请的所有供应商

                        PageHelperNew.startPage(pageNum, pageSize);
                        if (StringUtils.isNotBlank(id)) {
                            List<ModelMap> modelMaps = supplierInfoMapper.getByBidId(id);
                            PageInfo<ModelMap> page = new PageInfo<>(modelMaps);
                            result.setData(page);

                            code = Constants.SUCCESS;
                            msg = "成功";
                        } else {
                            code = "3";
                            msg = "id不能为空";
                        }
                    } else {
                        //公开招标查看供应商
                        if (StringUtils.isNotBlank(id)) {
                            PageHelperNew.startPage(pageNum, pageSize);
                            List<ModelMap> modelMaps = supplierInfoMapper.getByPurchaserBidId(id);
                            PageInfo<ModelMap> page = new PageInfo<>(modelMaps);
                            result.setData(page);

                            code = Constants.SUCCESS;
                            msg = "成功";
                        } else {
                            code = "3";
                            msg = "id不能为空";
                        }
                    }
                } else {
                    code = "3";
                    msg = "无法查询到该数据";
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
