package com.api.model.teaching.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author www.inxedu.com
 *
 */


@Entity
public class CourseFavorites implements Serializable{
	private static final long serialVersionUID = 5055812991457774890L;
	@Id
	@GeneratedValue
	private int id;
    private int courseId;
    private int userId;
    private Date addTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
    
}
