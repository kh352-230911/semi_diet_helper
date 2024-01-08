package com.sh.diet.exercise.model.dao;

import com.sh.diet.exercise.model.entity.ScrapExercise;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ScrapExerciseDao {
    public List<ScrapExercise> findAll(SqlSession session) {
        return session.selectList("scrap.findAll");
    }

    public ScrapExercise findByExScrapNo(SqlSession session, String exScrapNo) {
        return session.selectOne("scrap.findByExScrapNo", exScrapNo);
    }

    public int insertScrapExercise(SqlSession session, ScrapExercise scrapExercise) {
        return session.insert("scrap.insertScrapExercise", scrapExercise);
    }

    public int deleteScrapExercise(SqlSession session, String exScrapNo) {
        return session.delete("scrap.deleteScrapExercise", exScrapNo);
    }

    public List<ScrapExercise> findExScrapByMemberNo(SqlSession session, String memberNo) {
        return session.selectList("scrap.findExScrapByMemberNo", memberNo);
    }
}
