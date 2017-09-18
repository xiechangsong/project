package com.api.mapper.teacher;

import com.api.model.teaching.course.CourseStudyhistory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public interface CourseStudyhistoryMapper {

    /** 添加播放记录*/
   public  void addCourseStudyhistory(CourseStudyhistory courseStudyhistory);


    /** 查询播放记录*/
    public List<CourseStudyhistory> selectCourseStudyhistory(CourseStudyhistory courseStudyhistory);


    /**批量删除播放记录*/
    public   void deleteCourseStudyhistory(List<Integer> idList);
}
