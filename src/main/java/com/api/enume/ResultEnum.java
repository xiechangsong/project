package com.api.enume;

/**
 * Created by 牛逼的小菜鸟 on 2017/5/26.
 * 返回码设置工具类
 */
public enum ResultEnum {
    SYSTEM_ERROR(-1, "网络出错"),
    SUCCESS(10000, "请求成功"),
    ERROR(10001,"请求失败"),
    LOGIN_ERROR(10002,"用户名或密码错误"),
    PARAMETER_MISSING(10003,"参数有误"),
    ALREADY_EXISTS(10004,"用户名已存在"),
    RETURS_EMPTY(10005,"查询结果为空"),
    FILE_UPLOAD_FAILED(10006,"文件上传失败"),
    IS_NO_LOGIN(10007,"请先登录"),
    IS_EXIST(10008,"模板已存在"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
