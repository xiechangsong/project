package com.api.controller.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.course.CourseNote;
import com.api.service.teacher.CourseNoteService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * HTTP Service
 * Created by 牛逼的小菜鸟 on 2017/7/3.
 * 课程管理
 * @RestController 返回restful格式
 */
@RestController
public class CourseNoteController {
    @Autowired
    private CourseNoteService courseNoteService;

    /**
     * 添加笔记
     * @param courseNote
     * @return
     */
    @RequestMapping(value = "/courseNote/addCourseNote", method = RequestMethod.POST)
    public Result addCourseNote(CourseNote courseNote) {

        courseNoteService.addCourseNote(courseNote);

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,courseNote);
    }

    /**
     * 查询笔记，返回分页
     * @param courseNote
     * @param pageNum
     * @param pageSize
     * @return
     */
        @RequestMapping( value = "/courseNote/selectCourseNoteList" ,method = RequestMethod.POST)
        @ResponseBody
        public Result selectCourseNoteList(CourseNote courseNote,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

            PageHelper.startPage(pageNum, pageSize);//分页
            List<CourseNote> list= courseNoteService.selectCourseNoteList(courseNote);
            Page<CourseNote> listCountry = (Page<CourseNote>)list;
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS,listCountry,listCountry.getTotal(),
                    listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }


    /**
     * 修改笔记
     * @param courseNote
     * @return
     */
    @RequestMapping(value = "/courseNote/updateCourseNote",method = RequestMethod.POST)
    @ResponseBody
    public Result updateCourseNote(CourseNote courseNote) {
        courseNote.setUpdateTime(new Date());
        courseNoteService.updateCourseNote(courseNote);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 删除笔记
     * @param examId
     * @return
     */
    @RequestMapping(value = "/courseNote/deleteCourseNote",method = RequestMethod.POST)
    public Result deleteCourseNote(@RequestParam(value = "examId",required = true) String examId ) {
        //examId="[ { \"examId\": 1 }]";
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
        courseNoteService.deleteCourseNote(list);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }




}
