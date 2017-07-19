package com.api.mapper.teacher;

import com.api.model.teaching.course.Course;
import com.api.model.teaching.course.CourseNote;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public interface CourseMapper {
    /** 添加课程 */
    void addCourse (Course course);
    /** 添加手记 */
    void addCourseNote (CourseNote courseNote);

    List<Course> courseList(Course course);

    void updateCourse (Course course);

    void deleteCourse (int courseId);
    /** 推荐列表 */
    List<Course> recommendList(Course course);
    /**未推荐列表*/
    List<Course> notRecommendedList(Course course);

    /**加入推荐*/
    void joinRecommendation(List<Integer> courseId);

    /**取消推荐*/
    void cancelRecommendation (int courseId);



}
