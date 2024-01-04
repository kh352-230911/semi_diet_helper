package com.sh.diet.exercise.service;


import com.sh.diet.exBoard.model.entity.ExerciseData;
import com.sh.diet.exBoard.model.service.ExerciseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseServiceTest {
    ExerciseService exerciseService;

    @BeforeEach
    public void beforeEach() {
        this.exerciseService = new ExerciseService();
    }

    @DisplayName("exerciseService 객체는 null이 아니다.")
    @Test
    void test1() {
        assertThat(exerciseService).isNotNull();
    }

    @DisplayName("운동 전체 조회")
    @Test
    void test2() {
        List<ExerciseData> exerciseDatas = exerciseService.findAll();
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
}
