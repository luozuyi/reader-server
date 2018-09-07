package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 项目类
* @Date 9:09 2018/5/29
* @Param 
* @return 
**/

public class PurchaserProject  {

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
	private String name;   //项目名称 (必填)
	private String address; //项目所在地
	private String buildingType; //项目建筑类型
	private String scale; //项目规模
	private BigDecimal intendedInvesment; //计划投资 (非)
	private Date startTime; //计划开工时间 (非)
	private Date endTime; //计划完工时间 (非)
	private String recommmend; //项目介绍 (必填)
	private String subUsername;//子账户

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public BigDecimal getIntendedInvesment() {
		return intendedInvesment;
	}

	public void setIntendedInvesment(BigDecimal intendedInvesment) {
		this.intendedInvesment = intendedInvesment;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRecommmend() {
		return recommmend;
	}

	public void setRecommmend(String recommmend) {
		this.recommmend = recommmend;
	}

	public String getSubUsername() {
		return subUsername;
	}

	public void setSubUsername(String subUsername) {
		this.subUsername = subUsername;
	}
}
