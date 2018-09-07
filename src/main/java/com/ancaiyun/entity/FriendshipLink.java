package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class FriendshipLink implements Serializable{
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
     * 优先级别
     */
    private Integer priorityLevel;
    /**
     * 网址
     */
    private String friendshipAddress;
    /**
     * 电话
     */
    private String friendshipMobile;
    /**
     * 联系qq
     */
    private String contactQq;
    /**
     * 名称
     */
    private String name;
    /**
     * 详情
     */
    private String status;
    /**
     * 审核状态0：出始状态1：审核通过2：审核不通过
     */
    private String isHidden;
    /**
     * 是否隐藏1：不隐藏2：隐藏
     */
    private String info;

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

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getFriendshipAddress() {
        return friendshipAddress;
    }

    public void setFriendshipAddress(String friendshipAddress) {
        this.friendshipAddress = friendshipAddress == null ? null : friendshipAddress.trim();
    }

    public String getFriendshipMobile() {
        return friendshipMobile;
    }

    public void setFriendshipMobile(String friendshipMobile) {
        this.friendshipMobile = friendshipMobile == null ? null : friendshipMobile.trim();
    }

    public String getContactQq() {
        return contactQq;
    }

    public void setContactQq(String contactQq) {
        this.contactQq = contactQq == null ? null : contactQq.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden == null ? null : isHidden.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}