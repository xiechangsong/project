package com.api.utils;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;

/**
 * Created by Administrator on 2017/5/26.
 * 返回结果工具类
 */
public class ResultUtil {


    /**
     * 请求成功返回模板
     * @param object 带有返回数据
     * @return
     */
    public static Result SUCCESS(ResultEnum resultEnum, Object object) {
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    /***
     * 请求成功返回模板 分页
     * @param resultEnum 返回码
     * @param object  结果集
     * @param total 总数量
     * @param pages 总页数
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     * @return
     */
    public static Result SUCCESS(ResultEnum resultEnum, Object object,long total,int pages,int pageNum,int pageSize) {
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        result.setPageNum(pageNum);
        result.setPages(pages);
        result.setPageSize(pageSize);
        result.setTotal(total);
        return result;
    }

    /**
     * 单纯请求，只返回请求结果
     * @return
     */
    public static Result SUCCESS(ResultEnum resultEnum) {
        return SUCCESS(resultEnum,null);
    }

    /**
     * 请求失败返回模板
     * @param
     * @return
     */
    public static Result ERROR(Integer code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
