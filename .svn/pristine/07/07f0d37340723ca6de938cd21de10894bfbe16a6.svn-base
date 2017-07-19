package com.api.model.teaching.questions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 问答标签
 *@author www.inxedu.com
 */

@Entity
public class QuestionsTag implements Serializable {
    private static final long serialVersionUID = -1912600357482790771L;
	@Id
	@GeneratedValue
    private int questionsTagId; // 专业id
    private String questionsTagName;// 专业名称
    private int status;// 状态
    private Date createTime;// 创建时间
    private int parentId;// 父节点
	public int getQuestionsTagId() {
		return questionsTagId;
	}
	public void setQuestionsTagId(int questionsTagId) {
		this.questionsTagId = questionsTagId;
	}
	public String getQuestionsTagName() {
		return questionsTagName;
	}
	public void setQuestionsTagName(String questionsTagName) {
		this.questionsTagName = questionsTagName;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
    
}
