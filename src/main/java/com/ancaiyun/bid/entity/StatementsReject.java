package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description 结算单驳回类
* @Date 10:04 2018/5/29
* @Param 
* @return 
**/

public class StatementsReject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6766943747692872728L;

	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 删除状态0：正常1：删除2：待删除
	 */
	private String delFlag;


	private String statementsId;
	
	private String contractRejectId;

	
}
