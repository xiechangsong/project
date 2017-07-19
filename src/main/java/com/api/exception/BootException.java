package com.api.exception;



import com.api.enume.ResultEnum;

/**
 * Created by Xie Changsong
 * 2017-01-21 14:05
 * 统一异常处理
 */
public class BootException extends RuntimeException{

    private Integer code;

    public BootException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
