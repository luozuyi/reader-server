package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductSubCategory implements Serializable {

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
     * 类型名称
     */
    private String pcName;

    /**
     * 类名等级
     */
    private Boolean pcLevel;

    /**
     * 排序
     */
    private Integer pcSequence;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 商品大类id
     */
    private String productCategoryId;

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

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public Boolean getPcLevel() {
        return pcLevel;
    }

    public void setPcLevel(Boolean pcLevel) {
        this.pcLevel = pcLevel;
    }

    public Integer getPcSequence() {
        return pcSequence;
    }

    public void setPcSequence(Integer pcSequence) {
        this.pcSequence = pcSequence;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
