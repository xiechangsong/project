package com.api.model.teaching.examination;

import com.api.model.system.subject.Subject;

import java.util.Date;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 试卷管理
 */
public class TestPaper {
    private int id;
    private String paperName;//试卷名称
    private Subject subject;//专业
    private int paperType;//试卷类型
    private String paperDescribe;
    private int answerTime;//答题时间
    private int totalScore;//总分
    private int difficulty;//难度
    private Date addTime;//添加时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getPaperType() {
        return paperType;
    }

    public void setPaperType(int paperType) {
        this.paperType = paperType;
    }

    public String getPaperDescribe() {
        return paperDescribe;
    }

    public void setPaperDescribe(String paperDescribe) {
        this.paperDescribe = paperDescribe;
    }

    public int getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(int answerTime) {
        this.answerTime = answerTime;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
