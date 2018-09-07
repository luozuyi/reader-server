package com.ancaiyun.entity;

import java.io.Serializable;
/*
* @Description 省份表
* @Date 14:50 2018/5/28
* @Param 
* @return 
**/

public class Provinces implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;//id
	
	private String name;//名字
	
	private Integer weight;
	
	private Character code;//代码

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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Character getCode() {
		return code;
	}

	public void setCode(Character code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Provinces [id=" + id + ", name=" + name + ", weight=" + weight + ", code=" + code + "]";
	}
	
	
}
