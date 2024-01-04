package com.sh.diet.exercise.model.service;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.exercise.model.dao.ExerciseDataDao;
import com.sh.diet.exercise.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class ExerciseDataService{

    ExerciseDataDao exerciseDataDao = new ExerciseDataDao();
    public List<ExerciseData> findByName(String name) {
        SqlSession session = getSqlSession();
        List<ExerciseData> exerciseDatas = exerciseDataDao.findByName(session, name);
        session.close();
        return exerciseDatas;
    }

    public int insertDailyExercise(DailyEx dailyEx) {
        int result = 0;
        SqlSession session = getSqlSession();
        return exerciseDataDao.insertDailyExercise(session, dailyEx);
    }

    public List<DailyEx> findDailyExerciseByDailyNo(String dailyNo) {
        SqlSession session = getSqlSession();
        List<DailyEx> dailyRecodes = exerciseDataDao.findDailyExerciseByDailyNo(session, dailyNo);
        return dailyRecodes;
    }

}
