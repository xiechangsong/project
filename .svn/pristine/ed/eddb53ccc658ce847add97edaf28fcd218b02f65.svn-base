package com.api.service.system;

import com.api.mapper.system.SysUserOperationMapper;
import com.api.model.teaching.system.SysUserOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
@Service
public class SysUserOperationService {

    @Autowired
    private SysUserOperationMapper sysUserOperationMapper;


    /**新增管理员操作记录*/
    public void addSysUserOperation(SysUserOperation sysUserOperation){
        sysUserOperationMapper.addSysUserOperation(sysUserOperation);
    }

    /**查询管理员操作记录*/
    public List<SysUserOperation> selectSysUserOperation(SysUserOperation sysUserOperation){
        List<SysUserOperation> list = sysUserOperationMapper.selectSysUserOperation(sysUserOperation);
        return  list;
    };
}
