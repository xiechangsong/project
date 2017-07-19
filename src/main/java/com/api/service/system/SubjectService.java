package com.api.service.system;

import com.api.mapper.system.SubjectMapper;
import com.api.model.system.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/6/28.
 */
@Service
public class SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    /** 新增专业*/
    public void addSubject(Subject subject) {
        subject.setCreateTime(new Date());
        subject.setStatus(0);
        subjectMapper.addSubject(subject);
    }
    /** 专业列表*/
    public List<Subject> subjectList() {
        List<Subject> subjectList=subjectMapper.subjectList();
        return subjectList;
    }
    /**
     * 删除
     * @param id
     */
    public void deleteSubject(int id) {
        subjectMapper.deleteSubject(id);
    }

    /**
     * 修改
     *@param subject 参数 修改的信息
     */
    public void updateSubject(Subject subject) {
        subjectMapper.updateSubject(subject);
    }
    /** 根据id查询单个专业信息*/
    public Subject findSubject(int id) {
        Subject subject=subjectMapper.findSubject(id);
        return subject;
    }

}
