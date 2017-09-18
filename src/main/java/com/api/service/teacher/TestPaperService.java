package com.api.service.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.mapper.teacher.ExaminationQuestionsMapper;
import com.api.mapper.teacher.TestPaperMapper;
import com.api.mapper.teacher.TestScoreMapper;
import com.api.model.common.Result;
import com.api.model.teaching.examination.ExaminationQuestions;
import com.api.model.teaching.examination.TestPaper;
import com.api.model.teaching.examination.TestScore;
import com.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 */
@Service
public class TestPaperService {
    @Autowired
    private TestPaperMapper testPaperMapper;
    @Autowired
    private ExaminationQuestionsMapper examinationQuestionsMapper;
    @Autowired
    private TestScoreMapper testScoreMapper;

    /***添加试题*/
    public void addTestPaper (TestPaper testPaper) {
        testPaper.setAddTime(new Date());
       testPaperMapper.addTestPaper(testPaper);
    }

    /**遍历所有试题 包含动态条件搜索*/
    public List<TestPaper> searchTestPaperList (TestPaper testPaper) {
        List<TestPaper> searchTestPaperList = testPaperMapper.searchTestPaperList(testPaper);
        return searchTestPaperList;
    }

    /**删除试题（可单独删除也可批量删除）*/

   public void deleteTestPaper (List<Integer> idList) {
       testPaperMapper.deleteTestPaper(idList);
   }
   /**修改*/
   public void updateTestPaper(TestPaper testPaper) {

       testPaperMapper.updateTestPaper(testPaper);
    }

    /**试卷添加试题*/
    public void testpaperAddingQuestions (TestPaper testPaper) {
        testPaperMapper.testpaperAddingQuestions( testPaper );
    }

    /***
     * 展示试卷
     * @param id 试卷id
     * @return
     */
    public TestPaper searchTestPaper (Integer id) {
        TestPaper testPaper = testPaperMapper.searchTestPaper(id);
        List<Integer> integerList = new ArrayList<Integer>();
        if(null != testPaper.getTestSet()){
            String [] str = testPaper.getTestSet().split(",");
            for (int i=0;i<str.length;i++) {
                Integer examId=Integer.parseInt(str[i]);
                integerList.add(examId);
            }
            List<ExaminationQuestions> examinationQuestionsList = examinationQuestionsMapper.getExaminationQuestions(integerList);
            testPaper.setExaminationQuestionsList(examinationQuestionsList);
        }
        return testPaper;
    }

    /**
     * 阅卷
     * @param paperId 试卷id
     * @param result 答案
     * @param userId 考试用户
     * @return
     */
    public Result marking (Integer paperId,String result,Integer userId) {
        /*将正确答案保存在集合当中，方便后面与学生答案进行比对*/
        TestPaper testPaper = testPaperMapper.searchTestPaper(paperId);
        String [] str = testPaper.getTestSet().split(",");
        double singleScore = testPaper.getTotalScore() / str.length;//单题分数
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i=0;i<str.length;i++) {
            Integer examId=Integer.parseInt(str[i]);
            integerList.add(examId);
        }
        List<String> correctList = new ArrayList<String>();//正确答案（数据库）
        List<ExaminationQuestions> examinationQuestionsList = examinationQuestionsMapper.getExaminationQuestions(integerList);
        for (ExaminationQuestions examinationQuestions : examinationQuestionsList) {
            correctList.add(examinationQuestions.getCorrect());
        }
        //开始将学生的答案报存在一个集合当中
        List<String> userAnswer = new ArrayList<String>();//学生答案
        JSONArray jsonArray =JSONArray.parseArray(result);
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.ERROR.getCode(),"考生没有作答，本次考试结果不计入系统");
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            userAnswer.add(jUser.getString("answer"));
        }
        double sum=0;
        for (int i=0;i<correctList.size();i++) {
            if(correctList.get(i).toString().equalsIgnoreCase(userAnswer.get(i).toString())) {
                sum += singleScore;
            }
        }
        TestScore testScore=new TestScore();
        testScore.setPaperId(paperId);
        testScore.setUserId(userId);
        testScore.setScore(sum);
        testScore.setTestTime(new Date());
        testScore.setAnswer(correctList.toString());
        testScore.setUserAnswer(userAnswer.toString());
        testScoreMapper.addTestScore(testScore);//考试成绩入库

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,sum);
    }
}