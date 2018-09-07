package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 对账单类
* @Date 9:52 2018/5/29
* @Param 
* @return 
**/

public class StatementsAccount  {

	/**
	 * 
	 */
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


	private String createStatus; // 对账单审批状态   0:对账单生成审批  1:对账单支付审批   2:已开票完成
	private String contractId; // 合同
	private String serialNumber;// 对账单编号
	private String status; // 结算状态 0:采购商对账 1:供应商对账 2:待开票  3:待支付 4:已完成   5:被驳回
	private String reason; // 驳回原因
	private BigDecimal totalPrice; // 物资总价
	private BigDecimal occupancyTotalPrice; // 含资金占用费总价
	private BigDecimal residueMoney; // 剩余开票金额
	private String buyerId; //   采购商memberId
	private String sellerId;// 供应商商memberId
	private String username; // 当前执行对象
	private String proceessId; // 流程实例ID
	private String tackStatus; // 流程执行状态   0:审批中    1:被驳回    2:被供应商驳回
	
	private String isOccupancy;    //是否包含资金占用费  0:不包含  1:包含
	private String remarks;    //备注
	
	private BigDecimal basicRate;  //基础利率
	private BigDecimal floatRate;  //上浮利率
	private BigDecimal rate;   //利率
	
	private String paymentsDays;   //账期

	private Date enteringTime;    //录入时间
	private BigDecimal checkAmount; //校对金额


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

	public String getCreateStatus() {
		return createStatus;
	}

	public void setCreateStatus(String createStatus) {
		this.createStatus = createStatus;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getOccupancyTotalPrice() {
		return occupancyTotalPrice;
	}

	public void setOccupancyTotalPrice(BigDecimal occupancyTotalPrice) {
		this.occupancyTotalPrice = occupancyTotalPrice;
	}

	public BigDecimal getResidueMoney() {
		return residueMoney;
	}

	public void setResidueMoney(BigDecimal residueMoney) {
		this.residueMoney = residueMoney;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProceessId() {
		return proceessId;
	}

	public void setProceessId(String proceessId) {
		this.proceessId = proceessId;
	}

	public String getTackStatus() {
		return tackStatus;
	}

	public void setTackStatus(String tackStatus) {
		this.tackStatus = tackStatus;
	}

	public String getIsOccupancy() {
		return isOccupancy;
	}

	public void setIsOccupancy(String isOccupancy) {
		this.isOccupancy = isOccupancy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getBasicRate() {
		return basicRate;
	}

	public void setBasicRate(BigDecimal basicRate) {
		this.basicRate = basicRate;
	}

	public BigDecimal getFloatRate() {
		return floatRate;
	}

	public void setFloatRate(BigDecimal floatRate) {
		this.floatRate = floatRate;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getPaymentsDays() {
		return paymentsDays;
	}

	public void setPaymentsDays(String paymentsDays) {
		this.paymentsDays = paymentsDays;
	}

	public Date getEnteringTime() {
		return enteringTime;
	}

	public void setEnteringTime(Date enteringTime) {
		this.enteringTime = enteringTime;
	}

	public BigDecimal getCheckAmount() {
		return checkAmount;
	}

	public void setCheckAmount(BigDecimal checkAmount) {
		this.checkAmount = checkAmount;
	}
}
