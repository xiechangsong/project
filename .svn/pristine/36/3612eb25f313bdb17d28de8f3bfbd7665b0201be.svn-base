package com.api.controller.system;


import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.system.subject.Subject;
import com.api.service.system.SubjectService;
import com.api.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HTTP Service
 * Created by 牛逼的小菜鸟 on 2017/6/28.
 * 专业管理
 */
@RestController
public class SubjectController {
    private Logger logger = Logger.getLogger(SubjectController.class);
    @Autowired
    private SubjectService subjectService;


    @RequestMapping(value = "/subject/addSubject", method = RequestMethod.POST)
    @ResponseBody
    public Result addSubject(Subject subject) {
        subjectService.addSubject(subject);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,subject);
    }

    @RequestMapping(value = "/subject/subjectList", method = RequestMethod.GET)
    @ResponseBody
    public Result subjectList() {
        List<Subject> subjecList = subjectService.subjectList();
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, subjecList);
    }
    @RequestMapping(value = "/subject/deleteSubject/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteSubject(@PathVariable("id") int id) {
        subjectService.deleteSubject(id);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    @RequestMapping(value = "/subject/updateSubject",method = RequestMethod.PUT)
    public Result updateSubject(Subject subject) {
        subjectService.updateSubject(subject);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    @RequestMapping( value = "/subject/findSubject/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result findSubject(@PathVariable("id") int id) {
        Subject subject = subjectService.findSubject(id);
        if(subject == null) {
            return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(),ResultEnum.RETURS_EMPTY.getMsg()+"，目标不存在");
        }
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,subject);
    }
}
