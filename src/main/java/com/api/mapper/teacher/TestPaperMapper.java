package com.api.mapper.teacher;

import com.api.model.teaching.examination.TestPaper;

import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 试卷
 */
public interface TestPaperMapper {

    /**添加试卷*/
    void addTestPaper(TestPaper testPaper);

    /**遍历所有试卷 包含动态条件搜索*/
    List<TestPaper> searchTestPaperList (TestPaper testPaper);

    /**删除试卷（可单独删除也可批量删除）*/
    void deleteTestPaper (List<Integer> idList);

    /** 修改试卷*/
    void updateTestPaper(TestPaper testPaper);

    /**试卷添加试题*/
    void testpaperAddingQuestions (TestPaper testPaper);

    /**根据ID检索试卷*/
    TestPaper searchTestPaper (Integer id);

}
