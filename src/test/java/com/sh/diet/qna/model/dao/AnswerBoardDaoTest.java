package com.sh.diet.qna.model.dao;

import com.sh.diet.qaboard.model.dao.QuestionBoardDao;
import com.sh.diet.qaboard.model.entity.AnswerBoard;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerBoardDaoTest {
    private QuestionBoardDao questionBoardDao;
    private SqlSession session;

    @BeforeEach
    public void setUp() {
        this.questionBoardDao = new QuestionBoardDao();
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
        assertThat(questionBoardDao).isNotNull();
        assertThat(session).isNotNull();
    }
    @DisplayName("특정 게시글에 대한 답글조회")
    @Test
    void test2(){
        String acNo = "19";
        AnswerBoard answerBoard = questionBoardDao.findByAnswerBoardacNo(session,acNo);
        System.out.println(answerBoard);
        assertThat(answerBoard).isNotNull();
                    assertThat(answerBoard.getMemberNo()).isNotNull();
                    assertThat(answerBoard.getAcNo()).isEqualTo(acNo);
                    assertThat(answerBoard.getContent()).isNotNull();
                    assertThat(answerBoard.getRegDate()).isNotNull();
                    System.out.println(answerBoard);
    }
//    @Disabled
    @DisplayName("답글 등록")
    @ParameterizedTest
    @CsvSource({"26,2,8,제발답글등록되어주세요....,plz"})
    void test3(String acNo, String memberNo,String qbNo, String title, String content){
        assertThat(acNo).isNotNull();
        assertThat(memberNo).isNotNull();
        assertThat(qbNo).isNotNull();
        assertThat(title).isNotNull();
        assertThat(content).isNotNull();

        AnswerBoard answerBoard = new AnswerBoard();
        answerBoard.setAcNo(acNo);
        answerBoard.setMemberNo(memberNo);
        answerBoard.setQbNo(qbNo);
        answerBoard.setTitle(title);
        answerBoard.setContent(content);

        int result = questionBoardDao.insertAnswerBoard(session, answerBoard);
        assertThat(result).isGreaterThan(0);

        System.out.println(answerBoard);

    }
//    @Disabled
    @DisplayName("답글 수정")
    @ParameterizedTest
    @CsvSource({"2,답글 수정이라해~~,내일 학원간다...."})
    void test4(String memberNo, String title, String content){
        String acNo= "37";
        AnswerBoard answerBoard = questionBoardDao.findByIdAnswer(session, acNo);
        assertThat(answerBoard).isNotNull();

        answerBoard.setMemberNo(memberNo);
        answerBoard.setTitle(title);
        answerBoard.setContent(content);

        int result = questionBoardDao.updateAnswerBoard(session, answerBoard);
        assertThat(result).isGreaterThan(0);

        AnswerBoard answerBoard1 = questionBoardDao.findByIdAnswer(session, acNo);
        assertThat(answerBoard1).isNotNull();
        assertThat(answerBoard1.getAcNo()).isEqualTo(acNo);
        assertThat(answerBoard1.getMemberNo()).isEqualTo(memberNo);
        assertThat(answerBoard1.getTitle()).isEqualTo(title);
        assertThat(answerBoard1.getContent()).isEqualTo(content);
//        System.out.println(answerBoard);
    }
//    @Disabled
    @DisplayName("답글 삭제")
    @Test
    void test5(){
        String acNo = "37";
        AnswerBoard answerBoard = questionBoardDao.findByIdAnswer(session,acNo);
        assertThat(answerBoard).isNotNull();

        int result = questionBoardDao.deleteAnswerBoard(session,acNo);
        assertThat(result).isGreaterThan(0);

        AnswerBoard answerBoard1 = questionBoardDao.findByIdAnswer(session,acNo);
        assertThat(answerBoard1).isNull();

        System.out.println(answerBoard);
    }
}

