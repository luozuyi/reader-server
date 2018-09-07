package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 发货单物资
* @Date 9:09 2018/5/29
* @Param 
* @return 
**/

public class RejectMaterial {

	
	private static final long serialVersionUID = 3257392893432482346L;

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


	private String contractMaterialId;   //订单物资ID
	private String rejectId;   //驳回单ID
	private BigDecimal shipmentsNumber;   //发货数量
	private BigDecimal collectNumber;   //收货数量

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

	public String getContractMaterialId() {
		return contractMaterialId;
	}

	public void setContractMaterialId(String contractMaterialId) {
		this.contractMaterialId = contractMaterialId;
	}

	public String getRejectId() {
		return rejectId;
	}

	public void setRejectId(String rejectId) {
		this.rejectId = rejectId;
	}

	public BigDecimal getShipmentsNumber() {
		return shipmentsNumber;
	}

	public void setShipmentsNumber(BigDecimal shipmentsNumber) {
		this.shipmentsNumber = shipmentsNumber;
	}

	public BigDecimal getCollectNumber() {
		return collectNumber;
	}

	public void setCollectNumber(BigDecimal collectNumber) {
		this.collectNumber = collectNumber;
	}
}
