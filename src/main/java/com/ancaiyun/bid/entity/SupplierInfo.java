package com.ancaiyun.bid.entity;

import java.util.Date;

/*
* @Description 供应商信息类
* @Date 9:53 2018/6/4
* @Param 
* @return 
**/

public class SupplierInfo  {

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

	private String companyName; //公司名称 
	private String companyRegisteredCapital; //注册资金
	private String companyEmployeeNumber; //员工人数
	private String companyTelephone; //公司电话
	private String companyProvinceCityCountry; //公司所在地
	private String companyEnterpriseNature; //单位性质
	private String companyTaxpayerType; //纳税人类型
	private String companyAnnualTurnover; //每年营业额
	private String companyTaxRate; //纳税人税率
	private String companyAddress; //公司详细地址
	private String companyBusinessScope; //经营范围
	private String companyLegalPersonName; //法人姓名
	private String companyWebsite; //企业网址
	private String companyLegalPersonCertificateType; //法人证件类型
	private String companyLegalPersonCertificateNumber; //法人证件号
	private String companyLegalPersonCertificateTelephone; //法人电话
	private String companyBusinessLicense; //营业执照三证合一
	private String companyUnifiedSocialCreditCode; //统一社会信用代码
	private Date companyBusinessLicenseIssueDate; //发证日期
	private Date companyBusinessLicenseRegisterDate;//注册成立日期
	private Date companyBusinessLicenseValidatyDate; //有效日期
	private String companyBusinessLicenseAddress; //营业执照公司所在地
	private String companyBusinessLicenseElectronicVersion; //营业执照证件电子版
	private String companyEnterpriseAuthorizationElectronicVersion; //企业授权书证件电子版
	private String companyMainBusinessId;//主营业务
	private String companyToMember; //对应的member
	private String supplierBidderId;//招投标关联
	private String auditStatus;//信息审核状态   0.正在审核  1.审核通过 2.审核未通过 3.冻结
	private String materialCategoryId; //主营业务(新 2017.11.01)
	private String isBidding;//0.来自招募  1.来自招投标报名
	private String companyIntroduction;//企业简介
	private String linkmanContacts;//企业联系人姓名
	private String linkmanContactsPhone;//企业联系人联系方式
	private String registrationAuthority;//登记机关
	private String permitOfOpeningBankAccoun;//银行开户许可证编号
	private String productionPermitNo;//生产许可证编号
	private String safetyProductionLicenseNumber;//安全生产许可证号
	private String recommendationUnit;//推荐单位
	private String qualificationInformation;//资质信息
	private String purchaserId;//采购商
	private String purchaserBidId;//招标信息
	private String purchaserRecruitSupplierId; //供应商招募ID
	private String groundForRejection;//驳回理由
	private String companyBusinessScopeDet;//经营范围介绍
	
	private String contactPosition; //联系人职务
	private String contactName;    //联系人姓名
	private String contactPhone;   //联系人联系方式
	private String registeredAddress;   //注册地址
	private String buySubUsername;//采购商子账户用户名
	private String sellerSubUsername;//供应商子账户用户名

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyRegisteredCapital() {
		return companyRegisteredCapital;
	}

	public void setCompanyRegisteredCapital(String companyRegisteredCapital) {
		this.companyRegisteredCapital = companyRegisteredCapital;
	}

	public String getCompanyEmployeeNumber() {
		return companyEmployeeNumber;
	}

	public void setCompanyEmployeeNumber(String companyEmployeeNumber) {
		this.companyEmployeeNumber = companyEmployeeNumber;
	}

	public String getCompanyTelephone() {
		return companyTelephone;
	}

	public void setCompanyTelephone(String companyTelephone) {
		this.companyTelephone = companyTelephone;
	}

	public String getCompanyProvinceCityCountry() {
		return companyProvinceCityCountry;
	}

	public void setCompanyProvinceCityCountry(String companyProvinceCityCountry) {
		this.companyProvinceCityCountry = companyProvinceCityCountry;
	}

	public String getCompanyEnterpriseNature() {
		return companyEnterpriseNature;
	}

	public void setCompanyEnterpriseNature(String companyEnterpriseNature) {
		this.companyEnterpriseNature = companyEnterpriseNature;
	}

	public String getCompanyTaxpayerType() {
		return companyTaxpayerType;
	}

	public void setCompanyTaxpayerType(String companyTaxpayerType) {
		this.companyTaxpayerType = companyTaxpayerType;
	}

	public String getCompanyAnnualTurnover() {
		return companyAnnualTurnover;
	}

	public void setCompanyAnnualTurnover(String companyAnnualTurnover) {
		this.companyAnnualTurnover = companyAnnualTurnover;
	}

	public String getCompanyTaxRate() {
		return companyTaxRate;
	}

	public void setCompanyTaxRate(String companyTaxRate) {
		this.companyTaxRate = companyTaxRate;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyBusinessScope() {
		return companyBusinessScope;
	}

	public void setCompanyBusinessScope(String companyBusinessScope) {
		this.companyBusinessScope = companyBusinessScope;
	}

	public String getCompanyLegalPersonName() {
		return companyLegalPersonName;
	}

	public void setCompanyLegalPersonName(String companyLegalPersonName) {
		this.companyLegalPersonName = companyLegalPersonName;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyLegalPersonCertificateType() {
		return companyLegalPersonCertificateType;
	}

	public void setCompanyLegalPersonCertificateType(String companyLegalPersonCertificateType) {
		this.companyLegalPersonCertificateType = companyLegalPersonCertificateType;
	}

	public String getCompanyLegalPersonCertificateNumber() {
		return companyLegalPersonCertificateNumber;
	}

	public void setCompanyLegalPersonCertificateNumber(String companyLegalPersonCertificateNumber) {
		this.companyLegalPersonCertificateNumber = companyLegalPersonCertificateNumber;
	}

	public String getCompanyLegalPersonCertificateTelephone() {
		return companyLegalPersonCertificateTelephone;
	}

	public void setCompanyLegalPersonCertificateTelephone(String companyLegalPersonCertificateTelephone) {
		this.companyLegalPersonCertificateTelephone = companyLegalPersonCertificateTelephone;
	}

	public String getCompanyBusinessLicense() {
		return companyBusinessLicense;
	}

	public void setCompanyBusinessLicense(String companyBusinessLicense) {
		this.companyBusinessLicense = companyBusinessLicense;
	}

	public String getCompanyUnifiedSocialCreditCode() {
		return companyUnifiedSocialCreditCode;
	}

	public void setCompanyUnifiedSocialCreditCode(String companyUnifiedSocialCreditCode) {
		this.companyUnifiedSocialCreditCode = companyUnifiedSocialCreditCode;
	}

	public Date getCompanyBusinessLicenseIssueDate() {
		return companyBusinessLicenseIssueDate;
	}

	public void setCompanyBusinessLicenseIssueDate(Date companyBusinessLicenseIssueDate) {
		this.companyBusinessLicenseIssueDate = companyBusinessLicenseIssueDate;
	}

	public Date getCompanyBusinessLicenseRegisterDate() {
		return companyBusinessLicenseRegisterDate;
	}

	public void setCompanyBusinessLicenseRegisterDate(Date companyBusinessLicenseRegisterDate) {
		this.companyBusinessLicenseRegisterDate = companyBusinessLicenseRegisterDate;
	}

	public Date getCompanyBusinessLicenseValidatyDate() {
		return companyBusinessLicenseValidatyDate;
	}

	public void setCompanyBusinessLicenseValidatyDate(Date companyBusinessLicenseValidatyDate) {
		this.companyBusinessLicenseValidatyDate = companyBusinessLicenseValidatyDate;
	}

	public String getCompanyBusinessLicenseAddress() {
		return companyBusinessLicenseAddress;
	}

	public void setCompanyBusinessLicenseAddress(String companyBusinessLicenseAddress) {
		this.companyBusinessLicenseAddress = companyBusinessLicenseAddress;
	}

	public String getCompanyBusinessLicenseElectronicVersion() {
		return companyBusinessLicenseElectronicVersion;
	}

	public void setCompanyBusinessLicenseElectronicVersion(String companyBusinessLicenseElectronicVersion) {
		this.companyBusinessLicenseElectronicVersion = companyBusinessLicenseElectronicVersion;
	}

	public String getCompanyEnterpriseAuthorizationElectronicVersion() {
		return companyEnterpriseAuthorizationElectronicVersion;
	}

	public void setCompanyEnterpriseAuthorizationElectronicVersion(String companyEnterpriseAuthorizationElectronicVersion) {
		this.companyEnterpriseAuthorizationElectronicVersion = companyEnterpriseAuthorizationElectronicVersion;
	}

	public String getCompanyMainBusinessId() {
		return companyMainBusinessId;
	}

	public void setCompanyMainBusinessId(String companyMainBusinessId) {
		this.companyMainBusinessId = companyMainBusinessId;
	}

	public String getCompanyToMember() {
		return companyToMember;
	}

	public void setCompanyToMember(String companyToMember) {
		this.companyToMember = companyToMember;
	}

	public String getSupplierBidderId() {
		return supplierBidderId;
	}

	public void setSupplierBidderId(String supplierBidderId) {
		this.supplierBidderId = supplierBidderId;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getMaterialCategoryId() {
		return materialCategoryId;
	}

	public void setMaterialCategoryId(String materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}

	public String getIsBidding() {
		return isBidding;
	}

	public void setIsBidding(String isBidding) {
		this.isBidding = isBidding;
	}

	public String getCompanyIntroduction() {
		return companyIntroduction;
	}

	public void setCompanyIntroduction(String companyIntroduction) {
		this.companyIntroduction = companyIntroduction;
	}

	public String getLinkmanContacts() {
		return linkmanContacts;
	}

	public void setLinkmanContacts(String linkmanContacts) {
		this.linkmanContacts = linkmanContacts;
	}

	public String getLinkmanContactsPhone() {
		return linkmanContactsPhone;
	}

	public void setLinkmanContactsPhone(String linkmanContactsPhone) {
		this.linkmanContactsPhone = linkmanContactsPhone;
	}

	public String getRegistrationAuthority() {
		return registrationAuthority;
	}

	public void setRegistrationAuthority(String registrationAuthority) {
		this.registrationAuthority = registrationAuthority;
	}

	public String getPermitOfOpeningBankAccoun() {
		return permitOfOpeningBankAccoun;
	}

	public void setPermitOfOpeningBankAccoun(String permitOfOpeningBankAccoun) {
		this.permitOfOpeningBankAccoun = permitOfOpeningBankAccoun;
	}

	public String getProductionPermitNo() {
		return productionPermitNo;
	}

	public void setProductionPermitNo(String productionPermitNo) {
		this.productionPermitNo = productionPermitNo;
	}

	public String getSafetyProductionLicenseNumber() {
		return safetyProductionLicenseNumber;
	}

	public void setSafetyProductionLicenseNumber(String safetyProductionLicenseNumber) {
		this.safetyProductionLicenseNumber = safetyProductionLicenseNumber;
	}

	public String getRecommendationUnit() {
		return recommendationUnit;
	}

	public void setRecommendationUnit(String recommendationUnit) {
		this.recommendationUnit = recommendationUnit;
	}

	public String getQualificationInformation() {
		return qualificationInformation;
	}

	public void setQualificationInformation(String qualificationInformation) {
		this.qualificationInformation = qualificationInformation;
	}

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getPurchaserBidId() {
		return purchaserBidId;
	}

	public void setPurchaserBidId(String purchaserBidId) {
		this.purchaserBidId = purchaserBidId;
	}

	public String getPurchaserRecruitSupplierId() {
		return purchaserRecruitSupplierId;
	}

	public void setPurchaserRecruitSupplierId(String purchaserRecruitSupplierId) {
		this.purchaserRecruitSupplierId = purchaserRecruitSupplierId;
	}

	public String getGroundForRejection() {
		return groundForRejection;
	}

	public void setGroundForRejection(String groundForRejection) {
		this.groundForRejection = groundForRejection;
	}

	public String getCompanyBusinessScopeDet() {
		return companyBusinessScopeDet;
	}

	public void setCompanyBusinessScopeDet(String companyBusinessScopeDet) {
		this.companyBusinessScopeDet = companyBusinessScopeDet;
	}

	public String getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getRegisteredAddress() {
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}

	public String getBuySubUsername() {
		return buySubUsername;
	}

	public void setBuySubUsername(String buySubUsername) {
		this.buySubUsername = buySubUsername;
	}

	public String getSellerSubUsername() {
		return sellerSubUsername;
	}

	public void setSellerSubUsername(String sellerSubUsername) {
		this.sellerSubUsername = sellerSubUsername;
	}
}
