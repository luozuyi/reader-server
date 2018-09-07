package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description 合同订单
* @Date 14:15 2018/5/28
* @Param 
* @return 
**/

public class ContractOrder {

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

	private String contract;//合同编号(待改成外键)
	private Date startTime; //起始时间
	private Date endTime;	//结束时间
	private String deliveryType;//交货方式：0：送货上门 1：物流配送 2：自提
	private String contactName;//收货人
	private String contactMobile;//收货人电话
	private String countrys; //收货地址
	private String serialNumber;//合同订单编号
	private String address;  //收货具体地址
	private String invoiceType;//发票类型：0：增值税专用发票 1：增值税普通发票 2：普通发票 3：无发票
	private String type;   //合同订单类型  0:竞价订单  1:招标订单
	private String buyUsername;  //买家用户
	private String sellerUsername;  //买家用户
	private String taxRate;//税率
	private String payType;//"支付方式：0：网银转账 1：承兑汇票 2：现金 3：供应链金融"
	private String payPeroidType;//付款约定[付款周期]：0：货到付款 1：款到发货 2：月结
	private String status;    //订单状态: 0:待确认  1:完成中  2:已完成    3:审核中  4:审核不通过
	private String note;//其他约定
	private String accessory;  //上传附件
	
	private String subBuyUsername;//采购商子账户用户名
	private String subSellerUsername;//供应商子账户用户名
	private String userId;      //当前执行对象
	private String proceessId;  //流程实例ID
	private String tackStatus;  //流程执行状态
	private String isExamine;   //是否开启审批流: 1:开启
	private String reason;    //审核不通过理由

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

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
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

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getCountrys() {
		return countrys;
	}

	public void setCountrys(String countrys) {
		this.countrys = countrys;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayPeroidType() {
		return payPeroidType;
	}

	public void setPayPeroidType(String payPeroidType) {
		this.payPeroidType = payPeroidType;
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

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
