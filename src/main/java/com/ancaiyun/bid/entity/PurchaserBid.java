package com.ancaiyun.bid.entity;

import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 招投标类
* @Date 14:50 2018/5/28
* @Param 
* @return 
**/

public class PurchaserBid {

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

	private String purchaserId;//采购商
	private String title; //招标公告标题
	private String materialCategoryId; //招标类型（物质类别）
	private String bidBond; //投标保证金
	private String additionalRemarks; //招标补充说明
	private String quotationType;//报价方式：0：固定报价 1：浮动报价
	private String payRemarks;//支付说明
	private String needSamplePresentation;//需要送样：0：需要 1：不需要
	private String needHomeDelibery;//送货上门：0：需要 1：不需要
	private String country;//收货地址：省市区
	private String address;//收货地址详细地址
	private String contactName;//联系人姓名
	private String contactMobile;//联系人电话
	private Date applyDeadline;//报名截止时间
	private Date bidOpeningTime;//入围截止时间
//	private String bidOpeningAddress;//开标地址
	private Date bidEvaluationStartTime; //评标开始时间
	private Date bidEvaluationEndTime;//评标结束时间
	private String bidEvaluationMethod;//评标办法（附件形式）
	private String applyNumber;//报名人数
	private String bidStatus;//招标状态：-1：未发布 0：发布标书（审核中） 1：供应商报名（正在招标） 3：开标 4：（评标，定标）中标通知  6: 审核未通过
	private String bidderNumber;//投标人数
	private String bidWinningNotice;//中标通知书
	private String projectId;//工程项目

	private String type;//招标方式：0：公开招标 1：非公开招标
	private String releaseProcessStatus; //发布流程状态:0已发布 1第一步 2第二步 3第三步 4第四步
	private String adminUsername;//管理员用户名
	private String bidNumber;//招投标编号
	private String noPassReason;//审核不通过理由
	private String isInviteSuppliers;//是否邀请供应商 0:是
	private String subUsername;//子账户
	private String userId;      //当前执行对象
	private String proceessId;  //流程实例ID
	private String tackStatus;  //流程执行状态
	private String isExamine;   //是否开启审批流: 1:开启
	private String isContract; //是否创建合同    0:创建过
	private String failureOfBid; //是否流标 0:是
	private int delayTimes; //延期次数
	private BigDecimal futurePrices;//预估总价


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

	public String getMaterialCategoryId() {
		return materialCategoryId;
	}

	public void setMaterialCategoryId(String materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}

	public String getBidBond() {
		return bidBond;
	}

	public void setBidBond(String bidBond) {
		this.bidBond = bidBond;
	}

	public String getAdditionalRemarks() {
		return additionalRemarks;
	}

	public void setAdditionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
	}

	public String getQuotationType() {
		return quotationType;
	}

	public void setQuotationType(String quotationType) {
		this.quotationType = quotationType;
	}

	public String getPayRemarks() {
		return payRemarks;
	}

	public void setPayRemarks(String payRemarks) {
		this.payRemarks = payRemarks;
	}

	public String getNeedSamplePresentation() {
		return needSamplePresentation;
	}

	public void setNeedSamplePresentation(String needSamplePresentation) {
		this.needSamplePresentation = needSamplePresentation;
	}

	public String getNeedHomeDelibery() {
		return needHomeDelibery;
	}

	public void setNeedHomeDelibery(String needHomeDelibery) {
		this.needHomeDelibery = needHomeDelibery;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public Date getApplyDeadline() {
		return applyDeadline;
	}

	public void setApplyDeadline(Date applyDeadline) {
		this.applyDeadline = applyDeadline;
	}

	public Date getBidOpeningTime() {
		return bidOpeningTime;
	}

	public void setBidOpeningTime(Date bidOpeningTime) {
		this.bidOpeningTime = bidOpeningTime;
	}

	public Date getBidEvaluationStartTime() {
		return bidEvaluationStartTime;
	}

	public void setBidEvaluationStartTime(Date bidEvaluationStartTime) {
		this.bidEvaluationStartTime = bidEvaluationStartTime;
	}

	public Date getBidEvaluationEndTime() {
		return bidEvaluationEndTime;
	}

	public void setBidEvaluationEndTime(Date bidEvaluationEndTime) {
		this.bidEvaluationEndTime = bidEvaluationEndTime;
	}

	public String getBidEvaluationMethod() {
		return bidEvaluationMethod;
	}

	public void setBidEvaluationMethod(String bidEvaluationMethod) {
		this.bidEvaluationMethod = bidEvaluationMethod;
	}

	public String getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(String applyNumber) {
		this.applyNumber = applyNumber;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public String getBidderNumber() {
		return bidderNumber;
	}

	public void setBidderNumber(String bidderNumber) {
		this.bidderNumber = bidderNumber;
	}

	public String getBidWinningNotice() {
		return bidWinningNotice;
	}

	public void setBidWinningNotice(String bidWinningNotice) {
		this.bidWinningNotice = bidWinningNotice;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReleaseProcessStatus() {
		return releaseProcessStatus;
	}

	public void setReleaseProcessStatus(String releaseProcessStatus) {
		this.releaseProcessStatus = releaseProcessStatus;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getBidNumber() {
		return bidNumber;
	}

	public void setBidNumber(String bidNumber) {
		this.bidNumber = bidNumber;
	}

	public String getNoPassReason() {
		return noPassReason;
	}

	public void setNoPassReason(String noPassReason) {
		this.noPassReason = noPassReason;
	}

	public String getIsInviteSuppliers() {
		return isInviteSuppliers;
	}

	public void setIsInviteSuppliers(String isInviteSuppliers) {
		this.isInviteSuppliers = isInviteSuppliers;
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

	public String getIsContract() {
		return isContract;
	}

	public void setIsContract(String isContract) {
		this.isContract = isContract;
	}

	public String getFailureOfBid() {
		return failureOfBid;
	}

	public void setFailureOfBid(String failureOfBid) {
		this.failureOfBid = failureOfBid;
	}

	public int getDelayTimes() {
		return delayTimes;
	}

	public void setDelayTimes(int delayTimes) {
		this.delayTimes = delayTimes;
	}

	public BigDecimal getFuturePrices() {
		return futurePrices;
	}

	public void setFuturePrices(BigDecimal futurePrices) {
		this.futurePrices = futurePrices;
	}
}
