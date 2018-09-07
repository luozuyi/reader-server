package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{
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
     * 文章失效时间
     */
    private Date invalidTime;
    /**
     * 删除状态
     */
    private String delFlag;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 浏览量
     */
    private Integer browses;
    /**
     * 扩展数据
     */
    private String paramOne;
    /**
     * 扩展数据
     */
    private String paramTwo;
    /**
     * 栏目
     */
    private String channelId;
    /**
     * 模板ID
     */
    private String channelArticleTemplateId;
    /**
     * 封面
     */
    private String coverId;
    /**
     * 内容id
     */
    private String articleContentId;
    /**
     * 文章来源
     */
    private String source;

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

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Integer getBrowses() {
        return browses;
    }

    public void setBrowses(Integer browses) {
        this.browses = browses;
    }

    public String getParamOne() {
        return paramOne;
    }

    public void setParamOne(String paramOne) {
        this.paramOne = paramOne == null ? null : paramOne.trim();
    }

    public String getParamTwo() {
        return paramTwo;
    }

    public void setParamTwo(String paramTwo) {
        this.paramTwo = paramTwo == null ? null : paramTwo.trim();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public String getChannelArticleTemplateId() {
        return channelArticleTemplateId;
    }

    public void setChannelArticleTemplateId(String channelArticleTemplateId) {
        this.channelArticleTemplateId = channelArticleTemplateId == null ? null : channelArticleTemplateId.trim();
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId == null ? null : coverId.trim();
    }

    public String getArticleContentId() {
        return articleContentId;
    }

    public void setArticleContentId(String articleContentId) {
        this.articleContentId = articleContentId == null ? null : articleContentId.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }
}