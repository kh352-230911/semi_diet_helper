package com.sh.diet.scrapExercise.service;

import com.sh.diet.exercise.model.entity.ScrapExercise;
import com.sh.diet.exercise.model.service.ScrapExerciseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class ScrapExerciseServiceTest {
    ScrapExerciseService scrapExerciseService;

    @BeforeEach
    public void beforeEach(){
        this.scrapExerciseService = new ScrapExerciseService();
    }

    @DisplayName("ScrapExerciseService 객체는 null이 아니다")
    @Test
    public void test1(){
        assertThat(scrapExerciseService).isNotNull();
    }

    @DisplayName("스크랩 전체조회")
    @Test
    public void test2() {
        List<ScrapExercise> scrapExercises= scrapExerciseService.findAll();
        assertThat(scrapExercises)
                .isNotNull()
                .allSatisfy((scrapExercise -> {
                    assertThat(scrapExercise.getExScrapNo()).isNotNull();
                    assertThat(scrapExercise.getMemberNo()).isNotNull();
                    assertThat(scrapExercise.getExNo()).isNotNull();
                }));
    }

    @DisplayName("존재하는 스크랩 한건 조회")
    @ParameterizedTest
    @ValueSource(strings = {"SE1", "SE2", "SE3"})
    void test2_1(String exScrapNo) {
        // given
        // when
        ScrapExercise scrapExercise = scrapExerciseService.findByExScrapNo(exScrapNo);

        // then
        // satisfies : 요소가 모든 단정문을 충족하는지 확인
        assertThat(scrapExercise)
                .isNotNull()
                .satisfies((_scrapExercise) -> {
                    // pk, 필수값 확인
                    assertThat(_scrapExercise.getExNo()).isNotNull();
                    assertThat(_scrapExercise.getExScrapNo()).isNotNull();
                    assertThat(_scrapExercise.getMemberNo()).isNotNull();
                });
    }
    @DisplayName("존재하지 않는 스크랩 한건 조회")
    @ParameterizedTest
    @ValueSource(strings = {"SE123123", "SE321312"})
    void test2_2(String exScrapNo) {
        // given
        // when
        ScrapExercise scrapExercise = scrapExerciseService.findByExScrapNo(exScrapNo);
        // then
        assertThat(scrapExercise) .isNull();
    }

    @Disabled
    @DisplayName("운동 스크랩하기")
    @Test
    void test3(){
        ScrapExercise scrapExercise = new ScrapExercise(null, "M4","E44");
        int result = scrapExerciseService.insertScrapExercise(scrapExercise);
        assertThat(result).isNotZero();
    }

    @Disabled
    @DisplayName("스크랩한 운동 삭제하기")
    @Test
    void test4(){
        String exScrapNo = "SE4";
        int result = scrapExerciseService.deleteScrapExercise(exScrapNo);
        assertThat(result).isNotZero();

        ScrapExercise scrapExercise = scrapExerciseService.findByExScrapNo(exScrapNo);
        assertThat(scrapExercise).isNull();
    }

    @DisplayName("특정 회원의 운동 스크랩 목록 출력")
    @Test
    void test5(){
        String memberNo = "M0";
        List<ScrapExercise> scrapExercises = scrapExerciseService.findExScrapByMemberNo(memberNo);
        assertThat(scrapExercises).isNotNull();
        System.out.println(scrapExercises);
    }
}
