package com.api.service.system;

import com.api.enume.ResultEnum;
import com.api.mapper.system.TemplateFileMapper;
import com.api.model.common.Result;
import com.api.model.system.TemplateFile;
import com.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/10.
 */
@Service
public class TemplateFileService {
    @Autowired
    private TemplateFileMapper templateFileMapper;


    public void addTemplateFile (TemplateFile templateFile) {
        templateFile.setAddTime(new Date());
        templateFileMapper.addTemplateFile(templateFile);
    }

    public TemplateFile showTemplateAddress ( int type) {
        TemplateFile templateFile=templateFileMapper.showTemplateAddress(type);
        return templateFile;
    }
     public Result isExist(Integer type) {
         TemplateFile templateFile = templateFileMapper.isExist(type);
         if ( templateFile == null ) {
             return ResultUtil.SUCCESS(ResultEnum.SUCCESS,null);
         }
         return ResultUtil.ERROR(ResultEnum.IS_EXIST.getCode(),ResultEnum.IS_EXIST.getMsg());
     }
}
