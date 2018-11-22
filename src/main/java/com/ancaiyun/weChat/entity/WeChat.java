package com.ancaiyun.weChat.entity;

import java.util.Date;

/**
 * 微信Entity
 * @author XiaoLong 
 * @version 2016-11-28
 * */
public class WeChat {
	 private String deposit_image;//存包图片
	 private String deposit_word;//存包文字
	 private String deposit_link;//存包链接
	 private String deposit_type="3";//存包类型(1.文字2.图片加文字3.图片加文字加链接)
	 private String take_image;//取包图片
	 private String take_word;//取包文字
	 private String take_link;//取包链接
	 private String take_type="3";//取包类型
	 private int is_activation;//是否激活(2.是，1.否)
	 private Date create_time;//创建时间
	 private Date update_time;//修改时间
	 private String remarks;//备注
	 
	 public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/*	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getDeposit_image() {
		return deposit_image;
	}
	public void setDeposit_image(String deposit_image) {
		this.deposit_image = deposit_image;
	}
	public String getDeposit_word() {
		return deposit_word;
	}
	public void setDeposit_word(String deposit_word) {
		this.deposit_word = deposit_word;
	}
	public String getDeposit_link() {
		return deposit_link;
	}
	public void setDeposit_link(String deposit_link) {
		this.deposit_link = deposit_link;
	}
	public String getDeposit_type() {
		return deposit_type;
	}
	public void setDeposit_type(String deposit_type) {
		this.deposit_type = deposit_type;
	}
	public String getTake_image() {
		return take_image;
	}
	public void setTake_image(String take_image) {
		this.take_image = take_image;
	}
	public String getTake_word() {
		return take_word;
	}
	public void setTake_word(String take_word) {
		this.take_word = take_word;
	}
	public String getTake_link() {
		return take_link;
	}
	public void setTake_link(String take_link) {
		this.take_link = take_link;
	}
	public String getTake_type() {
		return take_type;
	}
	public void setTake_type(String take_type) {
		this.take_type = take_type;
	}
	public int getIs_activation() {
		return is_activation;
	}
	public void setIs_activation(int is_activation) {
		this.is_activation = is_activation;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}
