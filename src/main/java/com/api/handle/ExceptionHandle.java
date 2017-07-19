package com.api.handle;

import com.api.enume.ResultEnum;
import com.api.exception.BootException;
import com.api.model.common.Result;
import com.api.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Xie Changsong
 * 异常捕获
 * 2017-01-21 13:59
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BootException) {
            BootException bootException = (BootException) e;
            return ResultUtil.ERROR(bootException.getCode(), bootException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.ERROR(ResultEnum.SYSTEM_ERROR.getCode(), ResultEnum.SYSTEM_ERROR.getMsg());
        }
    }
}
