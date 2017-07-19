package com.api.service.teacher;

import com.api.mapper.teacher.ClassInfoMapper;
import com.api.model.system.teacher.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by 牛逼的小菜鸟 on 2017/6/28.
 */
@Service
public class ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    /** 新增班级*/
    public void addClass(ClassInfo classInfo) {
        classInfo.setCreateTime(new Date());
        classInfoMapper.addClass(classInfo);
    }
    /**
     * 班级列表
     * @param classInfo 查询条件
     * */
    public List<ClassInfo> classList(ClassInfo classInfo) {
        List<ClassInfo> classList=classInfoMapper.classList(classInfo);
        return classList;
    }
    /**
     * 删除
     * @param id
     */
    public void deleteClass(int id) {
        classInfoMapper.deleteClass(id);
    }

    /**
     * 修改
     *@param classInfo 参数 修改的信息
     */
    public void updateClass(ClassInfo classInfo) {
        classInfoMapper.updateClass(classInfo);
    }
    /** 根据id查询单个专业信息*/
    public ClassInfo findClass(int id) {
        ClassInfo classInfo=classInfoMapper.findClass( id );
        return classInfo;
    }
}
