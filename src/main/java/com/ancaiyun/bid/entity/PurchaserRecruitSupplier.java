package com.ancaiyun.bid.entity;

import java.util.Date;
/*
* @Description 供应商招募类
* @Date 9:09 2018/5/29
* @Param 
* @return 
**/

public class PurchaserRecruitSupplier {

	/**
	 * 
	 */
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


	private String purchaserId;//采购商ID
	private String title;   //标题
	private String projectNum;   //项目编号
	private String solicitationConditions;  /*1、依法注册、具有法人资格的生产厂或代理商；
											2、具有健全的财务会计制度和良好的商业信誉；
											3、有依法纳税的良好记录；
											4、生产工艺、装备必须符合国家相关规定，具有必需的专业技术能力，并已获得生产许可证或近三年省部级及以上有资质检测机构颁发的产品质量检测报告（仅适用于生产厂）；
											5、已获得ISO系列质量管理体系认证证书；
											6、凡需行政许可或和行业认证的物资，须取得行政许可或行业认证（仅适用于生产厂）；
											7、近三年无违约或不恰当履约记录；
											8、近三年内在经营活动中无重大违法违规记录；
											9、法律、法规规定的其他条件。*/
	private String scope;   //供应商范围
	private String supplierProvinces;  //供应商所在地区
	private String supplierBusinessModel;  //要求供应商经营模式：0：生产制造 1：贸易批发 2：商业服务 3：其他组织【复选框】
	private String supplierRegisteredCapital;   //供应商注册资本(万元)
	private String materialRequire;   //物资专用要求
	private String requirementStatements;   //物资资料需求说明
	private String status;   //审核状态 0: 审核中  1:招募中 2:招募完成  3:审核未通过  4:已取消
	private Integer quotationNumber;   //报名人数
	private String user;  //后台发布人员ID
	private String materys;  //物资种类
	
	private String contactPerson;    //联系人姓名
	private String contactNumber;    //联系人电话
	private String reason;      //审核不通过理由
	private String subUsername;//子账户用户名
	private String userId;      //当前执行对象
	private String proceessId;  //流程实例ID
	private String tackStatus;  //流程执行状态
	private String isExamine;   //是否开启审批流: 1:开启


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	public String getSolicitationConditions() {
		return solicitationConditions;
	}

	public void setSolicitationConditions(String solicitationConditions) {
		this.solicitationConditions = solicitationConditions;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getSupplierProvinces() {
		return supplierProvinces;
	}

	public void setSupplierProvinces(String supplierProvinces) {
		this.supplierProvinces = supplierProvinces;
	}

	public String getSupplierBusinessModel() {
		return supplierBusinessModel;
	}

	public void setSupplierBusinessModel(String supplierBusinessModel) {
		this.supplierBusinessModel = supplierBusinessModel;
	}

	public String getSupplierRegisteredCapital() {
		return supplierRegisteredCapital;
	}

	public void setSupplierRegisteredCapital(String supplierRegisteredCapital) {
		this.supplierRegisteredCapital = supplierRegisteredCapital;
	}

	public String getMaterialRequire() {
		return materialRequire;
	}

	public void setMaterialRequire(String materialRequire) {
		this.materialRequire = materialRequire;
	}

	public String getRequirementStatements() {
		return requirementStatements;
	}

	public void setRequirementStatements(String requirementStatements) {
		this.requirementStatements = requirementStatements;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQuotationNumber() {
		return quotationNumber;
	}

	public void setQuotationNumber(Integer quotationNumber) {
		this.quotationNumber = quotationNumber;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMaterys() {
		return materys;
	}

	public void setMaterys(String materys) {
		this.materys = materys;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSubUsername() {
		return subUsername;
	}

	public void setSubUsername(String subUsername) {
		this.subUsername = subUsername;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProceessId() {
		return proceessId;
	}

	public void setProceessId(String proceessId) {
		this.proceessId = proceessId;
	}

	public String getTackStatus() {
		return tackStatus;
	}

	public void setTackStatus(String tackStatus) {
		this.tackStatus = tackStatus;
	}

	public String getIsExamine() {
		return isExamine;
	}

	public void setIsExamine(String isExamine) {
		this.isExamine = isExamine;
	}
}
