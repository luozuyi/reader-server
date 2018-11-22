package com.ancaiyun.weChat.entity;
//微信用户信息
public class WechatUser {
	//信息编号
	private int userid;
	//用户名--openid
	private String userName;
	//用户手机号000代表未绑定
	private String userPhone;
	//是否关注0代表未关注1代表已关注
	private int whetherFollow;
	//验证码
	private int vcode;
	//是否绑定手机号0没有绑定1绑定
	private int isbinding;
	
	public int getIsbinding() {
		return isbinding;
	}
	public void setIsbinding(int isbinding) {
		this.isbinding = isbinding;
	}
	public int getVcode() {
		return vcode;
	}
	public void setVcode(int vcode) {
		this.vcode = vcode;
	}
	public WechatUser(){};
	public WechatUser(String userName){
		this.userName = userName;
	}
	public WechatUser(String userName, int whetherFollow) {
		this.userName = userName;
		this.whetherFollow = whetherFollow;
	}
	public WechatUser(String userName,String userPhone,int wetherFollow){
		this.userName = userName;
		this.userPhone = userPhone;
		this.whetherFollow = wetherFollow;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getWhetherFollow() {
		return whetherFollow;
	}
	public void setWhetherFollow(int whetherFollow) {
		this.whetherFollow = whetherFollow;
	}
}
