package com.api.service.teacher;

import com.api.mapper.teacher.CourseCatalogMapper;
import com.api.mapper.teacher.CourseKpointMapper;
import com.api.model.teaching.kpoint.CourseCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class CourseCatalogService {
    @Autowired
    private CourseCatalogMapper courseCatalogMapper;
    @Autowired
    private CourseKpointMapper courseKpointMapper;

    public void addCourseKpoint (CourseCatalog courseCatalog) {
        courseCatalog.setAddTime(new Date());
        courseCatalog.setKpointType(0);
        courseCatalogMapper.addCourseCatalog(courseCatalog);
    }

    /**
     * 课程下目录列表（包含每个目录下章节）
     * @param id
     * @return
     */
    public List<CourseCatalog> findCourseCatalog (int id) {
        List<CourseCatalog> courseCatalog = courseCatalogMapper.findCourseCatalog (id);
        return courseCatalog;
    }

    /**
     * 删除目录 目录删除以后该目录下所有章节将一起被删除
     * @param catalogId
     */
    @Transactional
    public void deleteCourseKpoint (int catalogId) {
        courseCatalogMapper.deleteCourseCatalog(catalogId);
        List<String> kpointList = courseKpointMapper.findParentId(catalogId);
        if ( kpointList.size() != 0) {
            courseKpointMapper.deleteAll(kpointList);
        }

    }

    /**
     * 修改
     * @param courseCatalog
     */
    public void updateCourseCatalog (CourseCatalog courseCatalog) {
        courseCatalogMapper.updateCourseCatalog(courseCatalog);
    }

    /**
     * 单个目录信息
     * @param catalogId
     * @return
     */
    public CourseCatalog findCatalog(int catalogId) {
        CourseCatalog courseCatalog = courseCatalogMapper.findCatalog(catalogId);
        return  courseCatalog;
    }

}
