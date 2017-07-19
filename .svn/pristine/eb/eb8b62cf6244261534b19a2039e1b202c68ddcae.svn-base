package com.api.service.system;

import com.api.mapper.system.MsgSystemMapper;
import com.api.model.system.letter.MsgSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */
@Service
public class MsgSystemService {
    @Autowired
    private MsgSystemMapper msgSystemMapper;

    /**
     * 查询所有系统消息
     * @return
     */
   public List<MsgSystem> selectMsgSystem(MsgSystem msgSystem){
        List<MsgSystem> list = msgSystemMapper.selectMsgSystem(msgSystem);
        return  list;
    }

    /**
     * 添加系统消息
     * @param msgSystem
     */
   public  void addMsgSystem(MsgSystem msgSystem){
        msgSystemMapper.addMsgSystem(msgSystem);
    }
}
