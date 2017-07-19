package com.api.service.system;

import com.api.enume.ResultEnum;
import com.api.mapper.system.SysUserMapper;
import com.api.model.common.Result;
import com.api.model.teaching.system.SysUser;
import com.api.model.teaching.system.SysUserOperation;
import com.api.utils.ResultUtil;
import com.api.utils.SHAencrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;


    public SysUser getUserInfo(){
        SysUser sysUser=sysUserMapper.findSysUserInfo();
        //User user=null;
        return sysUser;
    }
    public List<SysUser> findAll(){
        List<SysUser> lists=sysUserMapper.findAllSysUser();
        return lists;
    }

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    public SysUser getUserInfo(String name) {
        SysUser sysUser=sysUserMapper.getSysUser(name);
        return sysUser;
    }
    /**
     * 注册
     * @param sysUser 注册信息
     * @throws Exception
     */
    public void register(SysUser sysUser) throws Exception {
        SysUser resultUser = sysUserMapper.getSysUser(sysUser.getLoginName());
        if (resultUser == null ){
            String passWord = SHAencrypt.encryptSHA(sysUser.getLoginPwd());//密码加密
            sysUser.setLoginPwd(passWord);
            sysUserMapper.registerSysUser(sysUser);
        }

    }

    /**
     * 登录
     * @param sysUser
     * @return
     * @throws Exception
     */
    public Result login(SysUser sysUser) throws Exception {
        SysUser resultUser = sysUserMapper.getSysUser(sysUser.getLoginName());
        if (resultUser == null ){
            return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(), ResultEnum.RETURS_EMPTY.getMsg());
        }
        String passWord=SHAencrypt.encryptSHA(sysUser.getLoginPwd());//密码加密
        if(!resultUser.getLoginPwd().equals(passWord)){
            return ResultUtil.ERROR(ResultEnum.LOGIN_ERROR.getCode(), ResultEnum.LOGIN_ERROR.getMsg());
        }
        else{
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS, resultUser);
        }
    }

    /**
     * 删除
     *
     */
    public  void deleteSysUser(int id){
        sysUserMapper.deleteSysUser(id);
    };

    /**
     * 修改
     * @param sysUser
     */
    public void updateSysUser(SysUser sysUser) throws Exception {
        String passWord = SHAencrypt.encryptSHA(sysUser.getLoginPwd());//密码加密
        sysUser.setLoginPwd(passWord);
        sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 添加 操纵信息
     * @param sysUserOperation
     */
    public void addSysUserOperation(SysUserOperation sysUserOperation) throws Exception {
        sysUserMapper.addSysUserOperation(sysUserOperation);
    }

    /**
     * 模糊查询操作信息的name 和 type
     *
     * @param sysUserOperation
     */
    public  List<SysUserOperation> selectSysUserOperation(SysUserOperation sysUserOperation){

        List<SysUserOperation> lists = sysUserMapper.selectSysUserOperation();

        return  lists;
    }

}
