package com.api.aspect;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/4.
 */
@Configuration
public class MybatisConf {
    private final static Logger logger= LoggerFactory.getLogger(MybatisConf.class);
    @Bean
    public PageHelper pageHelper() {
        logger.info("MyBatisConfiguration.pageHelper() runing...........");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
