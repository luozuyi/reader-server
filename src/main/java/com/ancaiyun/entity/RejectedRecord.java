package com.ancaiyun.entity;

import java.util.Date;
/*
* @Description 招投标驳回记录类
* @Date 9:09 2018/5/29
* @Param 
* @return 
**/

public class RejectedRecord {

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


	private String bidId;//招投标关联ID
	private String winBidMemberId;//中标者member
	private String noPassReason;//驳回原因
	private String winReason;//中标原因
	private Integer dismissTheNumber;//驳回次数

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

	public String getWinBidMemberId() {
		return winBidMemberId;
	}

	public void setWinBidMemberId(String winBidMemberId) {
		this.winBidMemberId = winBidMemberId;
	}

	public String getNoPassReason() {
		return noPassReason;
	}

	public void setNoPassReason(String noPassReason) {
		this.noPassReason = noPassReason;
	}

	public String getWinReason() {
		return winReason;
	}

	public void setWinReason(String winReason) {
		this.winReason = winReason;
	}

	public Integer getDismissTheNumber() {
		return dismissTheNumber;
	}

	public void setDismissTheNumber(Integer dismissTheNumber) {
		this.dismissTheNumber = dismissTheNumber;
	}
}
