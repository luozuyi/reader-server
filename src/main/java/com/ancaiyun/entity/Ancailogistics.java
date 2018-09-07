package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Ancailogistics implements Serializable {

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
     * 联系人
     */
    private String linkPerson;

    /**
     * 手机号
     */
    private String telphone;

    /**
     * 托运物资
     */
    private String checkMaterial;

    /**
     * 体积体重
     */
    private String volumeWeight;

    /**
     * 建议车型
     */
    private String suggestCartType;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 出发地
     */
    private String birthland;

    /**
     * 付款方式
     */
    private String payType;

    /**
     * 发票
     */
    private String invoice;

    /**
     * 保险
     */
    private String insurance;

    /**
     * 装卸方式1：叉车作业2：人工搬运3：吊装作业
     */
    private String handlingType;

    /**
     * 其他说明1：随单签收2：隔天多趟3：两装一卸
     */
    private String otherDetail;

    /**
     * 备注
     */
    private String note;

    /**
     * 发货市
     */
    private String city;

    /**
     * 发货区
     */
    private String country;

    /**
     * 发货省
     */
    private String province;

    /**
     * 详细的发货地址
     */
    private String shipDetailed;

    /**
     * 收货市
     */
    private String deliveryCity;

    /**
     * 收货区
     */
    private String deliveryCountry;

    /**
     * 收货省
     */
    private String deliveryProvince;

    /**
     * 详细的收货地址
     */
    private String deliveryDetailed;

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

    public String getLinkPerson() {
        return linkPerson;
    }

    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getCheckMaterial() {
        return checkMaterial;
    }

    public void setCheckMaterial(String checkMaterial) {
        this.checkMaterial = checkMaterial;
    }

    public String getVolumeWeight() {
        return volumeWeight;
    }

    public void setVolumeWeight(String volumeWeight) {
        this.volumeWeight = volumeWeight;
    }

    public String getSuggestCartType() {
        return suggestCartType;
    }

    public void setSuggestCartType(String suggestCartType) {
        this.suggestCartType = suggestCartType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBirthland() {
        return birthland;
    }

    public void setBirthland(String birthland) {
        this.birthland = birthland;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getHandlingType() {
        return handlingType;
    }

    public void setHandlingType(String handlingType) {
        this.handlingType = handlingType;
    }

    public String getOtherDetail() {
        return otherDetail;
    }

    public void setOtherDetail(String otherDetail) {
        this.otherDetail = otherDetail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getShipDetailed() {
        return shipDetailed;
    }

    public void setShipDetailed(String shipDetailed) {
        this.shipDetailed = shipDetailed;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    public String getDeliveryProvince() {
        return deliveryProvince;
    }

    public void setDeliveryProvince(String deliveryProvince) {
        this.deliveryProvince = deliveryProvince;
    }

    public String getDeliveryDetailed() {
        return deliveryDetailed;
    }

    public void setDeliveryDetailed(String deliveryDetailed) {
        this.deliveryDetailed = deliveryDetailed;
    }
}
