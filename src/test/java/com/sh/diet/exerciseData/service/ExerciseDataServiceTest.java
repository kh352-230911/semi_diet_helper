package com.sh.diet.exerciseData.service;


import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.entity.ScrapExercise;
import com.sh.diet.exercise.model.service.ExerciseDataService;
import com.sh.diet.exercise.model.service.ScrapExerciseService;
import com.sh.diet.exercise.model.vo.ExerciseDataVo;
import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseDataServiceTest {

    ExerciseDataService exerciseDataService;
    ScrapExerciseService scrapExerciseService;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        this.exerciseDataService = new ExerciseDataService();
        this.scrapExerciseService = new ScrapExerciseService();
        this.memberService = new MemberService();
    }

    @DisplayName("exerciseService 객체는 null이 아니다.")
    @Test
    void test1() {
        assertThat(exerciseDataService).isNotNull();
    }

    @DisplayName("운동 전체 조회")
    @Test
    void test2() {
        List<ExerciseData> exerciseDatas = exerciseDataService.findAll();
        System.out.println(exerciseDatas);
        assertThat(exerciseDatas)
                .isNotNull()
                .allSatisfy((exerciseData -> {
                    assertThat(exerciseData.getExNo()).isNotNull();
                    assertThat(exerciseData.getExName()).isNotNull();
                    assertThat(exerciseData.getKcal()).isNotZero();
                    assertThat(exerciseData.getBodyPart()).isNotNull();
                    assertThat(exerciseData.getExUrl()).isNotNull();
                }));
    }

    @DisplayName("전체 게시글 수 조회")
    @Test
    void test3(){
        int totalCount = exerciseDataService.getTotalCount();
        assertThat(totalCount).isNotNegative();
    }

    @DisplayName("특정 회원이 특정 운동을 스크랩했는지 확인")
    @Test
    public void test4() {
        String memberNo = "M0";
        String exNo = "E44";


        // 객체를 만들고난 뒤 값 넣어주기
        ExerciseDataVo exDataVo = new ExerciseDataVo();
        exDataVo.setExNo(exNo);
        Member member = memberService.findByMemberNo(memberNo);
        exDataVo.setMember(member);

        System.out.println(exDataVo.getMember().getMemberNo());


        ExerciseDataVo exDataVo1 = new ExerciseDataVo();
        exDataVo1 = exerciseDataService.checkScrapExbyMemberNo(exDataVo);
        System.out.println(exDataVo1);
    }
}
