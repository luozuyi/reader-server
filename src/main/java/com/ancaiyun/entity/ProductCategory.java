package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductCategory implements Serializable {

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
    private String typeName;

    /**
     * 排序
     */
    private Integer typeSequence;

    /**
     * 排序
     */
    private Integer sortNum;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeSequence() {
        return typeSequence;
    }

    public void setTypeSequence(Integer typeSequence) {
        this.typeSequence = typeSequence;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}
