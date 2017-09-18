package com.api.service.teacher;

import com.api.mapper.teacher.CourseStudyhistoryMapper;
import com.api.model.teaching.course.CourseStudyhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public class CourseStudyhistoryService {

    @Autowired
    private CourseStudyhistoryMapper courseStudyhistoryMapper;


    /** 添加播放记录*/
    public  void addCourseStudyhistory(CourseStudyhistory courseStudyhistory){
        courseStudyhistoryMapper.addCourseStudyhistory(courseStudyhistory);
    };


    /** 查询播放记录*/
    public List<CourseStudyhistory> selectCourseStudyhistory(CourseStudyhistory courseStudyhistory){
        List<CourseStudyhistory> list = courseStudyhistoryMapper.selectCourseStudyhistory(courseStudyhistory);
        return list;
    };


    /**批量删除播放记录*/
    public   void deleteCourseStudyhistory(List<Integer> idList){
        courseStudyhistoryMapper.deleteCourseStudyhistory(idList);
    };


}
