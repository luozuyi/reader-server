package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限中间表
 */
public class AdminRolePermisssion implements Serializable{
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
     * 权限关联id
     */
    private String adminPermisssionId;
    /**
     * 角色关联id
     *
     */
    private String adminRoleId;

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

    public String getAdminPermisssionId() {
        return adminPermisssionId;
    }

    public void setAdminPermisssionId(String adminPermisssionId) {
        this.adminPermisssionId = adminPermisssionId == null ? null : adminPermisssionId.trim();
    }

    public String getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(String adminRoleId) {
        this.adminRoleId = adminRoleId == null ? null : adminRoleId.trim();
    }
}