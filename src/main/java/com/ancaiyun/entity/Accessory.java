package com.ancaiyun.entity;

import java.io.Serializable;
import java.util.Date;

public class Accessory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     /**
      *  主键id
      */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 后缀
     */
    private String ext;
    /**
     * 路径
     */
    private String filePath;
    /**
     * 组名
     */
    private String groupName;
    /**
     * 删除状态
     */
    private String delFlag;
    /**
     * 名字
     */
    private String name;
    /**
     * 真实姓名
     */
    private String fileRealName;

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

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFileRealName() {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName == null ? null : fileRealName.trim();
    }
}