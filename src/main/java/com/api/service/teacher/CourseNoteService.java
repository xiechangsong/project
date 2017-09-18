package com.api.service.teacher;

import com.api.mapper.teacher.CourseNoteMapper;
import com.api.model.teaching.course.CourseNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class CourseNoteService {
    @Autowired
    private CourseNoteMapper courseNoteMapper;


    public void addCourseNote (CourseNote courseNote) {
        courseNoteMapper.addCourseNote(courseNote);
    }

    public List<CourseNote> selectCourseNoteList (CourseNote courseNote) {
       List<CourseNote> courseNotes = courseNoteMapper.selectCourseNoteList(courseNote);
        return courseNotes;
    }
    public void updateCourseNote(CourseNote courseNote){
        courseNote.setUpdateTime(new Date());
        courseNoteMapper.updateCourseNote(courseNote);
    };
    public   void deleteCourseNote(List<Integer> idList){
        courseNoteMapper.deleteCourseNote(idList);
    }


}
