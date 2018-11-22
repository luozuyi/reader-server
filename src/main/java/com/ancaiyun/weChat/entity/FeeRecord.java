package com.ancaiyun.weChat.entity;

import java.util.Date;

public class FeeRecord {
	private static final long serialVersionUID = 1L;
	
	private String userName;//用户名
	
	private String companyName;//商家名称
	
	private String lockeName;//柜子名称
	
	private String serialNumber;//所存箱子编号
	
	private Date storeTime;	//存放时间
	
	private Date reclaimTime;	//取回时间 
	
	private Integer chargeType;//收费类型
	
	private Double chargeUnit;		//计费单位  元
	
	private String totalTime;//存放总时间
	
	private Double feeMoney;//收费金额
	
	private String totalCount;//操作总次数
	
	private String todayCount;//今日操作次数

	private String sumMoney;//总费用
	
	private String address;//商家地址
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(String sumMoney) {
		this.sumMoney = sumMoney;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(String todayCount) {
		this.todayCount = todayCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLockeName() {
		return lockeName;
	}

	public void setLockeName(String lockeName) {
		this.lockeName = lockeName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getStoreTime() {
		return storeTime;
	}

	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}

	public Date getReclaimTime() {
		return reclaimTime;
	}

	public void setReclaimTime(Date reclaimTime) {
		this.reclaimTime = reclaimTime;
	}

	public Integer getChargeType() {
		return chargeType;
	}

	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}

	public Double getChargeUnit() {
		return chargeUnit;
	}

	public void setChargeUnit(Double chargeUnit) {
		this.chargeUnit = chargeUnit;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public Double getFeeMoney() {
		return feeMoney;
	}

	public void setFeeMoney(Double feeMoney) {
		this.feeMoney = feeMoney;
	}
	
}
