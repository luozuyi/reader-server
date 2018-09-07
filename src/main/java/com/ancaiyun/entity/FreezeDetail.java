package com.ancaiyun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FreezeDetail implements Serializable {

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
     * 冻结金额
     */
    private BigDecimal freezeMoney;

    /**
     * 冻结类型 0:提现2：商城订单3：自营订单
     */
    private String freezeType;

    /**
     * 冻结状态： 0 冻结中 1 已解冻
     */
    private String status;

    /**
     * 审核人
     */
    private String approveMan;

    /**
     * 审核时间
     */
    private Date approveTime;

    /**
     * 相关id
     */
    private String relationId;

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

    public BigDecimal getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(BigDecimal freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public String getFreezeType() {
        return freezeType;
    }

    public void setFreezeType(String freezeType) {
        this.freezeType = freezeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
}
