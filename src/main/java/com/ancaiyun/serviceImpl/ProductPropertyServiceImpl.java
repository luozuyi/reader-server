package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.ProductProperty;
import com.ancaiyun.entity.ProductPropertyDetail;
import com.ancaiyun.entity.ProductSubCategory;
import com.ancaiyun.mapper.ProductCategoryMapper;
import com.ancaiyun.mapper.ProductPropertyDetailMapper;
import com.ancaiyun.mapper.ProductPropertyMapper;
import com.ancaiyun.mapper.ProductSubCategoryMapper;
import com.ancaiyun.service.ProductPropertyService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Autowired
    private ProductPropertyMapper productPropertyMapper;

    @Autowired
    private ProductSubCategoryMapper productSubCategoryMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductPropertyDetailMapper productPropertyDetailMapper;

    @Override
    public Result getPageListByProductSubCategoryId(Integer pageNum, Integer pageSize, Map<String, String> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ProductProperty> productPropertyList = productPropertyMapper.getListByProductSubCategoryIdAndPropertyName(params);
            PageInfo<ProductProperty> pageInfo = new PageInfo<>(productPropertyList);
            result.setData(pageInfo);
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
    public Result addProductProperty(Map<String, String> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            String productSubCategoryId = params.get("productSubCategoryId");
            String propertyName = params.get("propertyName");
            ProductSubCategory productSubCategory = productSubCategoryMapper.getById(productSubCategoryId);
            if (productSubCategory == null){
                code = "3";
                msg = "请先选中3类";
            } else if (propertyName == null){
                code = "4";
                msg = "属性值不能为空";
            } else {
                ProductProperty selectProductProperty = productPropertyMapper.getByPropertyNameAndProductSubCategoryId(params);
                if (selectProductProperty != null){
                    code = "5";
                    msg = "该属性值已经设置";
                } else {
                    String productCategoryId = productSubCategoryMapper.getById(productSubCategory.getParentId()).getProductCategoryId();
                    Integer sortNum = productCategoryMapper.getById(productCategoryId).getSortNum();
                    ProductProperty productProperty = new ProductProperty();
                    productProperty.setId(UUID.randomUUID().toString().replace("-", ""));
                    productProperty.setCreateTime(new Date());
                    productProperty.setDelFlag("0");
                    productProperty.setPropertyName(propertyName);
                    productProperty.setProductNum(sortNum);
                    productProperty.setProductSubCategoryId(productSubCategoryId);
                    productPropertyMapper.insert(productProperty);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }

            }
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
    public Result deleteById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            ProductProperty productProperty = productPropertyMapper.getById(id);
            if (productProperty != null){
                List<ProductPropertyDetail> productPropertyDetailList = productPropertyDetailMapper.getListByProductPropertyId(id);
                if (!productPropertyDetailList.isEmpty()){
                    msg = "请先删除该属性的属性值";
                } else {
                productProperty.setDelFlag("1");
                productPropertyMapper.update(productProperty);
                code = Constants.SUCCESS;
                msg = "成功";
                }
            } else {
                msg = "该属性不存在";
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
    public Result pageList(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ProductProperty> productPropertyList = productPropertyMapper.getList();
            PageInfo<ProductProperty> pageInfo = new PageInfo<>(productPropertyList);
            result.setData(pageInfo);
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
}
