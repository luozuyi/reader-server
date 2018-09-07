package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductPropertyDetail implements Serializable {

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
     * 详情值
     */
    private String value;

    /**
     * 属性id
     */
    private String productPropertyId;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProductPropertyId() {
        return productPropertyId;
    }

    public void setProductPropertyId(String productPropertyId) {
        this.productPropertyId = productPropertyId;
    }
}
