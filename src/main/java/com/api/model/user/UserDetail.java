package com.api.model.user;

import javax.persistence.*;

/**
 * 用户信息详细表
 * Created by Administrator on 2017/6/15.
 */
@Entity
public class UserDetail {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    /** 特长 */
    private String specialty;
    /** 期望职位 最大允许选择3个*/
    private String desiredPosition;
    /** 期望薪资 */
    private double expected_salary;
    /** 简介 */
    private String profiles;
    /** 状态 */
    private int state;
}
