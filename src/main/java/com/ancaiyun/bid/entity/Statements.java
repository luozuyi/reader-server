package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 结算单类
* @Date 10:02 2018/5/29
* @Param 
* @return 
**/

public class Statements {

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


	private String contractOrderId;  //合同订单编号
	private String type;  //结算单状态  0:竞价结算  1:招标结算

	private String createStatus;   //重新生成结算单状态  0:已重新生成
	private String contract;   //合同
	private String serialNumber;//结算单编号
	private String status;      //结算状态   0:结算中   1:待支付   2:已驳回  3:已完成   4:审核中  
	private String reason;     //驳回原因
	private String checkReason;     //审核不通过理由
	private BigDecimal totalPrice;    //物资总价
	private BigDecimal residueMoney;    //剩余开票金额
	private String subBuyUsername;//采购商子账户用户名
	private String subSellerUsername;//供应商子账户用户名
	private String userId;      //当前执行对象
	private String proceessId;  //流程实例ID
	private String tackStatus;  //流程执行状态
	private String isExamine;   //是否开启审批流: 1:开启
	private String isPay;   //是否支付  0:未支付  1:已支付
	
	private String payType;
	
	private Date startTime; //开始时间
	private Date endTime; //截至时间 
	private String title; //结算单标题
	private String priceUppercase; //结算金额(大写)
	
	private String year; //年
	private String month; //月
	private String material; //手动填写物资类型
	
	private BigDecimal numTotal; //物资总数量

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

	public String getContractOrderId() {
		return contractOrderId;
	}

	public void setContractOrderId(String contractOrderId) {
		this.contractOrderId = contractOrderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreateStatus() {
		return createStatus;
	}

	public void setCreateStatus(String createStatus) {
		this.createStatus = createStatus;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
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

	public String getCheckReason() {
		return checkReason;
	}

	public void setCheckReason(String checkReason) {
		this.checkReason = checkReason;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getResidueMoney() {
		return residueMoney;
	}

	public void setResidueMoney(BigDecimal residueMoney) {
		this.residueMoney = residueMoney;
	}

	public String getSubBuyUsername() {
		return subBuyUsername;
	}

	public void setSubBuyUsername(String subBuyUsername) {
		this.subBuyUsername = subBuyUsername;
	}

	public String getSubSellerUsername() {
		return subSellerUsername;
	}

	public void setSubSellerUsername(String subSellerUsername) {
		this.subSellerUsername = subSellerUsername;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getIsExamine() {
		return isExamine;
	}

	public void setIsExamine(String isExamine) {
		this.isExamine = isExamine;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriceUppercase() {
		return priceUppercase;
	}

	public void setPriceUppercase(String priceUppercase) {
		this.priceUppercase = priceUppercase;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public BigDecimal getNumTotal() {
		return numTotal;
	}

	public void setNumTotal(BigDecimal numTotal) {
		this.numTotal = numTotal;
	}
}
