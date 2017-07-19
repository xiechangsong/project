package com.api.model.teaching.examination;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 组卷管理
 */
public class TestAssembly {
    private int id;
    private TestPaper testPaper;//试卷
    private int assemblyType;//题型
    private String shoeName;//显示名称（一般默认显示题型）
    private int singleScore;//单题分数
    private int questionsNumber;//试题数量
    private String assemblyDescribe;//组卷描述
    private Date adTime;//添加时间
    //试题集合
    private List<ExaminationQuestions> examinationQuestionsList = new ArrayList<ExaminationQuestions>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestPaper getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    public int getAssemblyType() {
        return assemblyType;
    }

    public void setAssemblyType(int assemblyType) {
        this.assemblyType = assemblyType;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public int getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(int singleScore) {
        this.singleScore = singleScore;
    }

    public int getQuestionsNumber() {
        return questionsNumber;
    }

    public void setQuestionsNumber(int questionsNumber) {
        this.questionsNumber = questionsNumber;
    }

    public String getAssemblyDescribe() {
        return assemblyDescribe;
    }

    public void setAssemblyDescribe(String assemblyDescribe) {
        this.assemblyDescribe = assemblyDescribe;
    }

    public Date getAdTime() {
        return adTime;
    }

    public void setAdTime(Date adTime) {
        this.adTime = adTime;
    }

    public List<ExaminationQuestions> getExaminationQuestionsList() {
        return examinationQuestionsList;
    }

    public void setExaminationQuestionsList(List<ExaminationQuestions> examinationQuestionsList) {
        this.examinationQuestionsList = examinationQuestionsList;
    }
}
