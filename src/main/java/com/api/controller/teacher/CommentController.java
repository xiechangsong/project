package com.api.controller.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.common.Comment;
import com.api.model.teaching.praise.Praise;
import com.api.model.user.User;
import com.api.service.teacher.CommentService;
import com.api.service.teacher.PraiseService;
import com.api.service.user.UserService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PraiseService praiseService;

    @Autowired
    private UserService userService;


    /**
     * 添加评论，回复，问答
     * @param comment
     * @return
     */
    @RequestMapping(value = "/comment/addComment", method = RequestMethod.POST)
    @ResponseBody
    public Result addComment(Comment comment) {
        User user = userService.getUserInfo(comment.getUserName());
        comment.setUserId(user.getId());
        comment.setEmail(user.getEmail());
        comment.setPicImg(user.getPic_path());
        commentService.addComment(comment);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 查询评论，回复，问答
     * @param comment
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/comment/selectComment", method = RequestMethod.POST)
    @ResponseBody
    public Result selectComment(Comment comment, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);//分页
        List<Comment>  list =  commentService.selectComment(comment);
        Page<Comment> listCountry = (Page<Comment>)list;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }

    /**
     *修改评论，回复，问答
     * @param comment
     * @return
     */
    @RequestMapping(value = "/comment/updateComment", method = RequestMethod.POST)
    @ResponseBody
    public Result updateComment(Comment comment) {
                commentService.updateComment(comment);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }
    /**
     *删除评论，回复，问答
     * @return
     */
    @RequestMapping(value = "/comment/deleteComment", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteComment(@RequestParam(value = "examId",required = true) String examId ) {
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
        commentService.deleteComment(list);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }


    /**
     * 添加点赞和取消点赞
     * @param praise
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/comment/addCommentPraise", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Result addCommentPraise(Praise praise) throws Exception{
        Comment comment =commentService.selectCommentById(praise.getTargetId());
        int count = comment.getPraiseCount();
        boolean i  =praiseService.selectPraise(praise);
        if (i){
            praiseService.deletePraise(praise);
            count--;
            comment.setPraiseCount(count);
            commentService.updateComment(comment);
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
        }else {
            praiseService.addPraise(praise);
            count++;
            comment.setPraiseCount(count);
            commentService.updateComment(comment);
            return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
        }

    }
}
