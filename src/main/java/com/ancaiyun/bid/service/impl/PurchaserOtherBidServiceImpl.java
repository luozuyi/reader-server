package com.ancaiyun.bid.service.impl;
/**
 * <p>Title: PurchaserOtherBidServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 10:15
 */

import com.ancaiyun.bid.mapper.MaterialMapper;
import com.ancaiyun.bid.mapper.PurchaserOtherBidMapper;
import com.ancaiyun.bid.service.PurchaserOtherBidService;
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
 * <p>Title:PurchaserOtherBidServiceImpl</p>
 * <p>Description: 竞价service实现</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/29 10:15
 */
@Transactional
@Service
public class PurchaserOtherBidServiceImpl implements PurchaserOtherBidService {


    @Autowired
    private PurchaserOtherBidMapper purchaserOtherBidMapper;


    @Autowired
    private MaterialMapper materialMapper;

    /*
     * @Description 查询所有的竞价信息
     * @Date 11:19 2018/5/29
     * @Param
     * @return
     **/
    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            //查询全部竞价
            PageHelperNew.startPage(pageNum,pageSize);
            List<ModelMap> modelMaps = purchaserOtherBidMapper.getAll(params);
            PageInfo<ModelMap> page = new PageInfo<>(modelMaps);
            result.setData(page);
            code=Constants.SUCCESS;
            msg="成功";
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
    * @Description 查看竞价采购详情
    * @Date 9:34 2018/6/2
    * @Param 
    * @return 
    **/
    
    @Override
    public Result getDetail(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isNotBlank(id)) {
                ModelMap map=new ModelMap();
                //查看竞价详情
                ModelMap modelMap = purchaserOtherBidMapper.getDetail(id);

                //查询竞价物资
                List<ModelMap> materialMap=materialMapper.getByOtherBid(id);

                map.addAttribute("otherBid",modelMap);
                map.addAttribute("material",materialMap);
                result.setData(map);
                code = Constants.SUCCESS;
                msg = "成功";
            }else{
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
    * @Description 删除竞价采购信息
    * @Date 9:35 2018/6/2
    * @Param 
    * @return 
    **/
    
    @Override
    public Result delete(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isNotBlank(id)) {
                //删除竞价信息
                Boolean flag= purchaserOtherBidMapper.delete(id);
                if(flag){
                    code = Constants.SUCCESS;
                    msg = "成功";
                }else{
                    code="3";
                    msg="删除失败";
                }

            }else{
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

