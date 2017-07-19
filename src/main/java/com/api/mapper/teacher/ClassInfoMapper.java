package com.api.mapper.teacher;


import com.api.model.system.teacher.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/6/28.
 */
@Service
public interface ClassInfoMapper {
    /** 添加专业 */
    void addClass(ClassInfo classInfo);

    /** 专业列表 */
    List<ClassInfo> classList(ClassInfo classInfo);

    /** 删除 */
    void deleteClass(int id);

    /** 修改 */
    void updateClass(ClassInfo classInfo);

    /** 根据id查询data*/
    ClassInfo findClass(int id);
}
