package com.ancaiyun.weChat.entity;

import java.util.Date;

public class DifferentFrom {
	 //数据编号
	 private int id;
	 //存包名
	 private String deposit_name;
	 //取包名
	 private String take_name;
	 //手机号
	 private String phone_number;
	 //柜子ID
	 private int locker_id;
	 //箱子ID
	 private int box_id;
	 //存包时间
	 private Date store_time;
	 //取包时间
	 private Date reclaim_time;
	 //状态 1存入 2取出 3管理员操作
	 private int status;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeposit_name() {
		return deposit_name;
	}
	public void setDeposit_name(String deposit_name) {
		this.deposit_name = deposit_name;
	}
	public String getTake_name() {
		return take_name;
	}
	public void setTake_name(String take_name) {
		this.take_name = take_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getLocker_id() {
		return locker_id;
	}
	public void setLocker_id(int locker_id) {
		this.locker_id = locker_id;
	}
	public int getBox_id() {
		return box_id;
	}
	public void setBox_id(int box_id) {
		this.box_id = box_id;
	}
	public Date getStore_time() {
		return store_time;
	}
	public void setStore_time(Date store_time) {
		this.store_time = store_time;
	}
	public Date getReclaim_time() {
		return reclaim_time;
	}
	public void setReclaim_time(Date reclaim_time) {
		this.reclaim_time = reclaim_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
