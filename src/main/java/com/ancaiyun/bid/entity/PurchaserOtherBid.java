package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 竞价类
* @Date 14:52 2018/5/28
* @Param 
* @return 
**/

public class PurchaserOtherBid {

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

	private String  purchaserProjectId;    //项目ID
	private String purchaserId;//采购商ID
	private String projectName;//项目名称
	private String projectNum;//项目编号（输入或者系统生成）
	private String type;//报名方式：0：公开报名+邀请竞价 1：公开报名 2：邀请竞价
	private String materialCategoryId;//物资类别
	private String isOpenContactInfo;//公开联系方式：0：不公开 1：报价后公开 2：公开

	private Date bidDeadline;//报价截至日期
	private String country;//交货地点
	private String address;//交货详细地址
	private String isIncludeTax;//报价是否含税：0：是 1：否
	private String taxRate;//税率
	private BigDecimal bidderTotalPrice;  //报价的总价
	private BigDecimal estimateTotal;  //报价的总价
	private String supplierProvince;//供应商所在地区
	private String supplierBusinessModel;//经营模式：0：生产制造 1：贸易批发 2：商业服务 3：其他组织【复选框】
	private String supplierRegisteredCapital;//供应商注册资本
	private String certificateRrequirements; //证件要求: 0:工商营业执照 1:贸易批发 2:生产制造  3:产品检查报告 4:验厂报告 5:添加其他证书
	private String status;  //竞价采购状态: 0:审核中  1:竞价中 2:已截止  3:审核未通过  4:未发布
	private String note;//补充说明
	private String isPublic;   //报价方式  0:公开报价  1:非公开报价
	private String user;    //后台发布人员ID
	private Integer quotationNumber;   //报名人数
	private String accessoryId;  //附件
	private String invoiceType;    //发票类型: 0:增值税专用发票 1:增值税普通发票  2:无发票
	private String contactPerson;    //联系人姓名
	private String contactNumber;    //联系人电话
	private Date deliveryTime;        //交货日期
	private String receivingWay;     //交货方式   0:自提    1:配送
	private String freight;          //报价是否包含运费 :0包含  1:不包含
	private String isInviteSuppliers;//是否邀请供应商 0:是
	private String reason;         //审核不通过原因
	private String subUsername;//子账户用户名
	private String userId;      //当前执行对象
	private String proceessId;  //流程实例ID
	private String tackStatus;  //流程执行状态
	private String isExamine;   //是否开启审批流: 1:开启
	
	private String isContract;  //是否创建合同  0:已创建

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

	public String getPurchaserProjectId() {
		return purchaserProjectId;
	}

	public void setPurchaserProjectId(String purchaserProjectId) {
		this.purchaserProjectId = purchaserProjectId;
	}

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMaterialCategoryId() {
		return materialCategoryId;
	}

	public void setMaterialCategoryId(String materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}

	public String getIsOpenContactInfo() {
		return isOpenContactInfo;
	}

	public void setIsOpenContactInfo(String isOpenContactInfo) {
		this.isOpenContactInfo = isOpenContactInfo;
	}

	public Date getBidDeadline() {
		return bidDeadline;
	}

	public void setBidDeadline(Date bidDeadline) {
		this.bidDeadline = bidDeadline;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsIncludeTax() {
		return isIncludeTax;
	}

	public void setIsIncludeTax(String isIncludeTax) {
		this.isIncludeTax = isIncludeTax;
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

	public BigDecimal getEstimateTotal() {
		return estimateTotal;
	}

	public void setEstimateTotal(BigDecimal estimateTotal) {
		this.estimateTotal = estimateTotal;
	}

	public String getSupplierProvince() {
		return supplierProvince;
	}

	public void setSupplierProvince(String supplierProvince) {
		this.supplierProvince = supplierProvince;
	}

	public String getSupplierBusinessModel() {
		return supplierBusinessModel;
	}

	public void setSupplierBusinessModel(String supplierBusinessModel) {
		this.supplierBusinessModel = supplierBusinessModel;
	}

	public String getSupplierRegisteredCapital() {
		return supplierRegisteredCapital;
	}

	public void setSupplierRegisteredCapital(String supplierRegisteredCapital) {
		this.supplierRegisteredCapital = supplierRegisteredCapital;
	}

	public String getCertificateRrequirements() {
		return certificateRrequirements;
	}

	public void setCertificateRrequirements(String certificateRrequirements) {
		this.certificateRrequirements = certificateRrequirements;
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

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getQuotationNumber() {
		return quotationNumber;
	}

	public void setQuotationNumber(Integer quotationNumber) {
		this.quotationNumber = quotationNumber;
	}

	public String getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
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

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getReceivingWay() {
		return receivingWay;
	}

	public void setReceivingWay(String receivingWay) {
		this.receivingWay = receivingWay;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getIsInviteSuppliers() {
		return isInviteSuppliers;
	}

	public void setIsInviteSuppliers(String isInviteSuppliers) {
		this.isInviteSuppliers = isInviteSuppliers;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSubUsername() {
		return subUsername;
	}

	public void setSubUsername(String subUsername) {
		this.subUsername = subUsername;
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

	public String getIsContract() {
		return isContract;
	}

	public void setIsContract(String isContract) {
		this.isContract = isContract;
	}
}
