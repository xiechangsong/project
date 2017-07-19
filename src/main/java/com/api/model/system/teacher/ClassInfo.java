package com.api.model.system.teacher;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/1.
 * 班级信息表
 */
@Entity
public class ClassInfo implements Serializable{


    @Id
    @GeneratedValue
    private int classId;
    /** 班级名称*/
    private String className;
    /** 创建时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /** 预设人数*/
    private int presetNumber;
    /** 班级简介*/
    private String profile;
    /** 班级状态  0=正常  1=已结束*/
    private int status;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPresetNumber() {
        return presetNumber;
    }

    public void setPresetNumber(int presetNumber) {
        this.presetNumber = presetNumber;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
