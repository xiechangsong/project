package com.api.model.user;


import com.api.utils.SHAencrypt;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by zl on 2015/8/27.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    /** 用户名*/
    @NotNull( message = "userName必传")
    private String userName;
    /** 密码*/
    @NotNull( message = "passWord必传")
    private String passWord;
    /** 姓名*/
    private String realName;
    /** 头像*/
    private String pic_path;
    /** 性别*/
    private String sex;
    /** 添加时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    /** 邮箱*/
    private String email;
    /** 联系电话*/
    private String phone;
    /** 昵称*/
    private String nickName;
    /** 年龄*/
    private int age;
    /** 状态 0=正常 1冻结*/
    private Integer status;
    /** 用户类型 0=管理员 1=教师 2=普通学员*/
    private int userType;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Transient
    private Date endTime;//结束时间
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {

        this.passWord = passWord;
    }
    /**
     * 设置密码
     *
     * @param password 密码
     * @param original 是否为原始明文密码，如果为true，则内部会对其进行加密处理
     */
    public void setPassWord(String password, boolean original) throws Exception{
        if (original) {
            password = SHAencrypt.encryptSHA(password);
        }
        this.passWord = password;
    }
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
