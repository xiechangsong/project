package com.api.service.teacher;

import com.api.mapper.teacher.ExaminationQuestionsMapper;
import com.api.mapper.teacher.TestPaperMapper;
import com.api.mapper.teacher.TestScoreMapper;
import com.api.model.teaching.examination.ExaminationQuestions;
import com.api.model.teaching.examination.TestPaper;
import com.api.model.teaching.examination.TestScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/26.
 */
@Service
public class TestScoreService {

    @Autowired
    private TestScoreMapper testScoreMapper;
    @Autowired
    private TestPaperMapper testPaperMapper;
    @Autowired
    private ExaminationQuestionsMapper examinationQuestionsMapper;

    public List<TestScore> searchTestScoreList(TestScore testScore) {
        List<TestScore> testScoreList = testScoreMapper.searchTestScoreList(testScore);
        for (TestScore testScore1 : testScoreList) {
            List<Integer> integerList = new ArrayList<Integer>();
            TestPaper testPaper = testPaperMapper.searchTestPaper(testScore1.getPaperId());
            String [] str = testPaper.getTestSet().split(",");
            for (int i=0;i<str.length;i++) {
                Integer examId=Integer.parseInt(str[i]);
                integerList.add(examId);
            }
            List<ExaminationQuestions> examinationQuestionsList = examinationQuestionsMapper.getExaminationQuestions(integerList);
            testPaper.setExaminationQuestionsList(examinationQuestionsList);
            testScore1.setTestPaper(testPaper);
        }

        return testScoreList;
    }
}
