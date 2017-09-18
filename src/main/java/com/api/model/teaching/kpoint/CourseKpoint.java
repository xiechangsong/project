package com.api.model.teaching.kpoint;

import com.api.model.teaching.examination.TestPaper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 牛逼的小菜鸟
 * 课程章节
 *
 */

@Entity
public class CourseKpoint implements Serializable{
    private static final long serialVersionUID = -2252970709827434582L;
    @Id
	@GeneratedValue
    /**视频节点ID*/
    private int kpointId;
    private int courseId;
    /**名称*/
    private String name;
    /**视频父节点*/
    private int parentId;
    /**创建时间*/
    private Date addTime;
    /**排序*/
    private int sort;
    /**视频路径*/
    private String videoUrl;
    /**教师ID*/
    private int teacherId;
    /**节点类型 0文件目录 1视频*/
    private int kpointTypes;
    /** 视频类型 */
    private String videoType;
    /**节点list*/
    private String fileType;//节点文件格式
    private String content;//文本内容

	private int paperId;//试卷id
	@Transient
	private TestPaper testPaper;
	@Transient
	private String paperName;//试卷名称
	private int testType;//试卷类型

	public int getKpointId() {
		return kpointId;
	}
	public void setKpointId(int kpointId) {
		this.kpointId = kpointId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
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
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getKpointTypes() {
		return kpointTypes;
	}
	public void setKpointTypes(int kpointTypes) {
		this.kpointTypes = kpointTypes;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public int getTestType() {
		return testType;
	}

	public void setTestType(int testType) {
		this.testType = testType;
	}
}
