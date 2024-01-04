package com.sh.diet.exerciseData.dao;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.exercise.model.dao.ExerciseDataDao;
import com.sh.diet.exercise.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;


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
        List<ExerciseData> exerciseDatas = exerciseDataDao.findByAll(session);

        exerciseDatas.forEach((exerciseData) -> {
            assertThat(exerciseData)
                    .isNotNull();
        });
    }

//    @DisplayName("모든 ")

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



}
