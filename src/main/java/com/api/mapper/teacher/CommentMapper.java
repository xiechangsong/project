package com.api.mapper.teacher;

import com.api.model.teaching.common.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public interface CommentMapper {

    /** 添加评论*/
   public  void addComment(Comment comment);


    /** 查询所有评论*/
    public List<Comment> selectComment(Comment comment);

    /** 依据单个对象查询指定评论*/
    public Comment selectCommentById(int id);

    /** 修改评论*/
    public void updateComment(Comment comment);

    /**批量删除*/
    public   void deleteComment(List<Integer> idList);
}
