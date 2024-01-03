package com.sh.diet.qna.model.service;

import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.service.QuestionBoardService;
import com.sh.diet.qaboard.model.vo.QuestionBoardVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionBoardServiceTest {
    static final int limit = 10; // 페이지당 게시글수
    QuestionBoardService questionBoardService;
    @BeforeEach
    void setUp(){
        this.questionBoardService = new QuestionBoardService();
    }
    @DisplayName("질답게시글 전체조회")
    @Test
    void test1(){
        List<QuestionBoard> questionBoards = questionBoardService.findAll();
        assertThat(questionBoards)
                .isNotNull()
                .allSatisfy((questionBoardVo -> {
                    assertThat(questionBoardVo.getMemberNo()).isNotNull();
                    assertThat(questionBoardVo.getTitle()).isNotNull();
                    assertThat(questionBoardVo.getContent()).isNotNull();
                    assertThat(questionBoardVo.getRegDate()).isNotNull();
                }));
         System.out.println(questionBoards);
    }
    @DisplayName("존재하는 질답게시글 한 건 조회")
    @Test
    void test2(){
        String qbNo = "Q7";
        QuestionBoardVo questionBoardvo = questionBoardService.findById(qbNo);
        assertThat(questionBoardvo).isNotNull();
        assertThat(questionBoardvo.getMemberNo()).isNotNull();
        assertThat(questionBoardvo.getTitle()).isNotNull();
        assertThat(questionBoardvo.getContent()).isNotNull();
        assertThat(questionBoardvo.getRegDate()).isNotNull();
        System.out.println(questionBoardvo);
    }
    @DisplayName("존재하지 않는 질답게시글 한 건 조회")
    @Test
    void test3(){
    QuestionBoard questionBoard = questionBoardService.findById("77");
    assertThat(questionBoard).isNull();
    }
//    @Disabled
    @DisplayName("질답게시글 등록")
    @ParameterizedTest
    @CsvSource({"M4,예시,개발자할수있을까...?"})
    void test4(String memberNo,String title, String content){
        assertThat(memberNo).isNotNull();
        assertThat(title).isNotNull();
        assertThat(content).isNotNull();

        QuestionBoard questionBoard = new QuestionBoard();
        questionBoard.setMemberNo(memberNo);
        questionBoard.setTitle(title);
        questionBoard.setContent(content);

        int result = questionBoardService.insertQuestionBoard(questionBoard);
        assertThat(result).isGreaterThan(0);

    }
    @Disabled
    @DisplayName("질답게시글 수정")
    @ParameterizedTest
    @CsvSource({"M4,수정했음나나나,제발,,,,"})
    void test5(String memberNo,String title, String content){
        String qbNo = "Q36";
        QuestionBoardVo questionBoardVo = questionBoardService.findById(qbNo);
        assertThat(questionBoardVo).isNotNull();

        questionBoardVo.setMemberNo(memberNo);
        questionBoardVo.setTitle(title);
        questionBoardVo.setContent(content);

        int result = questionBoardService.updateQuestionBoard(questionBoardVo);
        assertThat(result).isGreaterThan(0);

        QuestionBoardVo questionBoardVo1 = questionBoardService.findById(questionBoardVo.getQbNo());
        assertThat(questionBoardVo1).isNotNull();
        assertThat(questionBoardVo1.getQbNo()).isEqualTo(qbNo);
        assertThat(questionBoardVo1.getMemberNo()).isEqualTo(memberNo);
        assertThat(questionBoardVo1.getTitle()).isEqualTo(title);
        assertThat(questionBoardVo1.getContent()).isEqualTo(content);
    }
    @Disabled
    @DisplayName("질답게시글 삭제")
    @Test
    void test6(){
        String qbNo = "18";
        QuestionBoard questionBoard = questionBoardService.findById(qbNo);
        assertThat(questionBoard).isNotNull();

        int result = questionBoardService.deleteQuestionBoard(qbNo);
        assertThat(result).isGreaterThan(0);

        QuestionBoard questionBoard1 = questionBoardService.findById(qbNo);
        assertThat(questionBoard1).isNull();
    }
    @DisplayName("전체 질답게시글수 조회")
    @Test
    void test7() {
        // given
        // when
        int totalCount = questionBoardService.getTotalCount();
        // then
        assertThat(totalCount).isNotNegative(); // 음수가 아니어야 한다. 0이상
        System.out.println(totalCount);
    }
}
//    @DisplayName("질답게시글 페이징 조회")
//    @ParameterizedTest
//    @MethodSource("pageNoProvider")
//    void test8(int page) {
//        Map<String, Object> param = Map.of("page", page, "limit", limit);
//        List<QuestionBoard> questionBoards = questionBoardService.findAll(param);
//        assertThat(questionBoards)
//                .isNotNull()
//                .isNotEmpty()
//                .size().isLessThanOrEqualTo(limit);
//    }
//
//    public static Stream<Integer> pageNoProvider() {
//        QuestionBoardService questionBoardService = new QuestionBoardService();
//        SqlSession session = getSqlSession();
//        int totalCount = questionBoardService.getTotalCount();
//        int totalPage = (int) Math.ceil((double) totalCount / limit);
//        return IntStream.range(1, totalPage).boxed(); // 1 부터 total페이지까지를 요소로 하는 Stream생성
//    }


//    @DisplayName("질답게시글 수정")
//    @ParameterizedTest
//    @MethodSource("QuestionBoardProvider")
//    void test5(){
//    String memberNo = "22";
//    QuestionBoard questionBoard = questionBoardService.findById(memberNo);
//    assertThat(questionBoard).isNotNull();
//
//    String newTitle = "그쪽도 홍박사님을";
//    String newContent = "아세용?";
//    questionBoard.setTitle(newTitle);
//    questionBoard.setContent(newContent);
//    int result = questionBoardService.updateQuestionBoard(questionBoard);
//
//    assertThat(result).isGreaterThan(0);
//    QuestionBoard questionBoard1 = questionBoardService.findById(memberNo);
//    assertThat(questionBoard1).satisfies((q)->{
//        assertThat(q.getTitle()).isEqualTo(newTitle);
//        assertThat(q.getContent()).isEqualTo(newContent);
//    });
//    }
//    public static Stream<Arguments> QuestionBoardProvider() {
//        QuestionBoardService questionBoardService = new QuestionBoardService();
//        List<QuestionBoard> questionBoards = questionBoardService.findAll();
//        return Stream.of(Arguments.arguments(questionBoards.get(0).getMemberNo()));
//    }
