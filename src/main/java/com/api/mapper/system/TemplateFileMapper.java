package com.api.mapper.system;

import com.api.model.system.TemplateFile;
import org.springframework.stereotype.Service;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/10.
 */
@Service
public interface TemplateFileMapper {

    void addTemplateFile (TemplateFile templateFile);

    //下载模板文件
    TemplateFile showTemplateAddress ( int type);

    //由于每个模板文件只能存在一个，创建的时候需要查看是否存在
    TemplateFile isExist (Integer type);

    void updateTemplate (TemplateFile templateFile);

}
