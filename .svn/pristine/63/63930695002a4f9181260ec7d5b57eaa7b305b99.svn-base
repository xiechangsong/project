package com.api.model.teaching.article;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 文章内容
 * @author www.inxedu.com
 */
@Entity
public class ArticleContent implements Serializable{

	private static final long serialVersionUID = 1L;
	/**文章ID*/
	@Id
	@GeneratedValue
	private int articleId;
	/**文章对应的内容*/
	private String content;
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
