package com.api.mapper.teacher;

import com.api.model.teaching.kpoint.CourseKpoint;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public interface CourseKpointMapper {
    /** 添加课程节点*/
    void addCourseKpoint(CourseKpoint courseKpoint);

    List<CourseKpoint> findCourseKpoint (int id);

   /* List<CourseKpoint> courseKpointList ();*/

    /**删除课程章节*/
    void deleteCourseKpoint (int courseKpointId);

    void deleteAll (List<String> courseKpoint);

    List<String> findParentId(int courseKpointId);

    void updateCourseKpoint (CourseKpoint courseKpoint);

    CourseKpoint courseKpoints(int kpointId);

    /***
     * 根据父节点的id查询子节点
     * @param parentId
     * @return
     */
    List<CourseKpoint> selectCourseKpointChildList(int parentId);
}
