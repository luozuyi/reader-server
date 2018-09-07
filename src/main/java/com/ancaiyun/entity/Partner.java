package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Partner implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String partnerId;
    /**
     * 提交时间
     */
    private Date submitTime;
    /**
     *公司联系人
     */
    private String companyConstacts;
    /**
     *公司联系电话
     */
    private String companyTel;
    /**
     * 联系人QQ
     */
    private String partnerQq;
    /**
     * 公司网站
     */
    private String companyWebsite;
    /**
     * 超链接图像地址
     */
    private String httpImagesUrl;
    /**
     * 删除状态0：正常1：删除2：待删除
     */
    private String delFlag;
    /**
     * 合作类容
     */
    private String cooperationContents;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getCompanyConstacts() {
        return companyConstacts;
    }

    public void setCompanyConstacts(String companyConstacts) {
        this.companyConstacts = companyConstacts == null ? null : companyConstacts.trim();
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    public String getPartnerQq() {
        return partnerQq;
    }

    public void setPartnerQq(String partnerQq) {
        this.partnerQq = partnerQq == null ? null : partnerQq.trim();
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite == null ? null : companyWebsite.trim();
    }

    public String getHttpImagesUrl() {
        return httpImagesUrl;
    }

    public void setHttpImagesUrl(String httpImagesUrl) {
        this.httpImagesUrl = httpImagesUrl == null ? null : httpImagesUrl.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCooperationContents() {
        return cooperationContents;
    }

    public void setCooperationContents(String cooperationContents) {
        this.cooperationContents = cooperationContents == null ? null : cooperationContents.trim();
    }
}