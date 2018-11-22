package com.ancaiyun.weChat.entity;

import java.util.Date;

public class CallRecord  {
	private String id;
	private String openId;
	private Integer lockerId;
	private String createTime;
	private Date time;
	

	public CallRecord() {
		super();
	}
	
	public CallRecord(String openId, Integer lockerId, String createTime,
			Date time) {
		super();
		this.openId = openId;
		this.lockerId = lockerId;
		this.createTime = createTime;
		this.time = time;
	}


	public Integer getLockerId() {
		return lockerId;
	}
	public void setLockerId(Integer lockerId) {
		this.lockerId = lockerId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CallRecord [id=" + id + ", openId=" + openId + ", lockerId="
				+ lockerId + ", createTime=" + createTime + ", time=" + time
				+ "]";
	}
	
	
}
