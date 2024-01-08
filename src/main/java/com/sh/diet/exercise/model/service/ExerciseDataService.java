package com.sh.diet.exercise.model.service;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.exercise.model.dao.ExerciseDataDao;
import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.entity.ScrapExercise;
import com.sh.diet.exercise.model.vo.ExerciseDataVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class ExerciseDataService{

    ExerciseDataDao exerciseDataDao = new ExerciseDataDao();

    public List<ExerciseData> findByBodyPart(String bodyPart) {
        SqlSession session = getSqlSession();
        List<ExerciseData> exerciseDatas = exerciseDataDao.findByBodyPart(session, bodyPart);
        session.close();
        return exerciseDatas;
    }

    public List<ExerciseData> findAll() {
        SqlSession session = getSqlSession();
        List<ExerciseData> exerciseDatas = exerciseDataDao.findAll(session);
        session.close();
        return exerciseDatas;
    }
    public List<ExerciseData> findByName(String name) {
        SqlSession session = getSqlSession();
        List<ExerciseData> exerciseDatas = exerciseDataDao.findByName(session, name);
        session.close();
        return exerciseDatas;
    }

    public int insertDailyExercise(DailyEx dailyEx) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = exerciseDataDao.insertDailyExercise(session, dailyEx);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public List<DailyEx> findDailyExerciseByDailyNo(String dailyNo) {
        SqlSession session = getSqlSession();
        List<DailyEx> dailyRecodes = exerciseDataDao.findDailyExerciseByDailyNo(session, dailyNo);
        session.close();
        return dailyRecodes;
    }

    public List<String> findBodyParts() {
        SqlSession session = getSqlSession();
        List<String> bodyparts = exerciseDataDao.findBodyParts(session);
        session.close();
        return bodyparts;
    }

    public int getTotalCount() {
        SqlSession session = getSqlSession();
        int totalCount = exerciseDataDao.getTotalCount(session);
        session.close();
        return totalCount;
    }


    public ExerciseDataVo checkScrapExbyMemberNo(ExerciseDataVo exDataVo) {
        SqlSession session = getSqlSession();
        ExerciseDataVo _exDataVo = exerciseDataDao.checkScrapExbyMemberNo(session, exDataVo);
        session.close();
        return _exDataVo;
    }

    public ExerciseData findByExNo(String exNo) {
        SqlSession session = getSqlSession();
        ExerciseData exerciseData = exerciseDataDao.findByExNo(session, exNo);
        session.close();
        return exerciseData;
    }

    public int deleteExerciseData(String exNo) {
        int result=0;
        SqlSession session = getSqlSession();
        try {
            result = exerciseDataDao.deleteExerciseData(session, exNo);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int insertExerciseData(ExerciseData exerciseData) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = exerciseDataDao.insertExerciseData(session,exerciseData);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
}
