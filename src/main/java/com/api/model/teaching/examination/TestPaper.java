package com.api.model.teaching.examination;

import com.api.model.system.subject.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 试卷管理
 */
public class TestPaper {
    private int id;
    private String paperName;//试卷名称
    private int subjectId;//专业id
    private Subject subject;//专业
    private Integer paperType;//试卷类型
    private String paperDescribe;
    private int answerTime;//答题时间
    private int totalScore;//总分
    private Integer difficulty;//难度
    private Date addTime;//添加时间
    private String testSet;//试题存放字段id以“1,2,3,4,”格式存放于数据库中
    private Integer status;//状态 0：正常使用  1：逻辑删除
    private List<ExaminationQuestions> examinationQuestionsList = new ArrayList<ExaminationQuestions>();

    public String getPaperType_() {
        if (paperType ==0 ){
            return "章节测验";
        }
        return "结课检测";
    }

    public String getDifficulty_() {
        if (difficulty == 0 ) {
            return "简单";
        }
        if (difficulty == 1 ) {
            return "入门";
        }
        return "困难";
    }

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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
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

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getTestSet() {
        return testSet;
    }

    public void setTestSet(String testSet) {
        this.testSet = testSet;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ExaminationQuestions> getExaminationQuestionsList() {
        return examinationQuestionsList;
    }

    public void setExaminationQuestionsList(List<ExaminationQuestions> examinationQuestionsList) {
        this.examinationQuestionsList = examinationQuestionsList;
    }
}
