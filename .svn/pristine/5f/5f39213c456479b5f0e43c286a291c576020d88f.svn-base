package com.api.mapper.system;

import com.api.model.teaching.system.SysUser;
import com.api.model.teaching.system.SysUserOperation;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public interface SysUserMapper {
    SysUser findSysUserInfo();

    /** 根据用户名查询用户信息 */
    SysUser getSysUser(String name);

    /** 查询所有用户信息 */
    List<SysUser> findAllSysUser();

    /** 增加一条用户信息 */
    void registerSysUser(SysUser sysUser);

    /** 修改一条用户信息 */
    void updateSysUser(SysUser sysUser);

    /** 删除一条用户信息 */
    void deleteSysUser(int id);

    /** 用户操作记录 */
    void addSysUserOperation(SysUserOperation sysUserOperation);

    /** 用户操作记录模糊查询 */
    List<SysUserOperation> selectSysUserOperation();
}
