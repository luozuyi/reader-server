package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class ChildAccount implements Serializable{
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
     * 删除状态
     */
    private String delFlag;
    /**
     * 当前子账户关联的用户id
     */
    private String childId;
    /**
     * 父账户id
     */
    private String parentId;
    /**
     * 所属机构
     */
    private String subordinateUnit;
    /**
     * 子账号电话
     */
    private String mobile;
    /**
     * 职位
     */
    private String position;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * qq
     */
    private String qq;
    /**
     * 所属机构id
     */
    private String organizationId;
    /**
     * 子用户名
     */
    private String subUsername;
    /**
     * 角色名称
     */
    private String roleName;

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

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId == null ? null : childId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getSubordinateUnit() {
        return subordinateUnit;
    }

    public void setSubordinateUnit(String subordinateUnit) {
        this.subordinateUnit = subordinateUnit == null ? null : subordinateUnit.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    public String getSubUsername() {
        return subUsername;
    }

    public void setSubUsername(String subUsername) {
        this.subUsername = subUsername == null ? null : subUsername.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}