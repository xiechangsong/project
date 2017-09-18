package com.api.service.system;

import com.api.mapper.system.MsgReceiveMapper;
import com.api.model.system.letter.MsgReceive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
@Service
public class MsgReceiveService {

    @Autowired
    private MsgReceiveMapper msgReceiveMapper;

    public List<MsgReceive> selectAddMsgReceive(MsgReceive msgReceive){
        List<MsgReceive> list = msgReceiveMapper.selectAddMsgReceive(msgReceive);
        return  list;
    }

    public void insertAllMsgReceive(MsgReceive msgReceive){
        msgReceiveMapper.insertAllMsgReceive(msgReceive);
    };

    public   void deleteMsgReceive(List<Integer> idList){
        msgReceiveMapper.deleteMsgReceive(idList);
    }
}
