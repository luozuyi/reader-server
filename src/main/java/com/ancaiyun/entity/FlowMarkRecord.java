package com.ancaiyun.entity;


import java.util.Date;
/*
* @Description 记录流标记录
* @Date 12:00 2018/5/28
* @Param 
* @return 
**/

public class FlowMarkRecord {
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


	private String bidId;          //招标Id

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
}
