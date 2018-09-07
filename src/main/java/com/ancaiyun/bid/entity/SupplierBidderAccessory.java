package com.ancaiyun.bid.entity;

import com.ancaiyun.entity.Accessory;

import java.util.Date;
/*
* @Description 投标附件关联类
* @Date 9:58 2018/5/29
* @Param 
* @return 
**/

public class SupplierBidderAccessory {


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


	private PurchaserBid bidId; //招标ID
	private Accessory accessoryId; //投标附件ID
	private String accessoryType; //文件类型 1：标书 2：附件

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

	public PurchaserBid getBidId() {
		return bidId;
	}

	public void setBidId(PurchaserBid bidId) {
		this.bidId = bidId;
	}

	public Accessory getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(Accessory accessoryId) {
		this.accessoryId = accessoryId;
	}

	public String getAccessoryType() {
		return accessoryType;
	}

	public void setAccessoryType(String accessoryType) {
		this.accessoryType = accessoryType;
	}
}
