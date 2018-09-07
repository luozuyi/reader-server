package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 对账物资
* @Date 10:04 2018/5/29
* @Param 
* @return 
**/

public class StatementsAccountMaterials {

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



	private Date deliveryTime;    //发货时间
	private String  accountId;//对账单id
	private String productName;//产品名称
	private String specificationsModel;//规格型号
	private String brand;//品牌
	private BigDecimal purchaseQuantity;//采购数量
	private String unit;//计量单位
	private BigDecimal bidderPrice;   //单价
	private BigDecimal occupancyBidderPrice; // 含占用资金单价
	private BigDecimal subtotal; // 小计
	private BigDecimal occupancySubtotal; //含占用 小计 
	private String texture;   //材质

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

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(BigDecimal purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getBidderPrice() {
		return bidderPrice;
	}

	public void setBidderPrice(BigDecimal bidderPrice) {
		this.bidderPrice = bidderPrice;
	}

	public BigDecimal getOccupancyBidderPrice() {
		return occupancyBidderPrice;
	}

	public void setOccupancyBidderPrice(BigDecimal occupancyBidderPrice) {
		this.occupancyBidderPrice = occupancyBidderPrice;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getOccupancySubtotal() {
		return occupancySubtotal;
	}

	public void setOccupancySubtotal(BigDecimal occupancySubtotal) {
		this.occupancySubtotal = occupancySubtotal;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}
}
