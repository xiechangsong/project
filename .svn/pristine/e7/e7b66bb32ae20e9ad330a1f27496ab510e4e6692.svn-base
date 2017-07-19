package com.api.controller.system;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.system.teacher.Teacher;
import com.api.repository.TeacherRepository;
import com.api.service.system.TeacherService;
import com.api.service.user.UserService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HTTP 服务
 * Created by 牛逼的小菜鸟 on 2017/6/26.
 * 教师 CRUD
 */
@RestController
public class TeacherController {
    private Logger logger = Logger.getLogger(TeacherController.class);
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/teacher/addTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Result addTeacher(Teacher teacher) throws Exception{
        teacherService.addTearcher(teacher);

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    @RequestMapping(value = "/teacher/teacherList", method = RequestMethod.GET)
    @ResponseBody
    public Result teacherList(@RequestParam(value="realName", required=false) String name,
                              @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                              @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> teachersList = teacherService.teacherList(name);
        Page<Teacher> listCountry = (Page<Teacher>)teachersList;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }

    @RequestMapping(value = "/teacher/updateTeacher",method = RequestMethod.PUT)
    public Result updateTeacher(Teacher teacher) {
        teacherService.updataTeacher(teacher);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    @RequestMapping(value = "/teacher/delTeacher/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result delTeacher(@PathVariable("id") int id) {
        teacherRepository.delete(id);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    @RequestMapping( value = "/teacher/findTeacher/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result findTeacher(@PathVariable("id") int id) {
        Teacher teacher=teacherService.findTeacher(id);
        if(teacher == null) {
            return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(),ResultEnum.RETURS_EMPTY.getMsg()+"，目标不存在");
        }
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,teacher);
    }
}
