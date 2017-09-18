package com.api.mapper.teacher;

import com.api.model.system.letter.Images;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public interface ImagesMapper {

    /** 添加页面图片*/
   public  void addImages(Images images);


    /** 查询所有页面图片*/
    public List<Images> selectImages(Images images);


    /** 查询单个对象*/
    public Images selectByImages(int imageId);

    /** 修改页面图片*/
    public void updateImages(Images images);

    /** 删除页面图片*/
    public void deleteImages(int imageId);

}
