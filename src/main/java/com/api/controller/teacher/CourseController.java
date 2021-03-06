package com.api.controller.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.course.Course;
import com.api.model.teaching.course.JoinRecommendCourseList;
import com.api.model.teaching.kpoint.CourseCatalog;
import com.api.model.teaching.kpoint.CourseKpoint;
import com.api.service.teacher.CourseCatalogService;
import com.api.service.teacher.CourseKpointService;
import com.api.service.teacher.CourseService;
import com.api.utils.Common;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseKpointService courseKpointService;
    @Autowired
    private CourseCatalogService courseCatalogService;

    @RequestMapping(value = "/course/addCourse", method = RequestMethod.POST)
    @ResponseBody
    public Result addCourse(Course course) {

        courseService.addCourse(course);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,course);
    }



    @RequestMapping(value = "/course/addCourseKpoint", method = RequestMethod.POST)
    @ResponseBody
    public Result addCourseKpoint(CourseKpoint courseKpoint) {
        if( courseKpoint.getKpointTypes() == 0 ) {//目录
            CourseCatalog courseCatalog=new CourseCatalog();
            courseCatalog.setCourseId(courseKpoint.getCourseId());
            courseCatalog.setSort(courseKpoint.getSort());
            courseCatalog.setCatalogName(courseKpoint.getName());
            courseCatalogService.addCourseKpoint(courseCatalog);
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS,courseCatalog);
        } else {
            courseKpointService.addCourseKpoint(courseKpoint);
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS,courseKpoint);
        }

    }

    /***
     * 查询单个课程下所有目录（包含章节列表）
     * @param id 课程id
     * @return
     */
        @RequestMapping( value = "/course/findCourseKpoint/{courseId}",method = RequestMethod.GET)
        @ResponseBody
        public Result findCourseKpoint(@PathVariable("courseId") int id) {
        List<CourseCatalog> courseCatalogs= courseCatalogService.findCourseCatalog(id);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,courseCatalogs);
    }
    /***
     * 查询课程章节
     * @param id 章节id
     * @return
     */
    @RequestMapping( value = "/course/courseKpoints/{kpointId}",method = RequestMethod.GET)
    @ResponseBody
    public Result courseKpoints(@PathVariable("kpointId") int id) {
        CourseKpoint courseKpoint = courseKpointService.courseKpoints(id);
        if(courseKpoint == null) {
            return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(),ResultEnum.RETURS_EMPTY.getMsg()+"，目标不存在");
        }
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,courseKpoint);
    }
    /***
     * 查询单个目录下章节列表
     * @param id 目录id
     * @return
     */
    @RequestMapping( value = "/course/findCourseKpointList/{catalogId}",method = RequestMethod.GET)
    @ResponseBody
    public Result findCourseKpointList(@PathVariable("catalogId") int id) {

        List<CourseKpoint> courseKpoint = courseKpointService.findCourseKpoint(id);
        if(courseKpoint == null) {
            return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(),ResultEnum.RETURS_EMPTY.getMsg()+"，目录下不存在章节");
        }
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,courseKpoint);
    }
    //单个目录信息
   @RequestMapping (value = "/course/findCatalog/{catalogId}", method = RequestMethod.GET)
   @ResponseBody
    public Result findCatalog (@PathVariable ("catalogId") int catalogId) {
        CourseCatalog courseCatalog = courseCatalogService.findCatalog(catalogId);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,courseCatalog);
    }

    /**
     * 课程列表
     * @param courseId
     * @param courseName
     * @param subjectId
     * @param addTime
     * @param endTime
     * @param course
     * @param pageNum
     * @param pageSize
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/course/courseList", method = RequestMethod.GET)
    @ResponseBody
    public Result courseList(@RequestParam(value = "courseId",required = false) Integer courseId,
                            @RequestParam(value = "courseName",required = false) String courseName,
                            @RequestParam(value = "subjectId",required = false) Integer subjectId,
                            @RequestParam(value = "addTime",required = false)String addTime,
                            @RequestParam(value = "endTime",required = false)String endTime,Course course,
                             @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws ParseException {
        if (courseId != null) {
            course.setCourseId(courseId);
        }if (courseName != null) {
           course.setCourseName(courseName);
        }if (subjectId != null) {
            course.setSubjectId(subjectId);
        }if (addTime != null) {
            Date ctime = Common.FMT_DATE_1.parse(addTime);
            course.setAddTime(ctime);
        }if (endTime != null) {
            Date etime = Common.FMT_DATE_1.parse(endTime);
            course.setEndTime(etime);
        }
        PageHelper.startPage(pageNum, pageSize);//分页
        List<Course> courseList = courseService.courseList(course);
        Page<Course> listCountry = (Page<Course>)courseList;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }

    /**
     * 未推荐列表
     * @param courseId 课程id
     * @param courseName 课程名称
     * @param subjectId 专业id
     * @param course
     * @param pageNum 分页参数
     * @param pageSize
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/course/notRecommendedList", method = RequestMethod.GET)
    @ResponseBody
    public Result notRecommendedList(@RequestParam(value = "courseId",required = false) Integer courseId,
                             @RequestParam(value = "courseName",required = false) String courseName,
                             @RequestParam(value = "subjectId",required = false) Integer subjectId,Course course,
                             @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws ParseException {
        if (courseId != null) {
            course.setCourseId(courseId);
        }if (courseName != null) {
            course.setCourseName(courseName);
        }if (subjectId != null) {
            course.setSubjectId(subjectId);
        }
        PageHelper.startPage(pageNum, pageSize);//分页
        List<Course> courseList = courseService.notRecommendedList(course);
        Page<Course> listCountry = (Page<Course>)courseList;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }

    @RequestMapping(value = "/course/deleteCourse/{courseId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteCourse(@PathVariable("courseId") int courseId) {
        courseService.deleteCourse(courseId);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    @RequestMapping(value = "/course/updateCourse",method = RequestMethod.PUT)
    public Result updateCourse(Course course) {
        courseService.updateCourse(course);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**删除章节*/
    @RequestMapping(value = "/course/deleteCourseKpoint/{courseKpointId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteCourseKpoint(@PathVariable("courseKpointId") int courseKpointId) {
        courseKpointService.deleteCourseKpoint(courseKpointId);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    /**删除目录*/
    @RequestMapping(value = "/course/deleteCourseCatalog/{catalogId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteCourseCatalog(@PathVariable("catalogId") int catalogId) {
        courseCatalogService.deleteCourseKpoint(catalogId);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    /** 修改章节*/
    @RequestMapping(value = "/course/updateCourseKpoint",method = RequestMethod.PUT)
    public Result updateCourseKpoint(CourseKpoint courseKpoint) {
        courseKpointService.updateCourseKpoint(courseKpoint);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    /** 修改目录*/
    @RequestMapping(value = "/course/updateCourseCatalog",method = RequestMethod.PUT)
    public Result updateCourseCatalog(CourseCatalog courseCatalog) {
        courseCatalogService.updateCourseCatalog(courseCatalog);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    @RequestMapping(value = "/course/recommendList", method = RequestMethod.GET)
    @ResponseBody
    public Result recommendList(@RequestParam(value = "courseId",required = false) Integer courseId,
                             @RequestParam(value = "courseName",required = false) String courseName, Course course,
                             @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws ParseException {
        if (courseId != null) {
            course.setCourseId(courseId);
        }if (courseName != null) {
            course.setCourseName(courseName);
        }
        PageHelper.startPage(pageNum, pageSize);//分页
        List<Course> courseList = courseService.recommendList(course);
        Page<Course> listCountry = (Page<Course>)courseList;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }

    /** 加入推荐*/
    @RequestMapping(value = "/course/joinRecommendation",method = RequestMethod.POST)
    public Result joinRecommendation(@RequestParam(value = "recommend",required = false) String recommend) {
        JSONArray jsonArray =JSONArray.parseArray(recommend);
        List<Integer> list = new ArrayList<Integer>();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            Integer courseId=jUser.getInteger("recommend");
            list.add(courseId);
        }
        JoinRecommendCourseList recommends=new JoinRecommendCourseList();
        recommends.setRecommend(list);
        courseService.joinRecommendation(recommends.getRecommend());
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    /** 取消推荐*/
    @RequestMapping(value = "/course/cancelRecommendation/{courseId}",method = RequestMethod.PUT)
    public Result cancelRecommendation(@PathVariable("courseId") Integer courseId) {
        courseService.cancelRecommendation(courseId);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
}
