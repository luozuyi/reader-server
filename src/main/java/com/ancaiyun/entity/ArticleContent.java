package com.ancaiyun.entity;

import java.io.Serializable;

public class ArticleContent implements Serializable{
    /**
     * 主键id
     */
    private String id;
    /**
     * 内容
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}