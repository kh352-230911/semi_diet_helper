package com.sh.diet.qaboard.model.dao;

import com.sh.diet.qaboard.model.entity.AnswerBoard;
import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.vo.QuestionBoardVo;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class QuestionBoardDao {
    public List<QuestionBoard> findAll(SqlSession session) {
        return session.selectList("qaBoard.findAll");
    }

    public QuestionBoardVo findById(SqlSession session, String qbNo) {
        return session.selectOne("qaBoard.findById",qbNo);
    }

    public int insertQuestionBoard(SqlSession session, QuestionBoard questionBoard) {
        return session.insert("qaBoard.insertQuestionBoard",questionBoard);
    }

    public int updateQuestionBoard(SqlSession session, QuestionBoard questionBoard) {
        return session.update("qaBoard.updateQuestionBoard",questionBoard);
    }

    public int deleteQuestionBoard(SqlSession session, String qbNo) {
        return session.delete("qaBoard.deleteQuestionBoard",qbNo);
    }

    public int getTotalCount(SqlSession session) {
        return session.selectOne("qaBoard.getTotalCount");
    }

    public List<QuestionBoardVo> findAll(SqlSession session, Map<String, Object> param) {
        int page = (int) param.get("page");
        int limit = (int) param.get("limit");
        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        return session.selectList("qaBoard.findAll", param, rowBounds);
    }

    public AnswerBoard findByAnswerBoardacNo(SqlSession session, String acNo) {
        return session.selectOne("qaBoard.findByAnswerBoardacNo", acNo);
    }

    public int insertAnswerBoard(SqlSession session, AnswerBoard answerBoard) {
        return session.insert("qaBoard.insertAnswerBoard", answerBoard);
    }

    public int updateAnswerBoard(SqlSession session, AnswerBoard answerBoard) {
        return session.update("qaBoard.updateAnswerBoard", answerBoard);
    }

    public AnswerBoard findByIdAnswer(SqlSession session, String acNo) {
        return session.selectOne("qaBoard.findByIdAnswer", acNo);
    }

    public int deleteAnswerBoard(SqlSession session, String acNo) {
        return session.delete("qaBoard.deleteAnswerBoard", acNo);
    }
}
