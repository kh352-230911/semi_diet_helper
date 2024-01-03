package com.sh.diet.qaboard.model.service;

import com.sh.diet.qaboard.model.dao.QuestionBoardDao;
import com.sh.diet.qaboard.model.entity.QuestionBoard;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
public class QuestionBoardService {
    private QuestionBoardDao questionBoardDao = new QuestionBoardDao();

    public List<QuestionBoard> findAll() {
        SqlSession session = getSqlSession();
        List<QuestionBoard> questionBoards = questionBoardDao.findAll(session);
        session.close();
        return questionBoards;
    }

    public QuestionBoard findById(String qbNo) {
        SqlSession session = getSqlSession();
        QuestionBoard questionBoard = questionBoardDao.findById(session, qbNo);
        session.close();
        return questionBoard;
    }

    public int insertQuestionBoard(QuestionBoard questionBoard) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = questionBoardDao.insertQuestionBoard(session, questionBoard);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }


    public int updateQuestionBoard(QuestionBoard questionBoard) {
        int result = 0;
        SqlSession session =getSqlSession();
        try{
            result = questionBoardDao.updateQuestionBoard(session, questionBoard);
            session.commit();
        } catch (Exception e){
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int deleteQuestionBoard(String qbNo) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = questionBoardDao.deleteQuestionBoard(session,qbNo);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int getTotalCount() {
        SqlSession session = getSqlSession();
        int totalCount = questionBoardDao.getTotalCount(session);
        session.close();
        return totalCount;
    }

    public List<QuestionBoard> findAll(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        List<QuestionBoard> questionBoards = questionBoardDao.findAll(session, param);
        session.close();
        return questionBoards;
    }
}

