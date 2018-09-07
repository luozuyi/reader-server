package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 发货物资
* @Date 9:52 2018/5/29
* @Param 
* @return 
**/

public class ShipmentsMaterial{

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


	private String contractMaterialId;//合同订单物资ID
	private String shipmentDocumentId; //发货单ID
	private BigDecimal shipmentsNumber;//发货数量
	private BigDecimal confirmNumber;  //实收数量
	private String remarks;//备注

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

	public String getShipmentDocumentId() {
		return shipmentDocumentId;
	}

	public void setShipmentDocumentId(String shipmentDocumentId) {
		this.shipmentDocumentId = shipmentDocumentId;
	}

	public BigDecimal getShipmentsNumber() {
		return shipmentsNumber;
	}

	public void setShipmentsNumber(BigDecimal shipmentsNumber) {
		this.shipmentsNumber = shipmentsNumber;
	}

	public BigDecimal getConfirmNumber() {
		return confirmNumber;
	}

	public void setConfirmNumber(BigDecimal confirmNumber) {
		this.confirmNumber = confirmNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
