package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 投标物资类
* @Date 10:04 2018/5/29
* @Param 
* @return 
**/

public class SupplierBidderMaterial {

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


	private String bidId; //招标ID
	private String purchaserBidMaterialId; //招标物资ID
	private String supplierBidderId;//供应商投标关联表
	private BigDecimal bidderPrice; //含税单价
	private String remark;//备注
	private BigDecimal taxRate;//税率

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

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public String getPurchaserBidMaterialId() {
		return purchaserBidMaterialId;
	}

	public void setPurchaserBidMaterialId(String purchaserBidMaterialId) {
		this.purchaserBidMaterialId = purchaserBidMaterialId;
	}

	public String getSupplierBidderId() {
		return supplierBidderId;
	}

	public void setSupplierBidderId(String supplierBidderId) {
		this.supplierBidderId = supplierBidderId;
	}

	public BigDecimal getBidderPrice() {
		return bidderPrice;
	}

	public void setBidderPrice(BigDecimal bidderPrice) {
		this.bidderPrice = bidderPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
}
