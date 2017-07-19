package com.api.controller.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.course.UserCourseList;
import com.api.model.user.User;
import com.api.service.user.UserService;
import com.api.utils.ReadExcel;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created 牛逼的小菜鸟
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 注册
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result register(@Valid User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            return ResultUtil.ERROR(ResultEnum.ERROR.getCode(),ResultEnum.PARAMETER_MISSING.getMsg() + "(" + bindingResult.getFieldError().getDefaultMessage() +")");
        }
        User returnUser=userService.getUserInfo(user.getUserName());
        if (returnUser==null){
            userService.register(user);
        }

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, returnUser);
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public Result login() throws Exception {

        return ResultUtil.ERROR(ResultEnum.IS_NO_LOGIN.getCode(),ResultEnum.IS_NO_LOGIN.getMsg());
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(HttpSession session, User user) throws Exception {
        System.out.println(session.getMaxInactiveInterval());
        Result result=userService.login(session,user);
        return result;
    }
    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateUser(User user) throws Exception {
        userService.updateUser(user);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 模糊查询
     * @param user
     * @return
     */
    @RequestMapping("/selectUserName")
    @ResponseBody
    public Result selectUser(User user) throws Exception {
        User users= userService.getUserInfo(user.getUserName());
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, users);
    }

    /**
     * 用户查询
     * @param user
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public Result selectUserName(User user, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {

        PageHelper.startPage(pageNum, pageSize);

        List<User> lists= userService.selectUser(user);

        Page<User> listCountry = (Page<User>)lists;

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, lists,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }



    /**
     * 模糊查询
     * @param user
     * @return
     */

    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    @ResponseBody
    public Result studentList(HttpServletRequest request,User user,
                              @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                              @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {

        PageHelper.startPage(pageNum, pageSize);//分页 注意：紧接着后面的一个查询才会被分页
        List<User> lists= userService.studentList(user);
        Page<User> listCountry = (Page<User>)lists;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, lists,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }


    //批量创建用户
    @RequestMapping(value = "/importStudentInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result importStudentInfo(HttpServletRequest request,@RequestParam("file") MultipartFile file) throws  Exception{
        try {
            List<User>  userList= ReadExcel.createStudent(request,file,0);
            for (User user:userList) {
                User user1=userService.getUserInfo(user.getUserName());
                if (user1 != null ) {
                    return ResultUtil.ERROR(ResultEnum.ALREADY_EXISTS.getCode(),"用户名已存在，请检查该用户是否已创建");
                }
            }
           userService.addStudentBatch(userList);
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 依据用户名批量查找ID
     * @param userName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public Result selectAll(@RequestParam(value = "userName",required = false) String userName)throws Exception  {
       // userName="[ { \"userName\": \"1233\" }, { \"userName\": \"123\"}]";
        JSONArray jsonArray =JSONArray.parseArray(userName);
        List<String> list = new ArrayList<String>();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            String name=jUser.getString("userName");
            list.add(name);
        }
       UserCourseList user=new UserCourseList();
        user.setUserName(list);
        userService.selectAll(user.getUserName());
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 退出登陆
     * @return
     * @throws Exception
     */
    @RequestMapping("/exit")
    @ResponseBody
    public Result exit(HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession(false);//防止创建Session

        session.invalidate();

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
}
