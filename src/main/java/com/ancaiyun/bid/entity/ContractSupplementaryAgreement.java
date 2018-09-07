package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 合同补充协议
* @Date 14:21 2018/5/28
* @Param 
* @return 
**/

public class ContractSupplementaryAgreement {
	private static final long serialVersionUID = 1830780245508549599L;

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

	private String contractId;       //合同ID
	
	private String accessoryId;   //补充协议附件
	private String status;   //补协议状态    0:待确认  1:完成中
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private BigDecimal protocolPrice;     //补充协议金额
	
	
	
	public BigDecimal getProtocolPrice() {
		return protocolPrice;
	}

	public void setProtocolPrice(BigDecimal protocolPrice) {
		this.protocolPrice = protocolPrice;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}

	
	
	
	

}
