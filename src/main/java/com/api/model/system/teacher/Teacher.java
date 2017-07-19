package com.api.model.system.teacher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 讲师实体
 * @author www.inxedu.com
 */

@Entity
public class Teacher implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 838162101564081713L;
	@Id
	@GeneratedValue
    private int id;// 主键自增
    private String realName;// 讲师名称
    private String profile;// 讲师简介
    private String picPath;// 头像
    private int status;// 状态:0正常1删除
    private Date createTime;// 创建时间
    private int sort;//排序
	private int userId;//关联用户id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
