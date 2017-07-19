package com.api.model.teaching.course;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author www.inxedu.com
 *
 */

public class FavouriteCourseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String courseName; // 课程名字
	private int courseId; // 课程id
	private String logo;// 课程图片
	private int favouriteId; // 收藏课程id
	private Date addTime;//收藏时间
	private List<Map<String,Object>> teacherList;//该课程 下的老师list
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getFavouriteId() {
		return favouriteId;
	}
	public void setFavouriteId(int favouriteId) {
		this.favouriteId = favouriteId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public List<Map<String, Object>> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Map<String, Object>> teacherList) {
		this.teacherList = teacherList;
	}
	
	
}
