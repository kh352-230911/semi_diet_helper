package com.sh.diet.memberService;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;
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


    }
}
