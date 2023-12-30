package com.sh.diet.MemberService;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {this.memberService = new MemberService();  }

    @DisplayName("MemberService객체는 null이 아니다.")
    @Test
    public void test1() { assertThat(memberService).isNotNull(); }

    @DisplayName("존재하는 회원이 정상적으로 조회된다.")
    @Test
    public void test2() {
        String memberId = "user123";
        Member member = memberService.findById(memberId);
        System.out.println(member);

        // 객체
//        assertThat(member).isNotNull();
//        // 필드
////        Assertions.assertThat(member.getId()).isNotNull();
//        assertThat(member.getPassword()).isNotNull();
//        assertThat(member.getName()).isNotNull();
//        assertThat(member.getRole()).isNotNull();
    }
}