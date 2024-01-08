package com.sh.diet.qna.model.dao;

import com.sh.diet.qaboard.model.dao.QuestionBoardDao;
import com.sh.diet.qaboard.model.entity.AnswerBoard;
import com.sh.diet.qaboard.model.vo.AnswerBoardVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

    @DisplayName("게시글에 대한 답글조회")
    @Test
    void test2() {
        String qbNo = "Q7";
       List<AnswerBoardVo> answerBoardVo = questionBoardDao.findByAnswerBoardqbNo(session, qbNo);
        System.out.println(answerBoardVo);
//        assertThat(answerBoard).isNotNull();
//            assertThat(answerBoard.getMemberNo()).isNotNull();
//            assertThat(answerBoard.getTitle()).isNotNull();
//            assertThat(answerBoard.getContent()).isNotNull();
//            assertThat(answerBoard.getRegDate()).isNotNull();
//
//            System.out.println(answerBoard);
    }

    //    @Disabled
    @DisplayName("답글 등록")
    @ParameterizedTest
    @CsvSource({"M5,Q5,제발답글등록되어주세요....,plz"})
    void test3(String memberNo, String qbNo, String title, String content) {
        assertThat(memberNo).isNotNull();
        assertThat(qbNo).isNotNull();
        assertThat(title).isNotNull();
        assertThat(content).isNotNull();

        AnswerBoard answerBoard = new AnswerBoard();
        answerBoard.setMemberNo(memberNo);
        answerBoard.setQbNo(qbNo);
        answerBoard.setTitle(title);
        answerBoard.setContent(content);

        int result = questionBoardDao.insertAnswerBoard(session, answerBoard);
        assertThat(result).isGreaterThan(0);

        System.out.println(answerBoard);

    }
}
    //    @Disabled
//    @DisplayName("답글 수정")
//    @ParameterizedTest
//    @CsvSource({"M5,답글 수정이라해~~,내일 학원간다...."})
//    void test4(String memberNo, String title, String content) {
//        String qbNo = "Q5";
//
//        List<AnswerBoard> answerBoard1 = questionBoardDao.findByIdAnswer(session, qbNo);
//        System.out.println(answerBoard1);
//        assertThat(answerBoard1).isNotNull();
//
//        answerBoard1.setMemberNo(memberNo);
//        answerBoard1.setTitle(title);
//        answerBoard1.setContent(content);
//
//        int result = questionBoardDao.updateAnswerBoard(session, answerBoard1);
//        assertThat(result).isGreaterThan(0);
//
//        List<AnswerBoard> answerBoard2 = questionBoardDao.findByIdAnswer(session, qbNo);
//        assertThat(answerBoard2).isNotNull();
//        assertThat(answerBoard2.getQbNo()).isEqualTo(qbNo);
//        assertThat(answerBoard2.getMemberNo()).isEqualTo(memberNo);
//        assertThat(answerBoard2.getTitle()).isEqualTo(title);
//        assertThat(answerBoard2.getContent()).isEqualTo(content);
//        System.out.println(answerBoard2);
//    }
// }

//    @Disabled
//    @DisplayName("답글 삭제")
//    @Test
//    void test5(){
//        String acNo = "Q8";
//        List<AnswerBoard> answerBoard1 = questionBoardDao.findByIdAnswer(session, qbNo);
//        assertThat(answerBoard).isNotNull();
//
//        int result = questionBoardDao.deleteAnswerBoard(session,acNo);
//        assertThat(result).isGreaterThan(0);
//
//        AnswerBoard answerBoard1 = questionBoardDao.findByIdAnswer(session,acNo);
//        assertThat(answerBoard1).isNull();
//
//        System.out.println(answerBoard);
//    }
//}

