package com.api.controller.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.course.CourseStudyhistory;
import com.api.service.teacher.CourseStudyhistoryService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@RestController
public class CourseStudyhistoryController {

    @Autowired
    private CourseStudyhistoryService courseStudyhistoryService;



    /**
     * 添加观看记录
     * @param courseStudyhistory
     * @return
     */
    @RequestMapping(value = "/courseStudyhistory/addCourseStudyhistory", method = RequestMethod.POST)
    @ResponseBody
    public Result addCourseStudyhistory(CourseStudyhistory courseStudyhistory) {
        courseStudyhistoryService.addCourseStudyhistory(courseStudyhistory);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 查询评论观看记录
     * @param courseStudyhistory
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/courseStudyhistory/selectCourseStudyhistory", method = RequestMethod.POST)
    @ResponseBody
    public Result selectCourseStudyhistory(CourseStudyhistory courseStudyhistory, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);//分页
        List<CourseStudyhistory>  list =  courseStudyhistoryService.selectCourseStudyhistory(courseStudyhistory);
        Page<CourseStudyhistory> listCountry = (Page<CourseStudyhistory>)list;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }


    /**
     *删除
     * @return
     */
    @RequestMapping(value = "/courseStudyhistory/deleteCourseStudyhistory", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCourseStudyhistory(@RequestParam(value = "examId",required = true) String examId ) {
        //examId="[ { \"examId\": \"32\" }, { \"examId\": \"31\"}]";
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
        courseStudyhistoryService.deleteCourseStudyhistory(list);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }



}
