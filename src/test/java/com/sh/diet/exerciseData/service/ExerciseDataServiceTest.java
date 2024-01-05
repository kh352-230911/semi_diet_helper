package com.sh.diet.exerciseData.service;


import com.sh.diet.exercise.model.entity.ExerciseData;
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
    public void beforeEach() {
        this.exerciseDataService = new ExerciseDataService();
    }

    @DisplayName("exerciseService 객체는 null이 아니다.")
    @Test
    void test1() {
        assertThat(exerciseDataService).isNotNull();
    }

    @DisplayName("운동 전체 조회")
    @Test
    void test2() {
        List<ExerciseData> exerciseDatas = exerciseDataService.findAll();
        System.out.println(exerciseDatas);
        assertThat(exerciseDatas)
                .isNotNull()
                .allSatisfy((exerciseData -> {
                    assertThat(exerciseData.getExNo()).isNotNull();
                    assertThat(exerciseData.getExName()).isNotNull();
                    assertThat(exerciseData.getKcal()).isNotZero();
                    assertThat(exerciseData.getBodyPart()).isNotNull();
                    assertThat(exerciseData.getExUrl()).isNotNull();
                }));
    }

    @DisplayName("전체 게시글 수 조회")
    @Test
    void test3(){
        int totalCount = exerciseDataService.getTotalCount();
        assertThat(totalCount).isNotNegative();
    }
}
