package com.ancaiyun.bid.service.impl;/**
 * <p>Title: ContractRejectServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhangzhanyang
 * @date 2018/5/30 9:35
 */

import com.ancaiyun.bid.mapper.ContractRejectMapper;
import com.ancaiyun.bid.mapper.SupplierMaterialMapper;
import com.ancaiyun.bid.service.ContractRejectService;
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
 * <p>Title:ContractRejectServiceImpl</p>
 * <p>Description: 发货单service实现</p>
 *
 * @author zhangzhanyang
 * @date 2018/5/30 9:35
 */
@Transactional
@Service
public class ContractRejectServiceImpl implements ContractRejectService {

    @Autowired
    private ContractRejectMapper contractRejectMapper;


    @Autowired
    private SupplierMaterialMapper supplierMaterialMapper;

    /*
     * @Description 查询全部发货单
     * @Date 10:01 2018/5/30
     * @Param
     * @return
     **/

    @Override
    public Result getAll(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            //查询全部发货单
            PageHelperNew.startPage(pageNum,pageSize);
            List<ModelMap> modelMaps = contractRejectMapper.getAll(params);
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
     * @Description查看发货单详情
     * @Date 10:00 2018/5/30
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
                //查询发货单详情
                ModelMap modelMap = contractRejectMapper.getDetail(id);

                //查看发货物资
                List<ModelMap> materialMap=supplierMaterialMapper.getByRejecttId(id);

                map.addAttribute("reject",modelMap);
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
    * @Description 删除发货单
    * @Date 10:28 2018/6/2
    * @Param 
    * @return 
    **/
    
    @Override
    public Result delete(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {

            if (StringUtils.isNotBlank(id)) {
                //删除发货单
                Boolean flag = contractRejectMapper.delete(id);
                if(flag) {
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
