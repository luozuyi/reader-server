package com.ancaiyun.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OfflineRemittance {

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
     * 汇款人姓名
     */
    private String remittanceName;

    /**
     * 汇款人账号
     */
    private String remittanceAccount;

    /**
     * 收款账户
     */
    private String beneficiaryAccount;

    /**
     * 汇款银行
     */
    private String remittanceBank;

    /**
     * 汇款金额
     */
    private BigDecimal remittanceMoney;

    /**
     * 汇款时间
     */
    private Date remittanceTime;

    /**
     * 汇款凭证图片
     */
    private String remittanceImgId;

    /**
     * 汇款说明
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
     * 汇款状态-1失败 0成功  1处理中
     */
    private String status;

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

    public String getRemittanceName() {
        return remittanceName;
    }

    public void setRemittanceName(String remittanceName) {
        this.remittanceName = remittanceName;
    }

    public String getRemittanceAccount() {
        return remittanceAccount;
    }

    public void setRemittanceAccount(String remittanceAccount) {
        this.remittanceAccount = remittanceAccount;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public String getRemittanceBank() {
        return remittanceBank;
    }

    public void setRemittanceBank(String remittanceBank) {
        this.remittanceBank = remittanceBank;
    }

    public BigDecimal getRemittanceMoney() {
        return remittanceMoney;
    }

    public void setRemittanceMoney(BigDecimal remittanceMoney) {
        this.remittanceMoney = remittanceMoney;
    }

    public Date getRemittanceTime() {
        return remittanceTime;
    }

    public void setRemittanceTime(Date remittanceTime) {
        this.remittanceTime = remittanceTime;
    }

    public String getRemittanceImgId() {
        return remittanceImgId;
    }

    public void setRemittanceImgId(String remittanceImgId) {
        this.remittanceImgId = remittanceImgId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubUsername() {
        return subUsername;
    }

    public void setSubUsername(String subUsername) {
        this.subUsername = subUsername;
    }
}
