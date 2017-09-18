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

    /**
     * 将客户端传过来的答案组成特定的格式
     * @param answer
     * @return
     */
    public String splitAnswer (String[] answer){
        if ( answer.length > 0 ) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<answer.length;i++) {
                sb.append(answer[i]);
                if(i != answer.length - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return null;
    }

    /***添加试题*/
    public void addExaminationQuestions (ExaminationQuestions examinationQuestions,String answer) {

        examinationQuestions.setQuestionsOption(answer);
        examinationQuestions.setAddTime(new Date());
        examinationQuestions.setStatus(0);
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
   /**修改*/
   public void updateExaminationQuestions(ExaminationQuestions examinationQuestions,String answer) {

       examinationQuestions.setQuestionsOption(answer);
       examinationQuestionsMapper.updateExaminationQuestions(examinationQuestions);
    }
}
