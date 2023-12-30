package com.sh.diet.qna.model.service;

import com.sh.diet.board.model.entity.QuestionBoard;
import com.sh.diet.board.model.service.QuestionBoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionBoardServiceTest {
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
                .allSatisfy((questionBoard -> {
                    assertThat(questionBoard.getMemberNo()).isNotNull();
                    assertThat(questionBoard.getTitle()).isNotNull();
                    assertThat(questionBoard.getContent()).isNotNull();
                    assertThat(questionBoard.getRegDate()).isNotNull();
                }));
    }
}
