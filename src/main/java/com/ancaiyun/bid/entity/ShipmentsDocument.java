package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description 发货单
* @Date 9:52 2018/5/29
* @Param 
* @return 
**/

public class ShipmentsDocument {

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


	private String contractOrderId;//合同订单ID
	private String status;//状态 : 0 已发货  1:已完成  2:已驳回
	private Date startTime;   //发货时间
	private Date endTime;  //收货时间
	private String buyUsername; //买家用户名
	private String sellerUsername;  //卖家用户名
	private String serialNumber;//发货单编号
	private String carNumber;  //车牌号
	private String driverName; //司机姓名
	private String driverPhone;  //司机联系方式
	private String type;  //发货类型  0:竞价单 1:招标单
	private String reason;  //取消原因
	private String buyReconciliation;		//买家对账确认  0:待确认  1:已确认
	private String sellerReconciliation;    //卖家对账确认  0:待确认  1:已确认
	
	private String buyCompany;   //买家公司名称
	private String sellerCompany; //卖家公司名称
	private String consignerName;  //发货人姓名
	private String consignerPhone;  //发货人电话
	private String consigneeName;    //收货人姓名


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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getBuyReconciliation() {
		return buyReconciliation;
	}

	public void setBuyReconciliation(String buyReconciliation) {
		this.buyReconciliation = buyReconciliation;
	}

	public String getSellerReconciliation() {
		return sellerReconciliation;
	}

	public void setSellerReconciliation(String sellerReconciliation) {
		this.sellerReconciliation = sellerReconciliation;
	}

	public String getBuyCompany() {
		return buyCompany;
	}

	public void setBuyCompany(String buyCompany) {
		this.buyCompany = buyCompany;
	}

	public String getSellerCompany() {
		return sellerCompany;
	}

	public void setSellerCompany(String sellerCompany) {
		this.sellerCompany = sellerCompany;
	}

	public String getConsignerName() {
		return consignerName;
	}

	public void setConsignerName(String consignerName) {
		this.consignerName = consignerName;
	}

	public String getConsignerPhone() {
		return consignerPhone;
	}

	public void setConsignerPhone(String consignerPhone) {
		this.consignerPhone = consignerPhone;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
}
