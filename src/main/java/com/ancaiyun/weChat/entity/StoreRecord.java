package com.ancaiyun.weChat.entity;

import java.util.Date;

public class StoreRecord  {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private Date time;	//时间
	private String username;//用户名
	private Integer type;//开关命令 1：开 2：关
	private String adminname;//管理员名字
	
	public StoreRecord() {
		super();
	}
	








	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	

	public String getAdminname() {
		return adminname;
	}


	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}




		
	
}
