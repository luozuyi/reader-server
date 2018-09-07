package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Res implements Serializable{
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
     * 删除标志位 0:正常 1:删除 2:待删除
     */
    private String delFlag;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源请求url
     */
    private String url;
    /**
     * 资源名称对应的值
     */
    private String value;
    /**
     * 资源类型： 0：菜单 1：目录 2：按钮，子按钮
     */
    private String type;
    /**
     * 资源所属模块：Admin Buyer Seller
     */
    private String resModuleType;
    /**
     * 排序
     */
    private Integer sequence;
    /**
     * 父类ID
     */
    private String parentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getResModuleType() {
        return resModuleType;
    }

    public void setResModuleType(String resModuleType) {
        this.resModuleType = resModuleType == null ? null : resModuleType.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}