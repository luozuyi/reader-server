package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description 被驳回的发货单
* @Date 11:42 2018/5/28
* @Param 
* @return 
**/

public class ContractReject {
	private static final long serialVersionUID = -8505167377987729978L;

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

	
	private String shipmentsDocumentId;
	private String serialNumber;//驳回单编号
	private String status;  //状态 : 0 已发货  1:已完成  2:已驳回   3:审核中  4:审核未通过
	private String reason; //驳回原因
	private String bilingDetail;    //结算明细
	private String remarks;      //备注
	private String againStatus; //重新发货状态 0:已重新发货
	private String statusStatements;   //结算状态  :0:未结算  1:已结算
	
	private String subBuyUsername;//采购商子账户用户名
	private String subSellerUsername;//供应商子账户用户名
	private String userId;      //当前执行对象
	private String proceessId;  //流程实例ID
	private String tackStatus;  //流程执行状态
	private String isExamine;   //是否开启审批流: 1:开启

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

	public String getShipmentsDocumentId() {
		return shipmentsDocumentId;
	}

	public void setShipmentsDocumentId(String shipmentsDocumentId) {
		this.shipmentsDocumentId = shipmentsDocumentId;
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

	public String getBilingDetail() {
		return bilingDetail;
	}

	public void setBilingDetail(String bilingDetail) {
		this.bilingDetail = bilingDetail;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAgainStatus() {
		return againStatus;
	}

	public void setAgainStatus(String againStatus) {
		this.againStatus = againStatus;
	}

	public String getStatusStatements() {
		return statusStatements;
	}

	public void setStatusStatements(String statusStatements) {
		this.statusStatements = statusStatements;
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
}
