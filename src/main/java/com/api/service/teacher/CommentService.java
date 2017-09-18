package com.api.service.teacher;

import com.api.mapper.teacher.CommentMapper;
import com.api.model.teaching.common.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public  void addComment(Comment comment){
        commentMapper.addComment(comment);
    }


    public List<Comment> selectComment(Comment comment){
        List<Comment> list = commentMapper.selectComment(comment);
        return list;
    }
    public Comment selectCommentById(int id){
        Comment comment= commentMapper.selectCommentById(id);
        return  comment;
    };
    public void updateComment(Comment comment){
         commentMapper.updateComment(comment);
    };

    public   void deleteComment(List<Integer> idList){
        commentMapper.deleteComment(idList);
    }
}
