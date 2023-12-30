package com.sh.diet.board.model.dao;

import com.sh.diet.board.model.entity.QuestionBoard;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class QuestionBoardDao {
    public List<QuestionBoard> findAll(SqlSession session) {
        return session.selectList("semitest.findAll");
    }
}
