package com.ancaiyun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Withdraw implements Serializable {

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
     * 用户名
     */
    private String userName;

    /**
     * 提现金额
     */
    private BigDecimal withdrawMoney;

    /**
     * 到账金额
     */
    private BigDecimal arrivalMoney;

    /**
     * 提现手续费
     */
    private BigDecimal serviceCharge;

    /**
     * 提现状态 -1 失败 0：成功 1：处理中 2：请求中
     */
    private String status;

    /**
     * 提现备注
     */
    private String note;

    /**
     * 审核人
     */
    private String approveMan;

    /**
     * 审核时间
     */
    private Date approveTime;

    /**
     * 银行卡号
     */
    private String bankCardCode;

    /**
     * 银行名称
     */
    private String bankName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(BigDecimal withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public BigDecimal getArrivalMoney() {
        return arrivalMoney;
    }

    public void setArrivalMoney(BigDecimal arrivalMoney) {
        this.arrivalMoney = arrivalMoney;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getApproveMan() {
        return approveMan;
    }

    public void setApproveMan(String approveMan) {
        this.approveMan = approveMan;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getBankCardCode() {
        return bankCardCode;
    }

    public void setBankCardCode(String bankCardCode) {
        this.bankCardCode = bankCardCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubUsername() {
        return subUsername;
    }

    public void setSubUsername(String subUsername) {
        this.subUsername = subUsername;
    }
}
