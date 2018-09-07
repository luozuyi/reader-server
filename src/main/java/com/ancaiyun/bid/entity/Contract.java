package com.ancaiyun.bid.entity;


import java.math.BigDecimal;
import java.util.Date;
/*
* @Description 合同类
* @Date 11:39 2018/5/28
* @Param 
* @return 
**/

public class Contract {


    private String purchaserProjectId;    //项目ID
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


    private Date startTime;        //合同起始时间
    private Date endTime;    //合同结束时间
    private String type;//合同类型：0：竞价合同 1：招标合同  3:其他合同
    private String title;//合同标题
    private String serialNumber;//合同编号
    private String supplierId;//招投标id，竞价id
    private String sendAddress; //发货地址
    private String buyUsername;  //买家用户名
    private String sellerUsername;   //卖家用户名
    private String receiptAddress; //收货地址
    private String purchaserPhone; //采购商联系方式
    private String supplierPhone; //供应商联系方式
    private String accessoryId; //其他附件
    private String status;     //订单状态     0:待确认  1:履约中  2:已完成 3:审核不通过 4:审核中  5:未提交
    private String accessoryContractId; //合同附件
    private BigDecimal bidderTotalPrice;    //合同总金额
    private String isSupplementary;     //是否上传合同补充协议   1:已上传
    private String userId;      //当前执行对象
    private String proceessId;  //流程实例ID
    private String tackStatus;  //流程执行状态
    private String isExamine;   //是否开启审批流: 1:开启
    private String reason;

    private String subBuyUsername;//采购商子账户用户名
    private String subSellerUsername;//供应商子账户用户名

    public String getPurchaserProjectId() {
        return purchaserProjectId;
    }

    public void setPurchaserProjectId(String purchaserProjectId) {
        this.purchaserProjectId = purchaserProjectId;
    }


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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getBuyUsername() {
        return buyUsername;
    }

    public void setBuyUsername(String buyUsername) {
        this.buyUsername = buyUsername;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public String getPurchaserPhone() {
        return purchaserPhone;
    }

    public void setPurchaserPhone(String purchaserPhone) {
        this.purchaserPhone = purchaserPhone;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(String accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccessoryContractId() {
        return accessoryContractId;
    }

    public void setAccessoryContractId(String accessoryContractId) {
        this.accessoryContractId = accessoryContractId;
    }

    public BigDecimal getBidderTotalPrice() {
        return bidderTotalPrice;
    }

    public void setBidderTotalPrice(BigDecimal bidderTotalPrice) {
        this.bidderTotalPrice = bidderTotalPrice;
    }

    public String getIsSupplementary() {
        return isSupplementary;
    }

    public void setIsSupplementary(String isSupplementary) {
        this.isSupplementary = isSupplementary;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSubBuyUsername() {
        return subBuyUsername;
    }

    public void setSubBuyUsername(String subBuyUsername) {
        this.subBuyUsername = subBuyUsername;
    }

    public String getSubSellerUsername() {
        return subSellerUsername;
    }

    public void setSubSellerUsername(String subSellerUsername) {
        this.subSellerUsername = subSellerUsername;
    }
}
