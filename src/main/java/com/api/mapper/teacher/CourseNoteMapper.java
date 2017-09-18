package com.api.mapper.teacher;

import com.api.model.teaching.course.CourseNote;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public interface CourseNoteMapper {

    /** 添加笔记 */
    void addCourseNote(CourseNote courseNote);
    /** 查询笔记 */
    List<CourseNote> selectCourseNoteList(CourseNote courseNote);
    /** 修改笔记 */
    void updateCourseNote(CourseNote courseNote);
    /** 删除笔记 */
    void deleteCourseNote(List<Integer> idList);




}
