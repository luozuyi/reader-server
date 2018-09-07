package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 报价物资类
* @Date 10:06 2018/5/29
* @Param 
* @return 
**/

public class SupplierOtherBidderMaterial  {

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

	private String purchaserOtherBidMaterialId;// 竞价物资ID
	private BigDecimal bidderPrice;// 竞价价格
	private String supplierOtherBidderId; // 供应商竞价ID
	private BigDecimal freeTax;  //不含单价
	private BigDecimal tax;// 税额
	private String remarks; // 备注

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

	public String getPurchaserOtherBidMaterialId() {
		return purchaserOtherBidMaterialId;
	}

	public void setPurchaserOtherBidMaterialId(String purchaserOtherBidMaterialId) {
		this.purchaserOtherBidMaterialId = purchaserOtherBidMaterialId;
	}

	public BigDecimal getBidderPrice() {
		return bidderPrice;
	}

	public void setBidderPrice(BigDecimal bidderPrice) {
		this.bidderPrice = bidderPrice;
	}

	public String getSupplierOtherBidderId() {
		return supplierOtherBidderId;
	}

	public void setSupplierOtherBidderId(String supplierOtherBidderId) {
		this.supplierOtherBidderId = supplierOtherBidderId;
	}

	public BigDecimal getFreeTax() {
		return freeTax;
	}

	public void setFreeTax(BigDecimal freeTax) {
		this.freeTax = freeTax;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
