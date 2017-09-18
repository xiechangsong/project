
package com.api.aspect;

import com.api.controller.system.SubjectController;
import com.api.model.teaching.system.SysUserOperation;
import com.api.model.user.User;
import com.api.service.system.SysUserOperationService;
import com.api.service.user.UserService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * Created by Administrator on 2017/7/8.
 */

@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(SubjectController.class);

    @Autowired
    private SysUserOperationService sysUserOperationService;

    @Autowired
    private UserService userService;
    //Controller层切点 拦截所有的Controller
    //  @Pointcut("execution(public  * com.api.service.*.UserService.*(..))")
    @Pointcut("execution(public  * com.api.controller.*.*Controller.*(..))")
    public  void controllerAspect() {

    }

    @Before("controllerAspect()")
    public  void doBefore(JoinPoint joinPoint)throws Exception  {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request.getSession().getAttribute("user")!=null){
        User user = (User)request.getSession().getAttribute("user");
            User u= userService.getUserInfo(user.getUserName());
        if (u.getUserType()==2){
            //获取Controller信息
            SysUserOperation sysUserOperation =getControllerMethodDescription(joinPoint);
            if (sysUserOperation.getOperation()!=null) {
                //获取操作用户
                sysUserOperation.setName(user.getUserName());
                //获取注解中的值,赋给操作描述

                sysUserOperationService.addSysUserOperation(sysUserOperation);
            }
        }
        }
    }


/**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */

    public  static SysUserOperation getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        //获取Controller 类
        String targetName = joinPoint.getTarget().getClass().getName();
        //获取注解value
        String methodName = joinPoint.getSignature().getName();
        //获取对象值 Object
        Object[] arguments = joinPoint.getArgs();
    /*    StringBuffer nameBuffer = new StringBuffer();
        for (int i = 0; i <arguments.length ; i++) {
            User user = (User) arguments[i];
            String name= user.getUserName();
            if(i == 0){
                nameBuffer.append(name);
            }else{
                nameBuffer.append(","+name);
            }
            System.out.println(nameBuffer.toString());
        }*/
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        SysUserOperation sysUserOperation = new SysUserOperation();
       if (methodName.equals("updateUser")){
           sysUserOperation.setOperation("修改用户信息");
           sysUserOperation.setType("2");
        }
        if (methodName.equals("register")||methodName.equals("importStudentInfo")){
            sysUserOperation.setOperation("注册用户角色");
            sysUserOperation.setType("1");
        }
        if (methodName.contains("delTeacher")){
            sysUserOperation.setOperation("删除教师角色");
            sysUserOperation.setType("3");
        }
        if (methodName.contains("addTeacher")){
            sysUserOperation.setOperation("新增教师角色");
            sysUserOperation.setType("1");
        }
        if (methodName.contains("updateTeacher")){
            sysUserOperation.setOperation("修改教师角色");
            sysUserOperation.setType("2");

        }
        return sysUserOperation;
    }
}


