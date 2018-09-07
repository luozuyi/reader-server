package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductProperty  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 删除状态0：正常1：删除2：待删除
     */
    private String delFlag;

    /**
     * 属性名称
     */
    private String propertyName;

    /**
     * 分类id
     */
    private String productSubCategoryId;

    /**
     * 规范单位
     */
    private String productSpecificationUnit;

    /**
     * 排序所属大类
     */
    private Integer productNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getProductSubCategoryId() {
        return productSubCategoryId;
    }

    public void setProductSubCategoryId(String productSubCategoryId) {
        this.productSubCategoryId = productSubCategoryId;
    }

    public String getProductSpecificationUnit() {
        return productSpecificationUnit;
    }

    public void setProductSpecificationUnit(String productSpecificationUnit) {
        this.productSpecificationUnit = productSpecificationUnit;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
}
