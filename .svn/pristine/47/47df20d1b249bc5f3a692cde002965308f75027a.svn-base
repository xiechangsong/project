package com.api.controller.system;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.system.TemplateFile;
import com.api.service.system.TemplateFileService;
import com.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/10.
 * 模板文件创建
 */
@RestController
public class TemplateFileController {

    @Autowired
    private TemplateFileService templateFileService;

    @RequestMapping (value = "/template/addTemplateFile",method = RequestMethod.POST)
    @ResponseBody
    public Result addTemplateFile (HttpServletRequest request, TemplateFile templateFile) {
        templateFileService.addTemplateFile(templateFile);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,templateFile);
    }

    @RequestMapping (value = "/template/showTemplatefileAddress/{type}",method = RequestMethod.GET)
    @ResponseBody
    public Result showTemplatefileAddress (@PathVariable("type") int type) {
       TemplateFile templateFile= templateFileService.showTemplateAddress(type);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,templateFile);
    }

    /***
     * 查看模板是否存在(暂不使用)
     * @param type
     * @return
     */
    @RequestMapping (value = "/template/isExist/{type}",method = RequestMethod.GET)
    @ResponseBody
    public Result isExist (@PathVariable("type") Integer type) {
        Result result= templateFileService.isExist(type);
        return result;
    }
}
