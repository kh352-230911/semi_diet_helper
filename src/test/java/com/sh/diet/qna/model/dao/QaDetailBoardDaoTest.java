package com.sh.diet.qna.model.dao;

import com.sh.diet.qaboard.model.dao.QaBoardDao;
import com.sh.diet.qaboard.model.entity.QaDetailBoard;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class QaDetailBoardDaoTest {
    private QaBoardDao qaBoardDao;
    private SqlSession session;

    @BeforeEach
    public void setUp() {
        this.qaBoardDao = new QaBoardDao();
        this.session = getSqlSession();
    }

    @AfterEach
    public void tearDown() {
        this.session.rollback();
        this.session.close();
    }
    @DisplayName("BoardDao, SqlSession은 null이 아니다.")
    @Test
    void test1() {
        assertThat(qaBoardDao).isNotNull();
        assertThat(session).isNotNull();
    }
    @DisplayName("특정 게시글에 대한 답글조회")
    @Test
    void test2(){
        String acNo = "19";
        QaDetailBoard qaDetailBoard = qaBoardDao.findByQaDetailBoardacNo(session,acNo);
        assertThat(qaDetailBoard).isNotNull();
                    assertThat(qaDetailBoard.getMemberNo()).isNotNull();
                    assertThat(qaDetailBoard.getAcNo()).isEqualTo(acNo);
                    assertThat(qaDetailBoard.getContent()).isNotNull();
                    assertThat(qaDetailBoard.getRegDate()).isNotNull();
                    System.out.println(qaDetailBoard);
    }
    @DisplayName("답글 등록")
    @ParameterizedTest
    @CsvSource({"2,8,제발답글등록되어주세요....,plz"})
    void test3(String memberNo,String qbNo, String title, String content){
        assertThat(memberNo).isNotNull();
        assertThat(qbNo).isNotNull();
        assertThat(title).isNotNull();
        assertThat(content).isNotNull();

        QaDetailBoard qaDetailBoard = new QaDetailBoard();
        qaDetailBoard.setMemberNo(memberNo);
        qaDetailBoard.setQbNo(qbNo);
        qaDetailBoard.setTitle(title);
        qaDetailBoard.setContent(content);

        int result = qaBoardDao.insertQadetailBoard(session, qaDetailBoard);
        assertThat(result).isGreaterThan(0);

        System.out.println(qaDetailBoard);
//
    }
}
