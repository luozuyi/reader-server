package com.ancaiyun.entity;

import java.io.Serializable;

/*
* @Description 区域类
* @Date 14:18 2018/5/28
* @Param 
* @return 
**/

public class Countrys implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;//名字
	private Citys cityId;//城市

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Citys getCityId() {
		return cityId;
	}

	public void setCityId(Citys cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "Countys [id=" + id + ", name=" + name + ", cityId=" + cityId + "]";
	}
	
}
