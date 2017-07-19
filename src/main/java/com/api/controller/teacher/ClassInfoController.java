package com.api.controller.teacher;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.system.teacher.ClassInfo;
import com.api.service.teacher.ClassInfoService;
import com.api.utils.Common;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/1.
 */
@RestController
public class ClassInfoController {
    private Logger logger = Logger.getLogger(ClassInfoController.class);

    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping(value = "/class/addClass", method = RequestMethod.POST)
    @ResponseBody
    public Result addClass(ClassInfo classInfo) {
        classInfoService.addClass(classInfo);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    @RequestMapping(value = "/class/classList", method = RequestMethod.GET)
    @ResponseBody
    public Result classList(@RequestParam(value = "classId",required = false) Integer classId,
                            @RequestParam(value = "className",required = false) String className,
                            @RequestParam(value = "status",required = false) Integer status,
                            @RequestParam(value = "createTime",required = false)String createTime,
                            @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                            ClassInfo classInfo) throws ParseException {
        if (status != null) {
            classInfo.setStatus(status);
        }if (classId != null) {
            classInfo.setClassId(classId);
        }if (className != null) {
            classInfo.setClassName(className);
        }if (createTime != null) {
           Date ctime = Common.FMT_DATE_1.parse(createTime);
            classInfo.setCreateTime(ctime);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ClassInfo> teacherList = classInfoService.classList(classInfo);
        Page<ClassInfo> listCountry = (Page<ClassInfo>)teacherList;

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }
    @RequestMapping(value = "/class/deleteClass/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteClass(@PathVariable("id") int id) {
        classInfoService.deleteClass(id);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    @RequestMapping(value = "/class/updateClass",method = RequestMethod.PUT)
    public Result updateSubject(ClassInfo classInfo) {
        classInfoService.updateClass(classInfo);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    @RequestMapping( value = "/class/findClass/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result findClass(@PathVariable("id") int id) {
        ClassInfo classInfo = classInfoService.findClass(id);
        if(classInfo == null) {
            return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(),ResultEnum.RETURS_EMPTY.getMsg()+"，目标不存在");
        }
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,classInfo);
    }

}
