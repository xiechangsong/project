package com.api.mapper.system;

import com.api.model.system.letter.MsgReceive;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
@Service
public interface MsgReceiveMapper {

    /**
     * 多用户查询
     */
    public List<MsgReceive> selectAddMsgReceive(MsgReceive msgReceive);
    /**
     * 添加消息
     */
    public void insertAllMsgReceive(MsgReceive msgReceive);

    /**
     * 批量删除
     * @param idList
     */
    public   void deleteMsgReceive(List<Integer> idList);

}
