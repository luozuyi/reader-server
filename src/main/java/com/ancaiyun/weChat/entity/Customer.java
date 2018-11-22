package com.ancaiyun.weChat.entity;

public class Customer {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String openId; //微信用户Open ID
	private String nickName;//用户名
	
	public Customer() {
		super();
	}

	

	public Customer(String openId, String nickName) {
		super();
		this.openId = openId;
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickname(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Customer [openId=" + openId + ", nickName=" + nickName + "]";
	}
	
}
