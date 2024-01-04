package com.sh.diet.exBoard.model.dao;

import com.sh.diet.exBoard.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExerciseDao {
    public List<ExerciseData> findAll(SqlSession session) {
        return session.selectList("exercise.findAll");
    }

    public ExerciseData findByExNo(SqlSession session, String exNo) {
        return session.selectOne("exercise.findByExNo", exNo);
    }

    public int insertExerciseData(SqlSession session, ExerciseData exData) {
        return session.insert("exercise.insertExercise", exData);
    }
}
