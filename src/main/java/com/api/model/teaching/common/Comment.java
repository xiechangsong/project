package com.api.model.teaching.common;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author www.inxedu.com
 *
 */

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Integer commentId;//评论Id
	private Integer userId;//用户id
	private Integer pCommentId;//父级评论id // 为0 则是一级评论 不为0则是评论的回复
	private String title;  //标题
	private String content;//评论内容
	private Date addTime;//发送时间
	private Integer otherId;//相关Id
	private Integer praiseCount;//点赞数
	private Integer replyCount;//回复数
	private Integer type;//类型 1 问答 2 评论 3 回复

	private String email;//用户Email
	private String userName;//用户昵称
	private String courseName;//课程名
	private Integer courseId;//课程id
	private String picImg;//用户头像
	private Integer commentNumber;//回复数
	private Integer limitNumber;//查询数
	@Transient
	private String order ="commentId";// commentId 降序  praiseCount 降序
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date beginCreateTime;//查询 开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endCreateTime;//查询 结束时间

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getpCommentId() {
		return pCommentId;
	}

	public void setpCommentId(Integer pCommentId) {
		this.pCommentId = pCommentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getOtherId() {
		return otherId;
	}

	public void setOtherId(Integer otherId) {
		this.otherId = otherId;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getPicImg() {
		return picImg;
	}

	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}

	public Integer getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}

	public Integer getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(Integer limitNumber) {
		this.limitNumber = limitNumber;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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
