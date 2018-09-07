package com.ancaiyun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class IncomeDetail implements Serializable {

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
     * 收支场景： 0：充值 1：商城订单支付2：自营订单支付3:商城订单买家确认收货4：自营订单买家确认收货  5:招投标保证金 6:提现7:提现审核失败退回
     */
    private String flunflow;

    /**
     * 资金类型  0:可用余额1：代金券2：冻结资金
     */
    private String moneyType;

    /**
     * 财务类型0:收入 1:支出
     */
    private String financeType;

    /**
     * 金额
     */
    private BigDecimal num;

    /**
     * 用户名
     */
    private String username;

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

    public String getFlunflow() {
        return flunflow;
    }

    public void setFlunflow(String flunflow) {
        this.flunflow = flunflow;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getFinanceType() {
        return financeType;
    }

    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubUsername() {
        return subUsername;
    }

    public void setSubUsername(String subUsername) {
        this.subUsername = subUsername;
    }
}
