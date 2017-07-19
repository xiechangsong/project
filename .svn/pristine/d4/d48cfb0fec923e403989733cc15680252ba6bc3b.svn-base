package com.api.interceptor;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/11.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    private Logger logger = Logger.getLogger(WebAppConfigurer.class);
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("==========WebAppConfigurer正在启动");
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截,除了登录，其他的都拦截
        registry.addInterceptor(new Interceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
        super.addInterceptors(registry);
    }
}
