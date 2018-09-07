package com.ancaiyun.entity;

import java.io.Serializable;

public class UserRoleKey implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}