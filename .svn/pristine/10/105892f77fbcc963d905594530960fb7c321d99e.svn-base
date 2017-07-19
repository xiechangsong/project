package com.api.service.system;

import com.api.mapper.system.TeachesrMapper;
import com.api.model.system.teacher.Teacher;
import com.api.model.user.User;
import com.api.service.user.UserService;
import com.api.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Service
public class TeacherService {
    @Autowired
    private TeachesrMapper teacherMapper;
    @Autowired
    private UserService userService;

    /**
     * 增加老师
     * @param teacher 教师信息
     */
    @Transactional
    public void addTearcher (Teacher teacher) throws  Exception{
        teacher.setStatus(0);
        teacher.setCreateTime(new Date());
        teacher.setSort(1000);
        String name= Common.converterToFirstSpell(teacher.getRealName());//获取讲师的登录用户名
        User user=new User();
        user.setUserName(name);
        user.setPassWord("111111");
        user.setAddTime(new Date());
        user.setRealName(teacher.getRealName());
        user.setUserType(1);
        userService.register(user);
        teacher.setUserId(user.getId());
        teacherMapper.addTeacher(teacher);
    }

    /**
     * 教师列表
     * @return
     */
    public List<Teacher> teacherList(String name) {
        List<Teacher> teachersList=teacherMapper.teacherList(name);
        return teachersList;
    }

    /**
     * 删除
     * @param id
     */
    public void delTeacher(int id) {
        teacherMapper.delTeacher(id);
    }

    /**
     * 修改
     *
     */
    public void updataTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    public Teacher findTeacher(int id) {
        Teacher teacher=teacherMapper.findTeacher(id);
        return teacher;
    }
}
