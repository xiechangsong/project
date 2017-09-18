package com.api.service.teacher;

import com.api.mapper.teacher.PraiseMapper;
import com.api.model.teaching.praise.Praise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/19.
 */
@Service
public class PraiseService {
    @Autowired
    private PraiseMapper praiseMapper;

    public  void addPraise(Praise praise){
        praiseMapper.addPraise(praise);
    }

    public boolean selectPraise(Praise praise){
        praise  = praiseMapper.selectPraise(praise);
        if (praise ==null){
            return false;
        }
        return  true;
    }

    public  void deletePraise(Praise praise){
        praiseMapper.deletePraise(praise);
    }
}
