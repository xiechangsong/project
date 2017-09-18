package com.api.model.teaching.system;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/4.
 */
@Entity
public class SysUserOperation {
    @Id
    @GeneratedValue
    private int id;
    /**操作用户*/
    private String name;
    /**操作类型*/
    private String type;
    /**操作描述*/
    private String operation;
    /**备注信息*/
    private String remarks;
    /**操作时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
    /**开始操作时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Transient
    private  Date beginTime;
    /**结束操作时间*/
    @Transient
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private  Date endTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
