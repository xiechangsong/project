package com.api.model.teaching.course;


import com.api.utils.DateUtils;
import com.api.utils.ObjectUtils;
import com.api.utils.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @description 记录播放记录
 *
 */

@Entity
public class CourseStudyhistory implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 5434482371608343070L;
	@Id
	@GeneratedValue
    private Long id;
    private Long userId;//用户ID
    private Long courseId;//课程ID
    private Long kpointId;//节点ID
    private Long playercount;//播放次数
    private String courseName;//课程名称
    private String kpointName;//节点名称
    private String databack;//playercount小于20时记录,备注观看的时间，叠加
    private Date updateTime;//更新时间
    private String logo;	//图片
    private String teacherName;	//教师名称
    
    private String userShowName;//用户名
    private String userEmail;//用户邮箱
    private String userImg;//用户头像

    //辅助字段
    private int queryLimit;//查询 的个数
    private String picImg;//用户头像
    private String showName;//用户昵称
    private String updateTimeFormat;//时间 格式化显示

    public void setUpdateTime(Date date){
        this.updateTime=date;
        this.updateTimeFormat= StringUtils.getModelDate(this.getUpdateTime());
    }
	public static String getModelDate(Date oldDate) {
		if (ObjectUtils.isNotNull(oldDate)) {
			Date newDate = new Date();
			long second = (newDate.getTime() - oldDate.getTime()) / 1000L;
			if (second <= 60L)
				return new StringBuilder().append(second).append("秒前").toString();
			if ((60L < second) && (second <= 3600L)) {
				second /= 60L;
				return new StringBuilder().append(second).append("分钟前").toString();
			}if ((3600L < second) && (second <= 86400L)) {
				second = second / 60L / 60L;
				return new StringBuilder().append(second).append("小时前").toString();
			}if ((86400L < second) && (second <= 864000L)) {
				String formatDate = DateUtils.formatDate(oldDate, "HH:mm:ss");
				second = second / 60L / 60L / 24L;
				return new StringBuilder().append(second).append("天前 ").append(formatDate).toString();
			}
			return DateUtils.formatDate(oldDate, "yyyy-MM-dd HH:mm:ss");
		}

		return "";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getKpointId() {
		return kpointId;
	}

	public void setKpointId(Long kpointId) {
		this.kpointId = kpointId;
	}

	public Long getPlayercount() {
		return playercount;
	}

	public void setPlayercount(Long playercount) {
		this.playercount = playercount;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getKpointName() {
		return kpointName;
	}

	public void setKpointName(String kpointName) {
		this.kpointName = kpointName;
	}

	public String getDataback() {
		return databack;
	}

	public void setDataback(String databack) {
		this.databack = databack;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getUserShowName() {
		return userShowName;
	}

	public void setUserShowName(String userShowName) {
		this.userShowName = userShowName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public int getQueryLimit() {
		return queryLimit;
	}

	public void setQueryLimit(int queryLimit) {
		this.queryLimit = queryLimit;
	}

	public String getPicImg() {
		return picImg;
	}

	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getUpdateTimeFormat() {
		return updateTimeFormat;
	}

	public void setUpdateTimeFormat(String updateTimeFormat) {
		this.updateTimeFormat = updateTimeFormat;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
    
}
