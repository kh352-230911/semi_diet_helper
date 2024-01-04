package com.sh.diet.exerciseData.service;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.exercise.model.service.ExerciseDataService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseDataServiceTest {

    ExerciseDataService exerciseDataService;

    @BeforeEach
    public void beforeEach(){
        exerciseDataService = new ExerciseDataService();
//        session = getSqlSession();
    }

    @AfterEach
    public void afterEach(){
//        session.close();
    }

//    @DisplayName("일일기록 테이블의 고유 번호로 일일 운동 기록 테이블을 조회 할 수 있습니다.")
//    @Test
//    public void test1(){
//        List<DailyEx> dailyExes = exerciseDataService.findDailyExerciseByDailyNo("DR2");
//        assertThat(dailyExes)
//                .isNotEmpty()
//                .isNotNull()
//                .allSatisfy((dailyEx) -> {
//                    assertThat(dailyEx)
//                            .isNotNull();
//                    assertThat(dailyEx.getDailyNo())
//                            .isEqualTo("DR2");
//                });
//    }
}
