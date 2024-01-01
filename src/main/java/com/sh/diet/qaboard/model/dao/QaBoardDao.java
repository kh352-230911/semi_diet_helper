package com.sh.diet.qaboard.model.dao;

import com.sh.diet.qaboard.model.entity.QaBoard;
import com.sh.diet.qaboard.model.entity.QaDetailBoard;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class QaBoardDao {
    public List<QaBoard> findAll(SqlSession session) {
        return session.selectList("qaBoard.findAll");
    }

    public QaBoard findById(SqlSession session, String qbNo) {
        return session.selectOne("qaBoard.findById",qbNo);
    }

    public int insertQaBoard(SqlSession session, QaBoard qaBoard) {
        return session.insert("qaBoard.insertQaBoard",qaBoard);
    }

    public int updateQaBoard(SqlSession session, QaBoard qaBoard) {
        return session.update("qaBoard.updateQaBoard",qaBoard);
    }

    public int deleteQaBoard(SqlSession session, String qbNo) {
        return session.delete("qaBoard.deleteQaBoard",qbNo);
    }

    public int getTotalCount(SqlSession session) {
        return session.selectOne("qaBoard.getTotalCount");
    }
        public List<QaBoard> findAll(SqlSession session, Map<String, Object> param) {
        int page = (int) param.get("page");
        int limit = (int) param.get("limit");
        int offset = (page - 1) * limit;
        return session.selectList("qaBoard.findAll", null, new RowBounds(offset, limit));
    }

    public QaDetailBoard findByQaDetailBoardacNo(SqlSession session, String acNo) {
        return session.selectOne("qaBoard.findByQaDetailBoardacNo", acNo);
    }

    public int insertQadetailBoard(SqlSession session, QaDetailBoard qaDetailBoard) {
        return session.insert("qaBoard.insertQadetailBoard", qaDetailBoard);
    }
}
