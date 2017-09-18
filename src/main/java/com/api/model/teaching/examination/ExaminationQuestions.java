package com.api.model.teaching.examination;

import com.api.model.system.subject.Subject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 试题库
 */
public class ExaminationQuestions implements Serializable{

    private int id;
    private Integer questionsType;//试题类型
    private Integer questionsClassify;//试题分类
    private Integer subjectId;//专业id
    private Subject subject;//专业
    private Integer difficulty;//难度 0：简单 1：普通 2：困难
    private String questionsTitle; //试题标题
    private String questionsOption;//试题答案（不同体型此处显示不一样）
    private String correct;//正确答案
    private String answerAnalysis;//答案分析
    private Date addTime;//添加时间
    private Integer status;//状态 0：正常使用 1：逻辑删除

    public String getQuestionsType(int questionsType) {
        if( questionsType ==0 ) {
            return "简单";
        }else if( questionsType ==1 ) {
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

    public Integer getQuestionsType() {
        return questionsType;
    }

    public void setQuestionsType(Integer questionsType) {
        this.questionsType = questionsType;
    }

    public Integer getQuestionsClassify() {
        return questionsClassify;
    }

    public void setQuestionsClassify(Integer questionsClassify) {
        this.questionsClassify = questionsClassify;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestionsTitle() {
        return questionsTitle;
    }

    public void setQuestionsTitle(String questionsTitle) {
        this.questionsTitle = questionsTitle;
    }

    public String getQuestionsOption() {
        return questionsOption;
    }

    public void setQuestionsOption(String questionsOption) {
        this.questionsOption = questionsOption;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getAnswerAnalysis() {
        return answerAnalysis;
    }

    public void setAnswerAnalysis(String answerAnalysis) {
        this.answerAnalysis = answerAnalysis;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
