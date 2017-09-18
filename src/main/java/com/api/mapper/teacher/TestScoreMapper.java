package com.api.mapper.teacher;

import com.api.model.teaching.examination.TestScore;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 牛逼的小菜鸟 on 2017/7/25.
 */
@Service
public interface TestScoreMapper {

    void addTestScore (TestScore testScore);

    List<TestScore> searchTestScoreList(TestScore testScore);
}
