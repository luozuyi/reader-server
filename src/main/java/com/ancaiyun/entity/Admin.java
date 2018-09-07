package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{

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
     * 管理员登陆名
     */
    private String adminName;
    /**
     * 管理员密码
     */
    private String adminPassword;
    /**
     * 管理员真实姓名
     */
    private String adminRealName;
    /**
     * 管理员状态：1禁用0或者空正常
     */
    private String adminStatus;

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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminRealName() {
        return adminRealName;
    }

    public void setAdminRealName(String adminRealName) {
        this.adminRealName = adminRealName == null ? null : adminRealName.trim();
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus == null ? null : adminStatus.trim();
    }
}