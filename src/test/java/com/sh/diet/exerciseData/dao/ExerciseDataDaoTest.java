package com.sh.diet.exerciseData.dao;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.exercise.model.dao.ExerciseDataDao;
import com.sh.diet.exercise.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;


public class ExerciseDataDaoTest {

    ExerciseDataDao exerciseDataDao;
    SqlSession session;

    @BeforeEach
    void setUp(){
        this.exerciseDataDao = new ExerciseDataDao();
        this.session = getSqlSession();
    }

    @AfterEach
    void tearDown(){
        this.session.rollback();
        this.session.close();
    }

    @DisplayName("모든 ExerciseData를 조회할 수 있습니다.")
    @Test
    public void test1(){
        List<ExerciseData> exerciseDatas = exerciseDataDao.findAll(session);

        exerciseDatas.forEach((exerciseData) -> {
            assertThat(exerciseData)
                    .isNotNull();
        });
    }

    @DisplayName("존재하는 운동 한 건 조회")
    @ParameterizedTest
    @ValueSource(strings  = {"E2", "E21", "E22"})
    public void test2(String exNo) {
        ExerciseData exerciseData = exerciseDataDao.findByExNo(session, exNo);

        assertThat(exerciseData)
                .isNotNull()
                .satisfies((exData) ->{
                    assertThat(exData.getExNo()).isNotNull();
                    assertThat(exData.getExUrl()).isNotNull();
                    assertThat(exData.getKcal()).isNotZero();
                    assertThat(exData.getBodyPart()).isNotNull();
                });
    }

    @DisplayName("운동이름으로 ExerciseData를 조회할 수 있습니다.")
    @Test
    public void test3(){
        String exerciseName = "달리기";
        List<ExerciseData> exerciseDatas = exerciseDataDao.findByName(session, exerciseName);

        exerciseDatas.forEach((exerciseData) -> {
            assertThat(exerciseData.getExName())
                    .isNotNull()
                    .isEqualTo("달리기");
        });
    }

    @DisplayName("운동기록을 저장할 수 있습니다.")
    @Test
    public void test4(){
        int result = 0;
        DailyEx dailyEx = new DailyEx("DE5", "E2", "DR2", 20);
        result =  exerciseDataDao.insertDailyExercise(session, dailyEx);
        assertThat(result)
                .isEqualTo(1);

    }

    @DisplayName("존재하지 않는 운동 조회")
    @ParameterizedTest
    @ValueSource(strings = {"M1", "M2","M3"})
    public void test5(String exNo){
        ExerciseData exerciseData = exerciseDataDao.findByExNo(session, exNo);
        assertThat(exerciseData).isNull();
    }

    @DisplayName("운동 등록")
    @Test
    void test6(){
        ExerciseData exData = new ExerciseData(null,"운동명",100, "운동부위","운동영상url");
        int result = exerciseDataDao.insertExerciseData(session, exData);
        System.out.println(exData);



        // ExerciseData exDataInserted = exerciseDataDao.findByExNo(session, exNo);

        // assertThat(result).isGreaterThan(0);
    }

    @DisplayName("특정 카테고리 운동들을 조회")
    @Test
    void test7() {
        String bodyPart = "유산소";
        List<ExerciseData> exerciseDatas = exerciseDataDao.findByBodyPart(session, bodyPart);

        System.out.println(exerciseDatas);

        assertThat(exerciseDatas)
                .isNotNull()
                .allSatisfy((exerciseData) ->{
                    assertThat(exerciseData.getBodyPart()).isEqualTo(bodyPart);
                    assertThat(exerciseData.getExNo()).isNotNull();
                    assertThat(exerciseData.getKcal()).isNotZero();
                    assertThat(exerciseData.getExUrl()).isNotNull();
                });

    }

    @DisplayName("운동 카테고리를 중복 없이 모아보기")
    @Test
    void test8() {
        List<String> bodyparts;
        bodyparts = exerciseDataDao.findBodyParts(session);
        System.out.println(bodyparts);
    }






    public static Stream<Arguments> exerciseNoProvider(){
        ExerciseDataDao exerciseDataDao = new ExerciseDataDao();
        List<ExerciseData> exerciseDatas = exerciseDataDao.findAll(getSqlSession());
        return Stream.of(
                Arguments.arguments(exerciseDatas.get(0).getExNo()),
                Arguments.arguments(exerciseDatas.get(1).getExNo()),
                Arguments.arguments(exerciseDatas.get(2).getExNo())
        );
    }



}
