package com.api.model.teaching.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 后台系统用户实体
 * @author www.inxedu.com
 */



@Entity
public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**用户ID*/
	@Id
	@GeneratedValue
	private int userId;
	/**用户登录名*/
	private String loginName;
	/**密码*/
	private String loginPwd;
	/**用户真名*/
	private String userName;
	/**用户状态 0正常 1冻结 2删除*/
	private int status;
	/**最后登录时间*/
	private Date lastLoginTime;
	/**最后登录IP号*/
	private String lastLoginIp;
	/**用户创建时间*/
	private Date createTime;
	/**邮箱*/
	private String email;
	/**手机号*/
	private String tel;
	/**角色ID*/
	private int roleId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	

}
