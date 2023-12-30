package com.sh.diet.board.model.service;

import com.sh.diet.board.model.dao.QuestionBoardDao;
import com.sh.diet.board.model.entity.QuestionBoard;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
public class QuestionBoardService {
    private QuestionBoardDao questionBoardDao = new QuestionBoardDao();

    public List<QuestionBoard> findAll() {
        SqlSession session = getSqlSession();
        List<QuestionBoard> questionBoards = questionBoardDao.findAll(session);
        session.close();
        return questionBoards;
    }
}
