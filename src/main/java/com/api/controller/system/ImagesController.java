
package com.api.controller.system;

import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.system.letter.Images;
import com.api.service.teacher.ImagesService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;


/**
 * Created by Administrator on 2017/7/25.
 */
@RestController
public class ImagesController {
    private Logger logger = Logger.getLogger(SubjectController.class);
    @Autowired
    private ImagesService imagesService;


/**
     * 添加图片
     * @param images
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/images/addImages",method = RequestMethod.POST)
    @ResponseBody
    public Result addImages(Images images)throws Exception  {
        imagesService.addImages(images);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 修改
     * @param images
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/images/updateImages",method = RequestMethod.POST)
    @ResponseBody
    public Result updateImages(Images images)throws Exception  {

        Images i =imagesService.selectByImages(images.getImageId());
        File f = new File(i.getImageUrl());
        if (f.isFile()){
            f.delete();
        }
        imagesService.updateImages(images);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 查询所有
     * @param images
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/images/selectImages",method = RequestMethod.POST)
    @ResponseBody
    public Result selectImages(Images images,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false, defaultValue = "10") Integer pageSize)throws Exception  {

        PageHelper.startPage(pageNum, pageSize);

        List<Images>  list = imagesService.selectImages(images);

        Page<Images> listCountry = (Page<Images>)list;

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, list,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());


    }

    @RequestMapping(value = "/images/deleteImages/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public Result deleteImages(@PathVariable("id")int imageId){
        Images i =imagesService.selectByImages(imageId);
        File f = new File(i.getImageUrl());
        if (f.isFile()){
            f.delete();
        }
        imagesService.deleteImages(imageId);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    };


}

