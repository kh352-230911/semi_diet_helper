package com.sh.diet.exercise.model.service;

import com.sh.diet.exercise.model.dao.ScrapExerciseDao;
import com.sh.diet.exercise.model.entity.ScrapExercise;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class ScrapExerciseService {
    private ScrapExerciseDao scrapExerciseDao = new ScrapExerciseDao();

    public List<ScrapExercise> findAll() {
        SqlSession session = getSqlSession();
        List<ScrapExercise> scrapExercises= scrapExerciseDao.findAll(session);
        session.close();
        return scrapExercises;
    }

    public ScrapExercise findByExScrapNo(String exScrapNo) {
        SqlSession session = getSqlSession();
        ScrapExercise scrapExercise = scrapExerciseDao.findByExScrapNo(session, exScrapNo);
        session.close();
        return scrapExercise;
    }

    public int insertScrapExercise(ScrapExercise scrapExercise) {
        int result = 0;
        SqlSession session = getSqlSession();

        try {
            result = scrapExerciseDao.insertScrapExercise(session, scrapExercise);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }

        return result;
    }

    public int deleteScrapExercise(String exScrapNo) {
        int result = 0;
        SqlSession session = getSqlSession();

        try {
            result = scrapExerciseDao.deleteScrapExercise(session, exScrapNo);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public List<ScrapExercise> findExScrapByMemberNo(String memberNo) {
        SqlSession session = getSqlSession();
        List<ScrapExercise> scrapExercises = scrapExerciseDao.findExScrapByMemberNo(session,memberNo);
        session.close();
        return scrapExercises;
    }

    public ScrapExercise findByScrapChecker(ScrapExercise scrapExercise) {
        SqlSession session = getSqlSession();
        ScrapExercise _scrapExercise = scrapExerciseDao.findByScrapChecker(session, scrapExercise);
        session.close();
        return _scrapExercise;

    }
}
