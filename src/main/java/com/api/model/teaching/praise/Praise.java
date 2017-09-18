package com.api.model.teaching.praise;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 点赞表
 *@author www.inxedu.com
 */

@Entity
public class Praise  implements Serializable{
	private static final long serialVersionUID = 7687324559966427231L;
	@Id
	@GeneratedValue
	private int id;//id
	private int userId;//用户id
	private int targetId;//点赞的目标id
	private int type;//点赞类型 1问答点赞 2问答评论点赞
	private Date addTime;//点赞和点踩的时间
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
