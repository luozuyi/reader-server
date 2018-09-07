package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Channel implements Serializable{
    /**
     * 主键id
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 删除状态
     */
    private String delFlag;
    /**
     * 访问路径
     */
    private String path;
    /**
     * 栏目名称
     */
    private String channelName;
    /**
     * 外部链接
     */
    private String outerUrl;
    /**
     * 是否显示
     */
    private Integer isDisplay;
    /**
     * 栏目页模板
     */
    private String tplChannel;
    /**
     * 文章页模板
     */
    private String tplContent;
    /**
     * 是否在新窗口打开
     */
    private Integer isBlank;
    /**
     * 排列顺序
     */
    private Integer priority;
    /**
     * 扩展数据
     */
    private String param;
    /**
     * 图片路径
     */
    private String imageAddress;
    /**
     * 栏目表关联父id
     */
    private String parentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getOuterUrl() {
        return outerUrl;
    }

    public void setOuterUrl(String outerUrl) {
        this.outerUrl = outerUrl == null ? null : outerUrl.trim();
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getTplChannel() {
        return tplChannel;
    }

    public void setTplChannel(String tplChannel) {
        this.tplChannel = tplChannel == null ? null : tplChannel.trim();
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent == null ? null : tplContent.trim();
    }

    public Integer getIsBlank() {
        return isBlank;
    }

    public void setIsBlank(Integer isBlank) {
        this.isBlank = isBlank;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress == null ? null : imageAddress.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}