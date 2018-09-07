package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class MemberBank implements Serializable {

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
     * 会员id
     */
    private String memberId;

    /**
     * 银行id
     */
    private String bankId;

    /**
     * 是否设为默认银行
     */
    private String isDefault;

    /**
     * 银行密码
     */
    private String bankPassword;

    /**
     * 卡号
     */
    private String cardCode;

    /**
     * 子用户名
     */
    private String subUsername;

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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getSubUsername() {
        return subUsername;
    }

    public void setSubUsername(String subUsername) {
        this.subUsername = subUsername;
    }
}
