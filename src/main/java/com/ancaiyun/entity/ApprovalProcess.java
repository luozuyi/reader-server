package com.ancaiyun.entity;


import java.util.Date;

/*
* @Description 流程模板对象
* @Date 11:39 2018/5/28
* @Param 
* @return 
**/

public class ApprovalProcess {

    /**
     * 流程模板对象
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

    private String taskKey;      //模板实例Key
    private String taskName;     //模板说明
    private String taskPerson;   //模板任务
    private Integer taskLength;   //模板人数长度

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

    public Integer getTaskLength() {
        return taskLength;
    }

    public void setTaskLength(Integer taskLength) {
        this.taskLength = taskLength;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskPerson() {
        return taskPerson;
    }

    public void setTaskPerson(String taskPerson) {
        this.taskPerson = taskPerson;
    }


}
