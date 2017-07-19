package com.api.mapper.teacher;

import com.api.model.teaching.examination.ExaminationQuestions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 试题接口
 */
@Service
public interface ExaminationQuestionsMapper {

    /**添加试题*/
    void addExaminationQuestions(ExaminationQuestions examinationQuestions);

    /**遍历所有试题 包含动态条件搜索*/
    List<ExaminationQuestions> searchExaminationQuestionsList (ExaminationQuestions examinationQuestions);

    /**删除试题（可单独删除也可批量删除）*/
    void deleteExaminationQuestions (List<Integer> idList);
}
