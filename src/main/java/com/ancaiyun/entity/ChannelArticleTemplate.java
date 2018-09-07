package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class ChannelArticleTemplate implements Serializable{
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
     * 删除标志位；0：正常 1：删除 2：待删除
     */
    private String delFlag;
    /**
     * 模板路径
     */
    private String tplUrl;
    /**
     * 模板类型 0：文章模板 1：栏目模板
     */
    private String type;

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

    public String getTplUrl() {
        return tplUrl;
    }

    public void setTplUrl(String tplUrl) {
        this.tplUrl = tplUrl == null ? null : tplUrl.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}