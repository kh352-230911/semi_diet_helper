package com.sh.diet.qaboard.model.service;

import com.sh.diet.qaboard.model.dao.QaBoardDao;
import com.sh.diet.qaboard.model.entity.QaBoard;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
public class QaBoardService {
    private QaBoardDao qaBoardDao = new QaBoardDao();

    public List<QaBoard> findAll() {
        SqlSession session = getSqlSession();
        List<QaBoard> qaBoards = qaBoardDao.findAll(session);
        session.close();
        return qaBoards;
    }

    public QaBoard findById(String qbNo) {
        SqlSession session = getSqlSession();
        QaBoard qaBoard = qaBoardDao.findById(session, qbNo);
        session.close();
        return qaBoard;
    }

    public int insertQaBoard(QaBoard qaBoard) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = qaBoardDao.insertQaBoard(session, qaBoard);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }


    public int updateQaBoard(QaBoard qaBoard) {
        int result = 0;
        SqlSession session =getSqlSession();
        try{
            result = qaBoardDao.updateQaBoard(session, qaBoard);
            session.commit();
        } catch (Exception e){
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int deleteQaBoard(String qbNo) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result =qaBoardDao.deleteQaBoard(session,qbNo);
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
        int totalCount = qaBoardDao.getTotalCount(session);
        session.close();
        return totalCount;
    }

    public List<QaBoard> findAll(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        List<QaBoard> qaBoards = qaBoardDao.findAll(session, param);
        session.close();
        return qaBoards;
    }
}

