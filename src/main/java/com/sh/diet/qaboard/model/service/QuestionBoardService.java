package com.sh.diet.qaboard.model.service;

import com.sh.diet.qaboard.model.dao.QuestionBoardDao;
import com.sh.diet.qaboard.model.entity.AnswerBoard;
import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.vo.QuestionBoardVo;
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
    public AnswerBoard findByAnswerBoardacNo(String acNo){
        SqlSession session = getSqlSession();
        AnswerBoard answerBoard = questionBoardDao.findByAnswerBoardacNo(session, acNo);
        session.close();
        return answerBoard;
    }
    public AnswerBoard findByIdAnswer(String acNo){
        SqlSession session = getSqlSession();
        AnswerBoard answerBoard = questionBoardDao.findByIdAnswer(session, acNo);
        session.close();
        return answerBoard;
    }
    public QuestionBoardVo findById(String qbNo) {
        SqlSession session = getSqlSession();
        QuestionBoardVo questionBoardvo = questionBoardDao.findById(session, qbNo);
        session.close();
        return questionBoardvo;
    }
    public int insertAnswerBoard(AnswerBoard answerBoard){
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = questionBoardDao.insertAnswerBoard(session, answerBoard);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
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

    public int updateAnswerBoard(AnswerBoard answerBoard){
        int result = 0;
        SqlSession session =getSqlSession();
        try{
            result = questionBoardDao.updateAnswerBoard(session, answerBoard);
            session.commit();
        } catch (Exception e){
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

    public int deleteAnswerBoard(String acNo){
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = questionBoardDao.deleteAnswerBoard(session,acNo);
            session.commit();
        } catch (Exception e) {
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

    public List<QuestionBoardVo> findAll(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        List<QuestionBoardVo> questionBoardvos = questionBoardDao.findAll(session, param);
        session.close();
        return questionBoardvos;
    }
}

