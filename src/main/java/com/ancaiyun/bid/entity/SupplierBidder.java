package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SupplierBidder {

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


	private String supplierId; //供应商ID
	private String bidId; //招标信息ID
	private String purchaserId; //采购商ID
	private String bidderStatus; //供应商投标状态：-1：被邀请  0：报名 1：投标 2：中标 3：未中标 4：签收招标
	private String invoiceType; //提供发票类型：0：无发票 1：增值税专用发票 2：增值税普通发票
	private String taxRate; //税率
	private BigDecimal bidderTotalPrice;//投标总价(大)
	private String isIncludeShippingCharges; //报价是否包含运费：0：是 1：否
	private String isIncludeTaxCharges; //报价是否包含税费及其他费用（除运费）：0：是 1：否
	private String note; //备注说明
	private BigDecimal actualQuotation;//实际报价
	private BigDecimal payTheDepositAmount;//缴纳保证金金额

	private String appendixToTender;//投标附件
	private Date winBiddingDate;//中标日期
	private String buySubUsername;//买家子账户
	private String sellerSubUsername;//卖家子账户
	private String isPassExamine;//是否通过审批 0:是   1：否(或正在通过)
	private String winningReason;//中标理由
	private String taxCharges;//其他费用
	private String freightDescription;//运费详细
	private String preChoseStatus;//预选中状态 0:预选中 1:未选中

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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getBidderStatus() {
		return bidderStatus;
	}

	public void setBidderStatus(String bidderStatus) {
		this.bidderStatus = bidderStatus;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getBidderTotalPrice() {
		return bidderTotalPrice;
	}

	public void setBidderTotalPrice(BigDecimal bidderTotalPrice) {
		this.bidderTotalPrice = bidderTotalPrice;
	}

	public String getIsIncludeShippingCharges() {
		return isIncludeShippingCharges;
	}

	public void setIsIncludeShippingCharges(String isIncludeShippingCharges) {
		this.isIncludeShippingCharges = isIncludeShippingCharges;
	}

	public String getIsIncludeTaxCharges() {
		return isIncludeTaxCharges;
	}

	public void setIsIncludeTaxCharges(String isIncludeTaxCharges) {
		this.isIncludeTaxCharges = isIncludeTaxCharges;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getActualQuotation() {
		return actualQuotation;
	}

	public void setActualQuotation(BigDecimal actualQuotation) {
		this.actualQuotation = actualQuotation;
	}

	public BigDecimal getPayTheDepositAmount() {
		return payTheDepositAmount;
	}

	public void setPayTheDepositAmount(BigDecimal payTheDepositAmount) {
		this.payTheDepositAmount = payTheDepositAmount;
	}

	public String getAppendixToTender() {
		return appendixToTender;
	}

	public void setAppendixToTender(String appendixToTender) {
		this.appendixToTender = appendixToTender;
	}

	public Date getWinBiddingDate() {
		return winBiddingDate;
	}

	public void setWinBiddingDate(Date winBiddingDate) {
		this.winBiddingDate = winBiddingDate;
	}

	public String getBuySubUsername() {
		return buySubUsername;
	}

	public void setBuySubUsername(String buySubUsername) {
		this.buySubUsername = buySubUsername;
	}

	public String getSellerSubUsername() {
		return sellerSubUsername;
	}

	public void setSellerSubUsername(String sellerSubUsername) {
		this.sellerSubUsername = sellerSubUsername;
	}

	public String getIsPassExamine() {
		return isPassExamine;
	}

	public void setIsPassExamine(String isPassExamine) {
		this.isPassExamine = isPassExamine;
	}

	public String getWinningReason() {
		return winningReason;
	}

	public void setWinningReason(String winningReason) {
		this.winningReason = winningReason;
	}

	public String getTaxCharges() {
		return taxCharges;
	}

	public void setTaxCharges(String taxCharges) {
		this.taxCharges = taxCharges;
	}

	public String getFreightDescription() {
		return freightDescription;
	}

	public void setFreightDescription(String freightDescription) {
		this.freightDescription = freightDescription;
	}

	public String getPreChoseStatus() {
		return preChoseStatus;
	}

	public void setPreChoseStatus(String preChoseStatus) {
		this.preChoseStatus = preChoseStatus;
	}
}
