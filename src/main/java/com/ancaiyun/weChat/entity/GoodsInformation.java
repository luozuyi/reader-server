package com.ancaiyun.weChat.entity;

import java.util.Date;

//物品信息表
public class GoodsInformation {
	//物品编号
	private int goodsId;
	//文本信息1
	private String textOne;
	//文本信息2
	private String textTwo;
	//文本信息3
	private String textThree;
	//文本信息4
	private String textFour;
	//快递编号
	private String expressNumber;
	//存包人微信名
	private String fromUserName;
	//取件人手机号
	private String phoneNumber;
	//柜子Id
	private String lockerId;
	//箱子Id
	private String boxId;
	//存包时间
	private Date times;		

	public GoodsInformation() {	}	
	
	public GoodsInformation(String lockerId, String boxId) {
		this.lockerId = lockerId;
		this.boxId = boxId;
	}
	
	public GoodsInformation(String fromUserName, String phoneNumber,
			String lockerId, String boxId, Date times) {
		this.fromUserName = fromUserName;
		this.phoneNumber = phoneNumber;
		this.lockerId = lockerId;
		this.boxId = boxId;
		this.times = times;
	}



	public GoodsInformation(String expressNumber, String fromUserName,
			String phoneNumber, String lockerId, String boxId, Date times) {
		this.expressNumber = expressNumber;
		this.fromUserName = fromUserName;
		this.phoneNumber = phoneNumber;
		this.lockerId = lockerId;
		this.boxId = boxId;
		this.times = times;
	}



	public GoodsInformation(String textFour, String expressNumber,
			String fromUserName, String phoneNumber, String lockerId,
			String boxId, Date times) {
		this.textFour = textFour;
		this.expressNumber = expressNumber;
		this.fromUserName = fromUserName;
		this.phoneNumber = phoneNumber;
		this.lockerId = lockerId;
		this.boxId = boxId;
		this.times = times;
	}



	public GoodsInformation(String textThree, String textFour,
			String expressNumber, String fromUserName, String phoneNumber,
			String lockerId, String boxId, Date times) {
		this.textThree = textThree;
		this.textFour = textFour;
		this.expressNumber = expressNumber;
		this.fromUserName = fromUserName;
		this.phoneNumber = phoneNumber;
		this.lockerId = lockerId;
		this.boxId = boxId;
		this.times = times;
	}



	public GoodsInformation(String textTwo, String textThree, String textFour,
			String expressNumber, String fromUserName, String phoneNumber,
			String lockerId, String boxId, Date times) {
		this.textTwo = textTwo;
		this.textThree = textThree;
		this.textFour = textFour;
		this.expressNumber = expressNumber;
		this.fromUserName = fromUserName;
		this.phoneNumber = phoneNumber;
		this.lockerId = lockerId;
		this.boxId = boxId;
		this.times = times;
	}



	public GoodsInformation(String textOne, String textTwo, String textThree,
			String textFour, String expressNumber, String fromUserName,
			String phoneNumber, String lockerId, String boxId, Date times) {
		this.textOne = textOne;
		this.textTwo = textTwo;
		this.textThree = textThree;
		this.textFour = textFour;
		this.expressNumber = expressNumber;
		this.fromUserName = fromUserName;
		this.phoneNumber = phoneNumber;
		this.lockerId = lockerId;
		this.boxId = boxId;
		this.times = times;
	}

	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getTextOne() {
		return textOne;
	}
	public void setTextOne(String textOne) {
		this.textOne = textOne;
	}
	public GoodsInformation(String textOne, String textTwo, String textThree,
			String textFour, String expressNumber, String fromUserName,
			String phoneNumber, String lockerId, String boxId) {
		super();
		this.textOne = textOne;
		this.textTwo = textTwo;
		this.textThree = textThree;
		this.textFour = textFour;
		this.expressNumber = expressNumber;
		this.fromUserName = fromUserName;
		this.phoneNumber = phoneNumber;
		this.lockerId = lockerId;
		this.boxId = boxId;
	}

	public String getTextTwo() {
		return textTwo;
	}
	public void setTextTwo(String textTwo) {
		this.textTwo = textTwo;
	}
	public String getTextThree() {
		return textThree;
	}
	public void setTextThree(String textThree) {
		this.textThree = textThree;
	}
	public String getTextFour() {
		return textFour;
	}
	public void setTextFour(String textFour) {
		this.textFour = textFour;
	}
	public String getExpressNumber() {
		return expressNumber;
	}
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLockerId() {
		return lockerId;
	}
	public void setLockerId(String lockerId) {
		this.lockerId = lockerId;
	}
	public String getBoxId() {
		return boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
}
