package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.ProductCategory;
import com.ancaiyun.entity.ProductSubCategory;
import com.ancaiyun.mapper.ProductCategoryMapper;
import com.ancaiyun.mapper.ProductSubCategoryMapper;
import com.ancaiyun.service.ProductCategoryService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductSubCategoryMapper productSubCategoryMapper;

    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ProductCategory> productCategoryList = productCategoryMapper.getList();
            PageInfo<ProductCategory> page = new PageInfo<>(productCategoryList);
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
    public Result addproductCategory(ProductCategory productCategory) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            if (StringUtils.isBlank(productCategory.getTypeName())){
                code = "-3";
                msg = "类型名称不能为空";
            } else if (null == productCategory.getTypeSequence()){
                code = "-3";
                msg = "排序不能为空";
            } else {
                int sortNum = productCategoryMapper.getCount();
                sortNum += 1;
                productCategory.setId(UUID.randomUUID().toString().replace("-", ""));
                productCategory.setCreateTime(new Date());
                productCategory.setDelFlag("0");
                productCategory.setSortNum(sortNum);
                productCategoryMapper.insert(productCategory);
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
            ProductCategory productCategory = productCategoryMapper.getById(id);
            if (productCategory != null) {
                List<ProductSubCategory> productSubCategoryList = productSubCategoryMapper.getListByProductCategoryId(productCategory.getId());
                if (productSubCategoryList.isEmpty()){
                    productCategory.setDelFlag("1");
                    productCategoryMapper.updateById(productCategory);
                    code = Constants.SUCCESS;
                    msg = "成功";
                } else {
                    msg = "请先删除子类";
                }
            } else {
                msg = "该商品类型为空";
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
    public Result updateProductCategoryById(String id, String typeName) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            ProductCategory productCategory = productCategoryMapper.getById(id);
            if (productCategory != null) {
                productCategory.setTypeName(typeName);
                productCategoryMapper.updateById(productCategory);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                msg = "该商品类型为空";
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
