package com.ancaiyun.entity;

import java.util.Date;

/*
* @Description 审批不通过理由
* @Date 14:22 2018/5/28
* @Param 
* @return 
**/

public class DisapprovalReason  {

	
	private static final long serialVersionUID = 1L;

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
	
	/**
	 * 关联id
	 */
	private String linkId;
	
	/**
	 * 当前审批人
	 */
	private String approveName;
	
	/**
	 * 审批类型
	 */
	private String type; // 0 发起投标 1 入围  2 评定标  3竞价  4 定价 5供应商招募 6新建合同审批 7合同订单审批 8结算单审批 9支付结算单 10采购商驳回对账单11对账单审批不通过12供应商驳回对账单13采购商驳回对账单支付
	
	/**
	 * 不通过理由
	 */
	private String reason;
	

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
