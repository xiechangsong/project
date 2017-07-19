package com.api.service.user;

import com.api.enume.ResultEnum;
import com.api.mapper.user.UserMapper;
import com.api.model.common.Result;
import com.api.model.user.User;
import com.api.utils.ResultUtil;
import com.api.utils.SHAencrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }
    public List<User> findAll(){
        List<User> lists=userMapper.findAll();
        return lists;
    }

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    public User getUserInfo(String name) {
        User user=userMapper.getUser(name);
        return user;
    }

    /**
     * 注册
     * @param user 注册信息
     * @throws Exception
     */
    public void register(User user) throws Exception {
        String passWord = SHAencrypt.encryptSHA(user.getPassWord());//密码加密
        user.setPassWord(passWord);
        user.setAddTime(new Date());
        userMapper.register(user);
    }
    /**
     * 教师注册
     * @param user 注册信息
     * @throws Exception
     */
    public void teacherRegister(User user) throws Exception {
        String passWord = SHAencrypt.encryptSHA(user.getPassWord());//密码加密
        user.setPassWord(passWord);
        user.setAddTime(new Date());
        userMapper.register(user);
    }

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    public Result login(HttpSession session,User user) throws Exception {

        User resultUser = userMapper.getUser(user.getUserName());
        if (resultUser == null ){
            return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(), ResultEnum.RETURS_EMPTY.getMsg());
        }
        String passWord=SHAencrypt.encryptSHA(user.getPassWord());//密码加密
        if(!resultUser.getPassWord().equals(passWord)){
            return ResultUtil.ERROR(ResultEnum.LOGIN_ERROR.getCode(), ResultEnum.LOGIN_ERROR.getMsg());
        }
        else{
            session.setAttribute("user", user);
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS, resultUser);
        }
    }
    /**
     * 修改
     * @param user
     */
    public void updateUser(User user) throws Exception {
        String  passWord = SHAencrypt.encryptSHA(user.getPassWord());//密码加密
        user.setPassWord(passWord);
        userMapper.updateUser(user);
    }
    /**
     * 模糊查询
     * @param user
     */
    public List<User> selectUser(User user) throws Exception {
        List<User> lists =userMapper.selectUser(user);
        return lists;
    }
    public List<User> studentList(User user) throws Exception {
        List<User> lists =userMapper.studentList(user);
        return lists;
    }
    /** 批量查询所有用户信息 */
    public List<User> selectAll (List<String> userName) {
        List<User> list=  userMapper.selectAll(userName);
        return  list;
    }

    /**
     * 批量新增学员
     * @param userList
     */
    @Transactional
    public void addStudentBatch (List<User> userList) {
        userMapper.addStudentBatch(userList);
    }

}
