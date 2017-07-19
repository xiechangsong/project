package com.api.model.teaching.course;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 牛逼的小菜鸟
 * 课程表
 *
 */

@Entity
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int courseId;
    private String courseName;//课程名称
    private int subjectId;//课程专业ID
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addTime;//课程添加时间
    private String title;//课程简介
    private String context;//课程详情
    private int lessionNum;//课时
	private int sequence;//排序
	@Transient
	private String subjectName;
	@Transient
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;//结束时间
	private int isRecommend;//是否加入推荐

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getLessionNum() {
		return lessionNum;
	}

	public void setLessionNum(int lessionNum) {
		this.lessionNum = lessionNum;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}
}
