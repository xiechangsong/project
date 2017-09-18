package com.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/26.
 */
@Aspect
@Component
public class HttpAspect {
   //spring自动的一个日子框架，底层实现是logback
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 拦截公共切入点
     * execution(public  * BootController.bootList(..)) 拦截指定的操作
     * execution(public  * BootController.*(..))拦截所有操作
     */
    @Pointcut("execution(public  * com.api.controller.*.*Controller.*(..))")
    public void log(){
    }

    /**
     * 在xx之前进行拦截
     * 直接调用公共切入点了的配置进行拦截
     *
     */
    @Before("log()")
    public void doBefore (JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("==========================Start running===========================");
        //url
        logger.info("url={}" , request.getRequestURL());

        //method
        logger.info("method={}" , request.getMethod());

        //ip
        logger.info("ip={}" , request.getRemoteAddr());

        //类方法
        logger.info("class_method={}" ,joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() );

        //参数
        logger.info("args={}" , joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter () {
        logger.info("=============================End run==============================");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
