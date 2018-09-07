package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description 合同订单物资
* @Date 12:00 2018/5/28
* @Param 
* @return 
**/

public class ContractMaterial {

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
	private String productSubCategoryId;   //二级类目
	private String productName;//产品名称
	private String specificationsModel;//规格型号
	private String parameter;//参数指标
	private String brand;//品牌
	private String producingArea;//产地
	private String purchaseQuantity;//采购数量
	private String unit;//计量单位
	private String description;//其他描述
	
	private Date arrivalTime; //到货日期
	private String arrivalPlace; //到货地址
	private String recieverPhone; //收货人电话
	private String remarks; //备注
	private Date deliverGoodsTime;  //发货日期

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

	public String getProductSubCategoryId() {
		return productSubCategoryId;
	}

	public void setProductSubCategoryId(String productSubCategoryId) {
		this.productSubCategoryId = productSubCategoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSpecificationsModel() {
		return specificationsModel;
	}

	public void setSpecificationsModel(String specificationsModel) {
		this.specificationsModel = specificationsModel;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProducingArea() {
		return producingArea;
	}

	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}

	public String getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(String purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getArrivalPlace() {
		return arrivalPlace;
	}

	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}

	public String getRecieverPhone() {
		return recieverPhone;
	}

	public void setRecieverPhone(String recieverPhone) {
		this.recieverPhone = recieverPhone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getDeliverGoodsTime() {
		return deliverGoodsTime;
	}

	public void setDeliverGoodsTime(Date deliverGoodsTime) {
		this.deliverGoodsTime = deliverGoodsTime;
	}
}
