package com.api.service.teacher;

import com.api.mapper.teacher.ImagesMapper;
import com.api.model.system.letter.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public class ImagesService {

    @Autowired
    private ImagesMapper imagesMapper;

    public  void addImages(Images images){
        imagesMapper.addImages(images);
    }


    public List<Images> selectImages(Images images){
        List<Images> list = imagesMapper.selectImages(images);
        return list;
    }
    public Images selectByImages(int imageId){
        Images images = imagesMapper.selectByImages(imageId);
        return images;
    }

    public void updateImages(Images images){
         imagesMapper.updateImages(images);
    };


    public void deleteImages(int imageId){
        imagesMapper.deleteImages(imageId);
    }
}