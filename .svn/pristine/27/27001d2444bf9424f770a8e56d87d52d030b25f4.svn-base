package com.api.interceptor;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/11.
 */
public class Interceptor  implements HandlerInterceptor {
    private final static Logger logger= LoggerFactory.getLogger(Interceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Result res=new Result();
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            res.setCode(ResultEnum.IS_NO_LOGIN.getCode());
            res.setMsg(ResultEnum.IS_NO_LOGIN.getMsg());
            returnErrorMessage(httpServletResponse, res);
            return false;
        }
       return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.debug("===================================postHandle start=============================");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.debug("===================================afterCompletion start=============================");
    }
    private void returnErrorMessage(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = mapper.writeValueAsString(result);
        out.print(jsonOfRST);
        out.flush();
    }

}
