package com.api.mapper.teacher;

import com.api.model.teaching.kpoint.CourseCatalog;

import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/17.
 */
public interface CourseCatalogMapper {
    /** 添加课程目录*/
    void addCourseCatalog(CourseCatalog courseCatalog);

    List<CourseCatalog> findCourseCatalog (int id);

    void deleteCourseCatalog (int catalogId);//删除

    void updateCourseCatalog (CourseCatalog courseCatalog);//修改目录

    //查询目录信息
    CourseCatalog findCatalog(int catalogId);
}
