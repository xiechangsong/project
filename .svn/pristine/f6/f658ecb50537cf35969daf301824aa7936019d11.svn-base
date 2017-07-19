package com.api.service.teacher;

import com.api.mapper.teacher.CourseMapper;
import com.api.model.teaching.course.Course;
import com.api.model.teaching.course.CourseNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public void addCourse (Course course) {
        course.setAddTime(new Date());
        courseMapper.addCourse(course);
    }

    public void addCourseNote (CourseNote courseNote) {
        courseMapper.addCourseNote(courseNote);
    }
    public List<Course> courseList (Course course) {
       List<Course> courses = courseMapper.courseList(course);
        return courses;
    }
    public List<Course> notRecommendedList (Course course) {
        List<Course> courses = courseMapper.notRecommendedList(course);
        return courses;
    }

    /***
     * 推荐列表
     * @param course 参数
     * @return
     */
    public List<Course> recommendList(Course course) {
        List<Course> courses = courseMapper.recommendList(course);
        return courses;
    }
    /**加入推荐*/
    public void joinRecommendation (List<Integer> courseId) {
        courseMapper.joinRecommendation( courseId );
    }
    /**取消推荐*/
    public void cancelRecommendation (int courseId) {
        courseMapper.cancelRecommendation( courseId );
    }
    public void deleteCourse (int courseId) {
        courseMapper.deleteCourse(courseId);
    }
    public void updateCourse (Course course) {
        courseMapper.updateCourse(course);
    }
}
