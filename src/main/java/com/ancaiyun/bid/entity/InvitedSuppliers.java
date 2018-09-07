package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description 采购商邀请供应商表
* @Date 14:32 2018/5/28
* @Param 
* @return 
**/

public class InvitedSuppliers{

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
	
	private String purchaserId; //采购商ID
	private String supplierInfoId; //供应商信息ID
	private String correlationId;//相关ID
	private String type;// 0竞价 1招投标

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

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getSupplierInfoId() {
		return supplierInfoId;
	}

	public void setSupplierInfoId(String supplierInfoId) {
		this.supplierInfoId = supplierInfoId;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
