package com.api.model.teaching.questions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 问答和 问答标签的 关联表
 *@author www.inxedu.com
 */

@Entity
public class QuestionsTagRelation implements Serializable{
	private static final long serialVersionUID = 7687324559966427231L;
	@Id
	@GeneratedValue
	private Long id;//id
	private Long questionsId;//问答id
	private Long questionsTagId;//问答标签id
	
	private String tagName;//问答标签名

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(Long questionsId) {
		this.questionsId = questionsId;
	}

	public Long getQuestionsTagId() {
		return questionsTagId;
	}

	public void setQuestionsTagId(Long questionsTagId) {
		this.questionsTagId = questionsTagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
}
