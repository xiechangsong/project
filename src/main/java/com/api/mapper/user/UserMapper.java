package com.api.mapper.user;


import com.api.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2015/8/27.
 */
@Service
public interface UserMapper {
    public User findUserInfo();
    /** 根据用户名查询用户信息 */
    public User getUser(String name);

    /** 查询所有用户信息 */
    List<User> findAll();

    /** 增加一条用户信息 */
    void register(User user);

    /** 修改一条用户信息 */
    void updateUser(User user);

    /** 模糊查询用户信息 */
    List<User> selectUser(User user);

    /** 批量查询所有用户ID */
    List<User>   selectAll(List<String> userName);

    List<User> studentList(User user);

    /**批量新增学员*/
    void addStudentBatch (List<User> userList);
}
