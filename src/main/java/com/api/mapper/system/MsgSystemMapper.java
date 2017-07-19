package com.api.mapper.system;

import com.api.model.system.letter.MsgSystem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Service
public interface MsgSystemMapper {


    /** 查询所有系统消息 */
    List<MsgSystem> selectMsgSystem(MsgSystem msgSystem);

    /** 增加一条系统信息 */
    void addMsgSystem(MsgSystem msgSystem);

    /** 修改一条系统信息 */
    void updateMsgSystem(MsgSystem msgSystem);

    /** 删除一条消息记录 */
    void deleteMsgSystem(int id);


}
