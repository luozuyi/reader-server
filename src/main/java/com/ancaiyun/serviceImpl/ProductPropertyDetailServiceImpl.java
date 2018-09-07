package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.ProductProperty;
import com.ancaiyun.entity.ProductPropertyDetail;
import com.ancaiyun.mapper.ProductPropertyDetailMapper;
import com.ancaiyun.mapper.ProductPropertyMapper;
import com.ancaiyun.service.ProductPropertyDetailService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ProductPropertyDetailServiceImpl implements ProductPropertyDetailService {

    @Autowired
    private ProductPropertyDetailMapper productPropertyDetailMapper;

    @Autowired
    private ProductPropertyMapper productPropertyMapper;

    @Override
    public Result getPageListByProductPropertyId(Integer pageNum, Integer pageSize, String productPropertyId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ProductPropertyDetail> productPropertyDetailList = productPropertyDetailMapper.getListByProductPropertyId(productPropertyId);
            PageInfo<ProductPropertyDetail> page = new PageInfo<>(productPropertyDetailList);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result addProductPropertyDetail(String value, String productPropertyId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            ProductProperty productProperty = productPropertyMapper.getById(productPropertyId);
            if (productProperty == null){
                code = "-3";
                msg = "请先选中属性";
            }else {
                ProductPropertyDetail productPropertyDetail = new ProductPropertyDetail();
                productPropertyDetail.setId(UUID.randomUUID().toString().replace("-", ""));
                productPropertyDetail.setCreateTime(new Date());
                productPropertyDetail.setDelFlag("0");
                productPropertyDetail.setValue(value);
                productPropertyDetail.setProductPropertyId(productPropertyId);
                productPropertyDetailMapper.insert(productPropertyDetail);
                code = Constants.SUCCESS;
                msg = "成功";
            }
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result deleteById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            ProductPropertyDetail productPropertyDetail = productPropertyDetailMapper.getById(id);
            if (productPropertyDetail == null){
                msg = "该属性不存在";
            } else {
                productPropertyDetail.setDelFlag("1");
                productPropertyDetail.setProductPropertyId(null);
                productPropertyDetailMapper.update(productPropertyDetail);
                code = Constants.SUCCESS;
                msg = "成功";
            }
        } catch (Exception e){
            code = Constants.ERROR;
            msg = "后台出错";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
