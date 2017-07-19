package com.api.service.teacher;

import com.api.mapper.teacher.ExaminationQuestionsMapper;
import com.api.model.teaching.examination.ExaminationQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 */
@Service
public class ExaminationQuestionsService {
    @Autowired
    private ExaminationQuestionsMapper examinationQuestionsMapper;

    /***添加试题*/
    public void addExaminationQuestions (ExaminationQuestions examinationQuestions,String[] answer) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<answer.length;i++) {
            sb.append(answer[i]);
            if(i != answer.length - 1) {
                sb.append(",");
            }
        }
        examinationQuestions.setQuestionsOption(sb.toString());
        examinationQuestions.setAddTime(new Date());
        examinationQuestionsMapper.addExaminationQuestions(examinationQuestions);
    }

    /**遍历所有试题 包含动态条件搜索*/
    public List<ExaminationQuestions> searchExaminationQuestionsList (ExaminationQuestions examinationQuestions) {
        List<ExaminationQuestions> searchExaminationQuestionsList =
                examinationQuestionsMapper.searchExaminationQuestionsList(examinationQuestions);
        return searchExaminationQuestionsList;
    }

    /**删除试题（可单独删除也可批量删除）*/

   public void deleteExaminationQuestions (List<Integer> idList) {
       examinationQuestionsMapper.deleteExaminationQuestions(idList);
    }
}
