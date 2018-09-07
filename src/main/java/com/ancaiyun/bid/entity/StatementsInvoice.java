package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 发票类
* @Date 10:04 2018/5/29
* @Param 
* @return 
**/

public class StatementsInvoice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2483017925910038116L;

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


	private String statementsId;     //结算单ID
	private String status;              //发票状态  0:待确认  1:待支付  2:已驳回  3:已支付
	private String serialNumber;        //发票单编号
	private BigDecimal totalPrice;      //发票总金额    OK
	private String buyUsername;    //买家用户名
	private String sellerUsername;     //卖家用户名
	private String type;           //发票类型   0:竞价发票  1:招标发票 OK
	private String theKindsOfInvoice; //发票类型 0:增值普通发票 1:增值专用发票
	private String taxRate;           //税率 OK
	private BigDecimal taxAmount;     //税额 OK
	private BigDecimal afterTaxTotal;   //税后总额 OK
	private Date makeOutAnInvoiceDate;//开票日期 OK
	private String reason;           //驳回发票原因
	private String againInvoice;     //重新开票状态 0:已重新开票
	private String subBuyUsername;//采购商子账户用户名 OK
	private String subSellerUsername;//供应商子账户用户名 OK
	private String userId;      //当前执行对象
	private String proceessId;  //流程实例ID
	private String tackStatus;  //流程执行状态
	private String isExamine;   //是否开启审批流: 1:开启
	
	private String paymentId; //发票支付列表id
	
	
	private String invoiceFileId; //文件ID
	private String statements; // 结算单ID
	private String kindsOfInvoice;//类型类型(备用) 
	private String kinds;//类型 0:来自对账单 1:来自结算单
	private String accountId;//对账单ID


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

	public String getStatementsId() {
		return statementsId;
	}

	public void setStatementsId(String statementsId) {
		this.statementsId = statementsId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBuyUsername() {
		return buyUsername;
	}

	public void setBuyUsername(String buyUsername) {
		this.buyUsername = buyUsername;
	}

	public String getSellerUsername() {
		return sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTheKindsOfInvoice() {
		return theKindsOfInvoice;
	}

	public void setTheKindsOfInvoice(String theKindsOfInvoice) {
		this.theKindsOfInvoice = theKindsOfInvoice;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getAfterTaxTotal() {
		return afterTaxTotal;
	}

	public void setAfterTaxTotal(BigDecimal afterTaxTotal) {
		this.afterTaxTotal = afterTaxTotal;
	}

	public Date getMakeOutAnInvoiceDate() {
		return makeOutAnInvoiceDate;
	}

	public void setMakeOutAnInvoiceDate(Date makeOutAnInvoiceDate) {
		this.makeOutAnInvoiceDate = makeOutAnInvoiceDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAgainInvoice() {
		return againInvoice;
	}

	public void setAgainInvoice(String againInvoice) {
		this.againInvoice = againInvoice;
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

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getInvoiceFileId() {
		return invoiceFileId;
	}

	public void setInvoiceFileId(String invoiceFileId) {
		this.invoiceFileId = invoiceFileId;
	}

	public String getStatements() {
		return statements;
	}

	public void setStatements(String statements) {
		this.statements = statements;
	}

	public String getKindsOfInvoice() {
		return kindsOfInvoice;
	}

	public void setKindsOfInvoice(String kindsOfInvoice) {
		this.kindsOfInvoice = kindsOfInvoice;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
