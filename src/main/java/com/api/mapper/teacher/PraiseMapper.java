package com.api.mapper.teacher;

import com.api.model.teaching.praise.Praise;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/19.
 */
@Service
public interface PraiseMapper {

    /** 添加点赞*/
    public  void addPraise(Praise praise);

    /** 查询点赞*/
    public Praise selectPraise(Praise praise);

    /** 删除点赞*/
    public  void deletePraise(Praise praise);
}
