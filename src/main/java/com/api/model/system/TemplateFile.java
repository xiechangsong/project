package com.api.model.system;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/10.
 * 模板文件
 */
public class TemplateFile implements Serializable{

    private int id;
    private String fileAddress;//文件地址
    private String fileName;//文件名称
    private String profile;//简介
    private Date addTime;//添加时间
    private int type;//类型 0 批量创建学员用户模板
    private int status;//状态 0正常 1异常
    private String context;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
