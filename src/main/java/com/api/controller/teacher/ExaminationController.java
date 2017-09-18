package com.api.controller.teacher;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.enume.ResultEnum;
import com.api.model.common.Result;
import com.api.model.teaching.examination.ExaminationQuestions;
import com.api.model.teaching.examination.TestPaper;
import com.api.model.teaching.examination.TestScore;
import com.api.service.teacher.ExaminationQuestionsService;
import com.api.service.teacher.TestPaperService;
import com.api.service.teacher.TestScoreService;
import com.api.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/18.
 * 考试管理
 */
@RestController
public class ExaminationController {
    @Autowired
    private ExaminationQuestionsService examinationQuestionsService;

    @Autowired
    private TestPaperService testPaperService;

    @Autowired
    private TestScoreService testScoreService;

    /**
     * 添加试题
     * @param examinationQuestions
     * @return
     */
    @RequestMapping (value = "/examination/addExaminationQuestions", method = RequestMethod.POST)
    @ResponseBody
    public Result addExaminationQuestions (ExaminationQuestions examinationQuestions, @RequestParam(value = "answer",required = false) String answer) {
        JSONArray jsonArray =JSONArray.parseArray(answer);
        StringBuilder sb=new StringBuilder();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            sb.append(jUser.getString("answer"));
            if(i != jsonArray.size() - 1) {
                sb.append(",");
            }
        }
        examinationQuestionsService.addExaminationQuestions(examinationQuestions,sb.toString());
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,examinationQuestions);
    }

    /**
     * 遍历题库
     * @param examinationQuestions 动态条件
     * @return
     */
    @RequestMapping (value = "/examination/searchExaminationQuestionsList", method = RequestMethod.GET)
    @ResponseBody
    public Result searchExaminationQuestionsList (ExaminationQuestions examinationQuestions, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);//分页
        List<ExaminationQuestions> searchExaminationQuestionsList =
                examinationQuestionsService.searchExaminationQuestionsList(examinationQuestions);
        Page<ExaminationQuestions> listCountry = (Page<ExaminationQuestions>)searchExaminationQuestionsList;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }

    /**
     * 删除试题（提供批量删除和单条删除）
     * jquery提交delete时，不支持@RequestParam，只支持@PathVariable形式
     * @return
     */
    @RequestMapping (value = "/examination/deleteExaminationQuestions", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteExaminationQuestions (@RequestParam(value = "examId",required = true) String examId ) {
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
        examinationQuestionsService.deleteExaminationQuestions(list);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 修改试题
     * @param examinationQuestions 修改参数对象
     * @return
     */
    @RequestMapping (value = "/examination/updateExaminationQuestions", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateExaminationQuestions (ExaminationQuestions examinationQuestions,@RequestParam(value = "answer",required = false) String answer) {
        JSONArray jsonArray =JSONArray.parseArray(answer);
        StringBuilder sb=new StringBuilder();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            sb.append(jUser.getString("answer"));
            if(i != jsonArray.size() - 1) {
                sb.append(",");
            }
        }
       examinationQuestionsService.updateExaminationQuestions(examinationQuestions,sb.toString());
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }




    /**
     * 添加试卷
     * @param testPaper
     * @return
     */
    @RequestMapping (value = "/examination/addTestPaper", method = RequestMethod.POST)
    @ResponseBody
    public Result addTestPaper (TestPaper testPaper) {
        testPaperService.addTestPaper(testPaper);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,testPaper);
    }

    /**
     * 遍历试卷
     * @param testPaper 动态条件
     * @return
     */
    @RequestMapping (value = "/examination/searchTestPaperList", method = RequestMethod.GET)
    @ResponseBody
    public Result searchTestPaperList (TestPaper testPaper,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);//分页
        List<TestPaper> searchTestPaperList =
                testPaperService.searchTestPaperList(testPaper);
        Page<TestPaper> listCountry = (Page<TestPaper>)searchTestPaperList;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }

    /**
     * 删除试卷（提供批量删除和单条删除）
     * @return
     */
    @RequestMapping (value = "/examination/deleteTestPaper", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteTestPaper (@RequestParam(value = "paperId",required = true) String paperId ) {
        JSONArray jsonArray =JSONArray.parseArray(paperId);
        List<Integer> list = new ArrayList<Integer>();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            Integer id=jUser.getInteger("paperId");
            list.add(id);
        }
        testPaperService.deleteTestPaper(list);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 修改试卷
     * @param testPaper 修改参数对象
     * @return
     */
    @RequestMapping (value = "/examination/updateTestPaper", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateTestPaper (TestPaper testPaper) {
        testPaperService.updateTestPaper(testPaper);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /** 试卷添加试题*/
    @RequestMapping(value = "/examination/testpaperAddingQuestions",method = RequestMethod.POST)
    public Result testpaperAddingQuestions(@RequestParam(value = "examId",required = true) String examId,@RequestParam("id") Integer id) {
        //examId="[ { \"examId\": \"5\" }, { \"examId\": \"7\"}]";
        StringBuilder stringBuilder = new StringBuilder();
        JSONArray jsonArray =JSONArray.parseArray(examId);
        List<Integer> list = new ArrayList<Integer>();
        if (jsonArray.size() == 0) {
            return ResultUtil.ERROR(ResultEnum.PARAMETER_MISSING.getCode(),ResultEnum.PARAMETER_MISSING.getMsg());
        }
        JSONObject jUser = null;
        for (int i=0;i<jsonArray.size();i++) {
            jUser = jsonArray.getJSONObject(i);
            stringBuilder.append(jUser.getInteger("examId"));
            if (i != jsonArray.size() - 1) {
                stringBuilder.append(",");
            }
        }
        TestPaper tp=testPaperService.searchTestPaper(id);
        if (null != tp.getTestSet()) {
            String[] news=stringBuilder.toString().split(",");
            String[]  old=tp.getTestSet().split(",");
            Set set = new HashSet<Integer>();
            for(int i = 0; i < news.length ; i++){
                set.add(news[i]);
            }
            for(int i = 0; i < old.length ; i++){
                set.add(old[i]);
            }
            stringBuilder.delete(0,stringBuilder.length());//将之前保存的清空
            Iterator i = set.iterator();
            while(i.hasNext()){
                String value = (String) i.next();
                stringBuilder.append(value);
                if(i.hasNext()) {//最后一个元素不加逗号
                    stringBuilder.append(",");
                }
            }
        }
        TestPaper testPaper= new TestPaper();
        testPaper.setTestSet(stringBuilder.toString());
        testPaper.setId(id);
        testPaperService.testpaperAddingQuestions(testPaper);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS);
    }

    /**
     * 打开试卷
     * @param paperId
     * @return
     */
    @RequestMapping (value = "/examination/searchTestPaper/{paperId}", method = RequestMethod.GET)
    @ResponseBody
    public Result searchTestPaperList (@PathVariable("paperId") Integer paperId) {
       TestPaper testPaper =
                testPaperService.searchTestPaper(paperId);
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS,testPaper);
    }

    /**
     * 考试阅卷
     * @param paperId 试卷id
     * @param answer 考试结果
     * @param userId 参考者
     * @return
     */
    @RequestMapping (value = "/examination/marking", method = RequestMethod.POST)
    @ResponseBody
    public Result marking (@RequestParam("paperId") Integer paperId,
                           @RequestParam(value = "answer",required = false) String answer,@RequestParam("userId")Integer userId) {
        //answer="[ { \"answer\": \"bcd\" }, { \"answer\": \"d\"}, { \"answer\": \"d\"}, { \"answer\": \"a\"}, { \"answer\": \"c\"}]";
        Result result = testPaperService.marking(paperId,answer,userId);
        return result;
    }

    /**
     * 考试成绩查询
     * @param testScore
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/examination/searchTestScore",method = RequestMethod.GET)
    public Result searchTestScoreList(TestScore testScore,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);//分页
        List<TestScore> testScoreLsit = testScoreService.searchTestScoreList(testScore);
        Page<TestScore> listCountry = (Page<TestScore>)testScoreLsit;
        return ResultUtil.SUCCESS(ResultEnum.SUCCESS, listCountry,listCountry.getTotal(),
                listCountry.getPages(),listCountry.getPageNum(),listCountry.getPageSize());
    }
}
