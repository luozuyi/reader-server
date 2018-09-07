package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 结算单物资
* @Date 10:04 2018/5/29
* @Param 
* @return 
**/

public class StatementsMaterial {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1656140880317839774L;

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


	private String otherBidMaterimal;   //合同订单物资
	
	private String orderMaterialId;   //
	
	private String statementsId;    //结算单ID
	
	private BigDecimal number;     //数量
	
	private BigDecimal price;   //单价
	
	private String note;     //备注

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

	public String getOtherBidMaterimal() {
		return otherBidMaterimal;
	}

	public void setOtherBidMaterimal(String otherBidMaterimal) {
		this.otherBidMaterimal = otherBidMaterimal;
	}

	public String getOrderMaterialId() {
		return orderMaterialId;
	}

	public void setOrderMaterialId(String orderMaterialId) {
		this.orderMaterialId = orderMaterialId;
	}

	public String getStatementsId() {
		return statementsId;
	}

	public void setStatementsId(String statementsId) {
		this.statementsId = statementsId;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
