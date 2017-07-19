package com.api.model.teaching.kpoint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author www.inxedu.com
 *课程目录
 */

@Entity
public class CourseCatalog implements Serializable{
    private static final long serialVersionUID = -2252970709827434582L;
    @Id
	@GeneratedValue
    /**视频节点ID*/
    private int catalogId;
    /**课程ID*/
    private int courseId;
    /**名称*/
    private String catalogName;
    /**创建时间*/
    private Date addTime;
    /**排序*/
    private int sort;
	/**节点类型 0文件目录 1视频*/
	private int kpointType;
    //目录下包含章节
	@Transient
	private List<CourseKpoint> courseKpointList = new ArrayList<CourseKpoint>();
	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<CourseKpoint> getCourseKpointList() {
		return courseKpointList;
	}

	public void setCourseKpointList(List<CourseKpoint> courseKpointList) {
		this.courseKpointList = courseKpointList;
	}

	public int getKpointType() {
		return kpointType;
	}

	public void setKpointType(int kpointType) {
		this.kpointType = kpointType;
	}
}
