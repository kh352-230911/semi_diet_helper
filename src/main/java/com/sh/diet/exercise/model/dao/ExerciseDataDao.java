package com.sh.diet.exercise.model.dao;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.exercise.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExerciseDataDao {
    public List<ExerciseData> findByName(SqlSession session, String name){
        return session.selectList("exerciseData.findByName", name);

    }
    public List<ExerciseData> findAll(SqlSession session) {
        return session.selectList("exerciseData.findAll");
    }

    public int insertDailyExercise(SqlSession session, DailyEx dailyEx) {
        return session.insert("exerciseData.insertDailyExercise", dailyEx);
    }

    public List<DailyEx> findDailyExerciseByDailyNo(SqlSession session, String dailyNo) {
        return session.selectList("exerciseData.findDailyExerciseByDailyNo", dailyNo);
    }

    public ExerciseData findByExNo(SqlSession session, String exNo) {
        return session.selectOne("exerciseData.findByExNo",exNo);
    }

    public int insertExerciseData(SqlSession session, ExerciseData exData) {
        return session.insert("exerciseData.insertExerciseData",exData);
    }
}
