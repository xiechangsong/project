package com.api.controller.system;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.system.letter.MsgReceive;
import com.api.model.teaching.course.UserCourseList;
import com.api.model.user.User;
import com.api.service.system.MsgReceiveService;
import com.api.service.user.UserService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
@RestController
public class MsgReceiveController {
    private Logger logger = Logger.getLogger(SubjectController.class);

    @Autowired
    private MsgReceiveService msgReceiveService;
    @Autowired
    private UserService userService;

    /**
     * 依据用户名批量查找ID添加消息
     * @param userName
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/MsgReceive/insertMsgReceive",method = RequestMethod.POST)
    public Result selectAll(@RequestParam(value = "userName",required = false) String userName, MsgReceive msgReceive)throws Exception  {
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
        List<User> lists=  userService.selectAll(user.getUserName());


        for (int i = 0; i < lists.size(); i++) {
            User obj=(User)lists.get(i);
            long id = obj.getId();//通过这个对象就能获得了
            msgReceive.setReceivingCusId(id);
            msgReceiveService.insertAllMsgReceive(msgReceive);
        }
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);

    }

    @RequestMapping(value = "/MsgReceive/selectMsgReceive", method = RequestMethod.POST)
    @ResponseBody
    public Result selectMsgReceive(MsgReceive msgReceive, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<MsgReceive> list = msgReceiveService.selectAddMsgReceive(msgReceive);

        Page<MsgReceive> listCountry = (Page<MsgReceive>)list;

        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, list,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }


    @RequestMapping(value = "/MsgReceive/deleteMsgSystem", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteMsgReceive(@RequestParam(value = "examId",required = true) String examId ) {
        //examId="[ { \"examId\": \"1\" }, { \"examId\": \"2\"}]";
        JSONArray jsonArray =JSONArray.parseArray(examId);
        List<Integer> list = new ArrayList<Integer>();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            Integer id=jUser.getInteger("examId");
            list.add(id);
        }
        msgReceiveService.deleteMsgReceive(list);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

}
