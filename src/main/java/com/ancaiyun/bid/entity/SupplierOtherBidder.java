package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;

/*
* @Description 报价类
* @Date 10:04 2018/5/29
* @Param 
* @return 
**/

public class SupplierOtherBidder {
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


	private String supplierId;//供应商ID
	private String otherBidId;//竞价信息ID
	private String purchaserId;//采购商ID
	private String otherBidderStatus;//供应商竞价状态：0：报价中 1：已中标 2：未中标 

	private String invoiceType;//提供发票类型：0：增值税专用发票 1：增值税普通发票  2:无发票
	private String taxRate;//税率
	private BigDecimal bidderTotalPrice;//报价总价
	private BigDecimal taxFreeTotal;    //不含税总价
	private String otherExpenses;      //其他费用说明
	private String freightDescription;      //运费说明
	private BigDecimal totalTax;     //总税额
	
	private String isIncludeShippingCharges;//报价是否包含运费：0：是 1：否
	private String isIncludeTaxCharges;//报价是否包含税费及其他费用（除运费） ：0：是 1：否
	private String note;//报价说明
	private String assessoryId;   //上传附件
	
	private String contactPerson;    //联系人姓名
	private String contactNumber;    //联系人电话
	
	private String subUsername;//子账户用户名
	
	private String predefineStatus;    //预选中状态  0:预选中 1:未选中


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

	public String getOtherBidId() {
		return otherBidId;
	}

	public void setOtherBidId(String otherBidId) {
		this.otherBidId = otherBidId;
	}

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getOtherBidderStatus() {
		return otherBidderStatus;
	}

	public void setOtherBidderStatus(String otherBidderStatus) {
		this.otherBidderStatus = otherBidderStatus;
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

	public BigDecimal getTaxFreeTotal() {
		return taxFreeTotal;
	}

	public void setTaxFreeTotal(BigDecimal taxFreeTotal) {
		this.taxFreeTotal = taxFreeTotal;
	}

	public String getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(String otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public String getFreightDescription() {
		return freightDescription;
	}

	public void setFreightDescription(String freightDescription) {
		this.freightDescription = freightDescription;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
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

	public String getAssessoryId() {
		return assessoryId;
	}

	public void setAssessoryId(String assessoryId) {
		this.assessoryId = assessoryId;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getSubUsername() {
		return subUsername;
	}

	public void setSubUsername(String subUsername) {
		this.subUsername = subUsername;
	}

	public String getPredefineStatus() {
		return predefineStatus;
	}

	public void setPredefineStatus(String predefineStatus) {
		this.predefineStatus = predefineStatus;
	}
}
