package com.sh.diet.exBoard.model.service;


import com.sh.diet.exBoard.model.dao.ExerciseDao;
import com.sh.diet.exBoard.model.entity.ExerciseData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class ExerciseService {

    private ExerciseDao exerciseDao = new ExerciseDao();

    public List<ExerciseData> findAll() {
        SqlSession session = getSqlSession();
        List<ExerciseData> exerciseDatas = exerciseDao.findAll(session);
        session.close();
        return exerciseDatas;
    }
}
