package com.ancaiyun.entity;

import java.io.Serializable;

/*
* @Description 城市类
* @Date 14:29 2018/5/28
* @Param 
* @return 
**/

public class Citys implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name; //城市名字
	
	private Character code;//城市编号
	private Provinces provinces;//省份ID

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

	public Character getCode() {
		return code;
	}

	public void setCode(Character code) {
		this.code = code;
	}

	public Provinces getProvinces() {
		return provinces;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}

	@Override
	public String toString() {
		return "Citys [id=" + id + ", name=" + name + ", code=" + code + ", provinces=" + provinces + "]";
	}
	
}
