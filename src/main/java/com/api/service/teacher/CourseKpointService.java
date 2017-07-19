package com.api.service.teacher;

import com.api.mapper.teacher.CourseCatalogMapper;
import com.api.mapper.teacher.CourseKpointMapper;
import com.api.model.teaching.kpoint.CourseKpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class CourseKpointService {
    @Autowired
    private CourseKpointMapper courseKpointMapper;
    @Autowired
    private CourseCatalogMapper courseCatalogMapper;

    public void addCourseKpoint (CourseKpoint courseKpoint) {
        courseKpoint.setAddTime(new Date());
        courseKpointMapper.addCourseKpoint(courseKpoint);
    }

   /* public List<CourseKpoint> courseKpointList () {
        List<CourseKpoint> courseKpoint = courseKpointMapper.courseKpointList();
        return courseKpoint;
    }*/

    /**
     * 单纯的删除某一章节
     * @param courseKpointId
     */
    @Transactional
    public void deleteCourseKpoint (int courseKpointId) {
        courseKpointMapper.deleteCourseKpoint(courseKpointId);
       /* List<String> kpointList = courseKpointMapper.findParentId(catalogId);
        if ( kpointList.size() != 0) {
            courseKpointMapper.deleteAll(kpointList);
        }*/

    }
    public void updateCourseKpoint (CourseKpoint courseKpoint) {
        courseKpointMapper.updateCourseKpoint(courseKpoint);
    }

    /**
     * 查询单个章节信息
     * @param kpointId
     * @return
     */
    public CourseKpoint courseKpoints(int kpointId) {
        CourseKpoint courseKpoint = courseKpointMapper.courseKpoints(kpointId);
        return courseKpoint;
    }

    /**
     * 章节列表
     * @param id 目录id
     * @return
     */
    public List<CourseKpoint> findCourseKpoint (int id) {
        List<CourseKpoint> courseKpoint = courseKpointMapper.findCourseKpoint (id);
        return courseKpoint;
    }
}
