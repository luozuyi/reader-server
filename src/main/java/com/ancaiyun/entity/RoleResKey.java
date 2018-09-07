package com.ancaiyun.entity;

import java.io.Serializable;

public class RoleResKey implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 资源id
     */
    private String resId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }
}