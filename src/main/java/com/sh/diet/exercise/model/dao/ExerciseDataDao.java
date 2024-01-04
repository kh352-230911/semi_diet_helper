package com.sh.diet.exercise.model.dao;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.exercise.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExerciseDataDao {
    public List<ExerciseData> findByAll(SqlSession session) {
        return session.selectList("exerciseData.findByAll");
    }
    public List<ExerciseData> findByName(SqlSession session, String name){
        return session.selectList("exerciseData.findByName", name);

    }

    public int insertDailyExercise(SqlSession session, DailyEx dailyEx) {
        return session.insert("exerciseData.insertDailyExercise", dailyEx);
    }

    public List<DailyEx> findDailyExerciseByDailyNo(SqlSession session, String dailyNo) {
        return session.selectList("exerciseData.findDailyExerciseByDailyNo", dailyNo);
    }
}
