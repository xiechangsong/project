package com.api.model.teaching.questions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 问答评论
 *
 */

@Entity
public class QuestionsComment implements Serializable {
	private static final long serialVersionUID = 7687324559966427231L;
	@Id
	@GeneratedValue
    private Long id;// 主键自增
    private Long cusId;// 评论人id
    private Long questionId;// 问答id
    private String content;// 内容
    private int isBest;// 是否为最佳答案 0否1是
    private int replyCount;// 回复数量
    private int praiseCount;// 点赞数
    private Date addTime;// 添加时间
    private Long commentId;//父级评论id
    
    private int limitSize;//查询限制条数
    private String orderFlag;//排序值 new 最新
    private String showName;//用户名
    private String email;//用户邮箱
    private String picImg;//用户头像
	@Transient
    private List<QuestionsComment> questionsCommentList;//子评论列表
    private String questionsTitle;//问答标题
    private int questionsStatus;//问答状态  0可回复1不可回复（采纳最佳答案后改为1 ）
    private Date beginCreateTime;//查询 开始添加时间
    private Date endCreateTime;//查询 结束添加时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCusId() {
		return cusId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public int getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public int getLimitSize() {
		return limitSize;
	}
	public void setLimitSize(int limitSize) {
		this.limitSize = limitSize;
	}
	public String getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicImg() {
		return picImg;
	}
	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}
	public List<QuestionsComment> getQuestionsCommentList() {
		return questionsCommentList;
	}
	public void setQuestionsCommentList(List<QuestionsComment> questionsCommentList) {
		this.questionsCommentList = questionsCommentList;
	}
	public String getQuestionsTitle() {
		return questionsTitle;
	}
	public void setQuestionsTitle(String questionsTitle) {
		this.questionsTitle = questionsTitle;
	}
	public int getQuestionsStatus() {
		return questionsStatus;
	}
	public void setQuestionsStatus(int questionsStatus) {
		this.questionsStatus = questionsStatus;
	}
	public Date getBeginCreateTime() {
		return beginCreateTime;
	}
	public void setBeginCreateTime(Date beginCreateTime) {
		this.beginCreateTime = beginCreateTime;
	}
	public Date getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
    
    
}
