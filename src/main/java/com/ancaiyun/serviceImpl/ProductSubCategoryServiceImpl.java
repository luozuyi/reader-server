package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.ProductCategory;
import com.ancaiyun.entity.ProductProperty;
import com.ancaiyun.entity.ProductSubCategory;
import com.ancaiyun.mapper.ProductCategoryMapper;
import com.ancaiyun.mapper.ProductPropertyMapper;
import com.ancaiyun.mapper.ProductSubCategoryMapper;
import com.ancaiyun.service.ProductSubCategoryService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

    @Autowired
    private ProductSubCategoryMapper productSubCategoryMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductPropertyMapper productPropertyMapper;

    @Override
    public Result getListByProductCategoryId(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            List<ProductSubCategory> productSubCategoryList = productSubCategoryMapper.getListByProductCategoryId(id);
            result.setData(productSubCategoryList);
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
    public Result addproductSubCategory(ProductSubCategory productSubCategory, String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            ProductCategory productCategory = productCategoryMapper.getById(id);
            if (null != productCategory){
            if (StringUtils.isBlank(productSubCategory.getPcName())){
                code = "-3";
                msg = "类型名称不能为空";
            } else if (null == productSubCategory.getPcSequence()){
                code = "-3";
                msg = "排序不能为空";
            } else {
                productSubCategory.setId(UUID.randomUUID().toString().replace("-", ""));
                productSubCategory.setCreateTime(new Date());
                productSubCategory.setDelFlag("0");
                productSubCategory.setProductCategoryId(id);
                productSubCategoryMapper.insert(productSubCategory);
                code = Constants.SUCCESS;
                msg = "成功";
            }
            } else {
                msg = "请先选中大类";
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
    public Result getThreeCategoryList(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            if (id == null){
                msg = "请先选择二类";
            } else {
                List<ProductSubCategory> productSubCategoryList = productSubCategoryMapper.getListByParentId(id);
                result.setData(productSubCategoryList);
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
    public Result addThreeCategory(ProductSubCategory productSubCategory, String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            ProductSubCategory twoCategory = productSubCategoryMapper.getById(id);
            if (null != twoCategory){
                productSubCategory.setId(UUID.randomUUID().toString().replace("-", ""));
                productSubCategory.setCreateTime(new Date());
                productSubCategory.setDelFlag("0");
                productSubCategory.setParentId(id);
                productSubCategoryMapper.insert(productSubCategory);

                Integer sortNum = productCategoryMapper.getById(twoCategory.getProductCategoryId()).getSortNum();
                ProductProperty productProperty1 = new ProductProperty();//添加3类默认添加两个属性单位和计量单位
                productProperty1.setId(UUID.randomUUID().toString().replace("-", ""));
                productProperty1.setCreateTime(new Date());
                productProperty1.setDelFlag("0");
                productProperty1.setPropertyName("单位");
                productProperty1.setProductSubCategoryId(productSubCategory.getId());
                productProperty1.setProductNum(sortNum);
                productPropertyMapper.insert(productProperty1);

                ProductProperty productProperty2 = new ProductProperty();//添加3类默认添加两个属性单位和计量单位
                productProperty2.setId(UUID.randomUUID().toString().replace("-", ""));
                productProperty2.setCreateTime(new Date());
                productProperty2.setDelFlag("0");
                productProperty2.setPropertyName("计量单位");
                productProperty2.setProductSubCategoryId(productSubCategory.getId());
                productProperty2.setProductNum(sortNum);
                productPropertyMapper.insert(productProperty2);

                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                msg = "请先选中二类";
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
            ProductSubCategory productSubCategory = productSubCategoryMapper.getById(id);
            if (null != productSubCategory){
                if (productSubCategory.getParentId() == null){
                    List<ProductSubCategory> ProductSubCategoryList = productSubCategoryMapper.getListByParentId(id);
                    if (ProductSubCategoryList.isEmpty()){
                        productSubCategory.setDelFlag("1");
                        productSubCategoryMapper.update(productSubCategory);
                        code = Constants.SUCCESS;
                        msg = "成功";
                    } else {
                        msg = "请先删除二类";
                    }
                } else if (productSubCategory.getParentId() != null){
                    Map<String, String> params = new HashMap<>();
                    params.put("productSubCategoryId",id);
                    List<ProductProperty> productPropertyList = productPropertyMapper.getListByProductSubCategoryIdAndPropertyName(params);
                    if (productPropertyList.isEmpty()){
                        productSubCategory.setDelFlag("1");
                        productSubCategoryMapper.update(productSubCategory);
                        code = Constants.SUCCESS;
                        msg = "成功";
                    } else {
                        msg = "请先删除属性";
                    }

                }
            } else {
                msg = "该记录不存在";
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
    public Result updateProductSubCategoryById(String id, String pcName) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "失败";
        try {
            ProductSubCategory productSubCategory = productSubCategoryMapper.getById(id);
            if (productSubCategory != null) {
                productSubCategory.setPcName(pcName);
                productSubCategoryMapper.update(productSubCategory);
                code = Constants.SUCCESS;
                msg = "成功";
            } else {
                msg = "该记录不存在";
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
