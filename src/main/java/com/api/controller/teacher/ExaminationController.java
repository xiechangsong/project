package com.api.controller.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.examination.ExaminationQuestions;
import com.api.service.teacher.ExaminationQuestionsService;
import com.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 考试管理
 */
@RestController
public class ExaminationController {
    @Autowired
    private ExaminationQuestionsService examinationQuestionsService;

    /**
     * 添加试题
     * @param examinationQuestions
     * @return
     */
    @RequestMapping (value = "/examination/addExaminationQuestions", method = RequestMethod.POST)
    @ResponseBody
    public Result addExaminationQuestions (ExaminationQuestions examinationQuestions, @RequestParam("answer") String[] answer) {
        examinationQuestionsService.addExaminationQuestions(examinationQuestions,answer);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,examinationQuestions);
    }

    /**
     * 遍历题库
     * @param examinationQuestions 动态条件
     * @return
     */
    @RequestMapping (value = "/examination/searchExaminationQuestionsList", method = RequestMethod.GET)
    @ResponseBody
    public Result searchExaminationQuestionsList (ExaminationQuestions examinationQuestions) {
        List<ExaminationQuestions> searchExaminationQuestionsList =
                examinationQuestionsService.searchExaminationQuestionsList(examinationQuestions);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,searchExaminationQuestionsList);
    }

    /**
     * 删除试题（提供批量删除和单条删除）
     * @return
     */
    @RequestMapping (value = "/examination/deleteExaminationQuestions", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteExaminationQuestions (@RequestParam(value = "examId",required = true) String examId ) {
        JSONArray jsonArray =JSONArray.parseArray(examId);
        List<Integer> list = new ArrayList<Integer>();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            Integer id=jUser.getInteger("examId");
            list.add(id);
        }
        examinationQuestionsService.deleteExaminationQuestions(list);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
}
