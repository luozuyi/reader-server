package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description  供应商竞价与附件关联表
* @Date 10:04 2018/5/29
* @Param 
* @return 
**/

public class SupplierOtherBidderAccessory  {

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


	private String otherBidderId;

	private String accessoryId;

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

	public String getOtherBidderId() {
		return otherBidderId;
	}

	public void setOtherBidderId(String otherBidderId) {
		this.otherBidderId = otherBidderId;
	}

	public String getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}
}
