package com.api.model.teaching.kpoint;

/**
 * @author
 *
 */

public class CourseKpointDto extends CourseKpoint{
	private static final long serialVersionUID = -5911245722257969805L;
	private String teacherName;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
}
