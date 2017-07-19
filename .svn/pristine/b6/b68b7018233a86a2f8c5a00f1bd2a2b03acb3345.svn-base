package com.api.model.teaching.article;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 文章资讯
 * @author www.inxedu.com
 */
@Entity
public class Article implements Serializable{
	private static final long serialVersionUID = -760228884438140694L;
	/**文章ID*/
	@Id
	@GeneratedValue
	private int articleId;
	/**文章标题*/
	private String title;
	/**文章摘要*/
	private String summary;//
	/**文章关键字*/
	private String keyWord;
	/**文章图片URL*/
	private String imageUrl;
	/**文章来源*/
	private String source;
	/**文章作者*/
	private String author;
	/**创建时间*/
	private Date createTime;
	/**发布时间 */
	private Date publishTime;
	/**文章类型*/
	private int type;
	/**文章点击量*/
	private int clickNum;
	/**文章点赞量*/
	private int praiseCount;
	/** 排序值 */
	private int sort;
	
	/**文章评论数*/
	private int commentNum;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	public int getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
}
