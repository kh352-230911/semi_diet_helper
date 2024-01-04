package com.sh.diet.exercise.dao;

import com.sh.diet.exBoard.model.dao.ExerciseDao;
import com.sh.diet.exBoard.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import javax.websocket.Session;

import java.util.List;
import java.util.stream.Stream;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseDaoTest {
    static final int LIMIT = 10;

    ExerciseDao exerciseDao;
    SqlSession session;

    @BeforeEach
    void setUp(){
        this.exerciseDao = new ExerciseDao();
        this.session = getSqlSession();
    }

    @AfterEach
    void tearDown(){
        this.session.rollback();
        this.session.close();
    }

    @DisplayName("존재하는 운동 한 건 조회")
    @ParameterizedTest
    @ValueSource(strings  = {"E2", "E21", "E22"})
    public void test1(String exNo) {
        ExerciseData exerciseData = exerciseDao.findByExNo(session, exNo);

        assertThat(exerciseData)
                .isNotNull()
                .satisfies((exData) ->{
                    assertThat(exData.getExNo()).isNotNull();
                    assertThat(exData.getExUrl()).isNotNull();
                    assertThat(exData.getKcal()).isNotZero();
                    assertThat(exData.getBodyPart()).isNotNull();
                });
    }

    @DisplayName("존재하지 않는 운동 조회")
    @ParameterizedTest
    @ValueSource(strings = {"M1", "M2","M3"})
    public void test2(String exNo){
        ExerciseData exerciseData = exerciseDao.findByExNo(session, exNo);
        assertThat(exerciseData).isNull();
    }

    @DisplayName("운동 등록")
    @Test
    void test3(){
        ExerciseData exData = new ExerciseData("E0","운동명",100, "운동부위","운동영상url");
        int result = exerciseDao.insertExerciseData(session, exData);
        System.out.println(exData);

        String exNo = exData.getExNo();
        ExerciseData exDataInserted = exerciseDao.findByExNo(session, exNo);

        assertThat(result).isGreaterThan(0);


    }


    public static Stream<Arguments> exerciseNoProvider(){
        ExerciseDao exerciseDao = new ExerciseDao();
        List<ExerciseData> exerciseDatas = exerciseDao.findAll(getSqlSession());
        return Stream.of(
                Arguments.arguments(exerciseDatas.get(0).getExNo()),
                Arguments.arguments(exerciseDatas.get(1).getExNo()),
                Arguments.arguments(exerciseDatas.get(2).getExNo())
        );
    }
}
