package com.sh.diet.qaboard.model.service;

import com.sh.diet.qaboard.model.dao.QuestionBoardDao;
import com.sh.diet.qaboard.model.entity.AnswerBoard;
import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.vo.AnswerBoardVo;
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

    public List<AnswerBoardVo> findByAnswerBoardqbNo(String qbNo){
        SqlSession session = getSqlSession();
        List<AnswerBoardVo> answerBoardVo = questionBoardDao.findByAnswerBoardqbNo(session, qbNo);
        session.close();
        return answerBoardVo;
    }

    public QuestionBoardVo findById(String qbNo) {
        SqlSession session = getSqlSession();
        QuestionBoardVo questionBoardVo = questionBoardDao.findById(session, qbNo);
        session.close();
        return questionBoardVo;
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
    public int updateQuestionBoard(QuestionBoardVo questionBoardVo) {
        int result = 0;
        SqlSession session =getSqlSession();
        try{
            result = questionBoardDao.updateQuestionBoard(session, questionBoardVo);
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

    public int getTotalCount(Map<String, Object> param) {
    SqlSession session = getSqlSession();
    int totalCount = questionBoardDao.getTotalCount(session, param);
    session.close();
    return totalCount;
}

    public List<QuestionBoardVo> findAll(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        List<QuestionBoardVo> questionBoardvos = questionBoardDao.findAll(session, param);
        session.close();
        return questionBoardvos;
    }


    public int linkCountAnswerBoard(String acNo) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = questionBoardDao.linkCountAnswerBoard(session,acNo);
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


