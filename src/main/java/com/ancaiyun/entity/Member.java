package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 会员积分
     */
    private Integer memberBonusPoints;
    /**
     * 登陆次数
     */
    private Integer loginCount;
    /**
     * 座机
     */
    private String landlineTelephone;
    /**
     * 省市区地址
     */
    private String provinceCityCountry;
    /**
     * 具体地址
     */
    private String address;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 会员信用值
     */
    private Integer memberCredit;
    /**
     * 会员头像
     */
    private String photoId;
    /**
     * 店铺ID
     */
    private String storeId;
    /**
     * qq
     */
    private String qq;
    /**
     * user_id
     */
    private String userId;
    /**
     * 资料审核状态： 0：审核中 1：审核通过 2：审核失败
     */
    private String extraDataStatus;
    /**
     * 资料审核ID
     */
    private String extraDataId;
    /**
     * 会员帐号状态: 0:正常 1：异常 2：禁止登录
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 删除标志位 0:正常 1：删除 2：待删除
     */
    private String delFlag;
    /**
     * 可用余额
     */
    private Double money;
    /**
     * 冻结资金
     */
    private Double freezeMoney;
    /**
     * 支付密码
     */
    private String payPassword;
    /**
     * 招投标保证金
     */
    private Double bidSecurityMoney;
    /**
     * 1:我是供应商2：我是采购商3：两者都是
     */
    private String tradeStatus;
    /**
     * 子账户名
     */
    private String subUsername;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getMemberBonusPoints() {
        return memberBonusPoints;
    }

    public void setMemberBonusPoints(Integer memberBonusPoints) {
        this.memberBonusPoints = memberBonusPoints;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getLandlineTelephone() {
        return landlineTelephone;
    }

    public void setLandlineTelephone(String landlineTelephone) {
        this.landlineTelephone = landlineTelephone == null ? null : landlineTelephone.trim();
    }

    public String getProvinceCityCountry() {
        return provinceCityCountry;
    }

    public void setProvinceCityCountry(String provinceCityCountry) {
        this.provinceCityCountry = provinceCityCountry == null ? null : provinceCityCountry.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getMemberCredit() {
        return memberCredit;
    }

    public void setMemberCredit(Integer memberCredit) {
        this.memberCredit = memberCredit;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getExtraDataStatus() {
        return extraDataStatus;
    }

    public void setExtraDataStatus(String extraDataStatus) {
        this.extraDataStatus = extraDataStatus == null ? null : extraDataStatus.trim();
    }

    public String getExtraDataId() {
        return extraDataId;
    }

    public void setExtraDataId(String extraDataId) {
        this.extraDataId = extraDataId == null ? null : extraDataId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(Double freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public Double getBidSecurityMoney() {
        return bidSecurityMoney;
    }

    public void setBidSecurityMoney(Double bidSecurityMoney) {
        this.bidSecurityMoney = bidSecurityMoney;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public String getSubUsername() {
        return subUsername;
    }

    public void setSubUsername(String subUsername) {
        this.subUsername = subUsername == null ? null : subUsername.trim();
    }
}