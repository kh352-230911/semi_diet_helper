package com.sh.diet.MemberService;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.entity.Role;
import com.sh.diet.member.model.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;
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
        // 객체
        Assertions.assertThat(member).isNotNull();
        // 필드
        Assertions.assertThat(member.getMemberId()).isNotNull();
        Assertions.assertThat(member.getPassword()).isNotNull();
        Assertions.assertThat(member.getName()).isNotNull();
        Assertions.assertThat(member.getRole()).isNotNull();

    }
    @DisplayName("존재하지않는 회원이 NULL이 반환되어야 한다.")
    @Test
    public void test3(){
        Member member = memberService.findById("nihaowoshihanchengxun");
        Assertions.assertThat(member).isNull();
    }
    @DisplayName("회원 전체 조회")
    @Test
    public void test4(){
        List<Member> members = memberService.findAll();
        Assertions.assertThat(members)
                .isNotNull()
                .isNotEmpty();
        // Consumer타입 람다식 : 매개변수가 하나 있고, 리턴타입은 없음.
        members.forEach((member) -> {
            System.out.println(member);
            Assertions.assertThat(member.getMemberId()).isNotNull();
            Assertions.assertThat(member.getPassword()).isNotNull();
            Assertions.assertThat(member.getName()).isNotNull();
            Assertions.assertThat(member.getRole()).isNotNull();
        });
    }
    @DisplayName("회원 이름 검색")
    @Test
    public void test5(){
        String keyword = "John Doe";
        List<Member> members = memberService.findByName(keyword);
        Assertions.assertThat(members)
                .isNotNull()
                .isNotEmpty();
        members.forEach((member) -> Assertions.assertThat(member.getName()).contains(keyword));
    }
    @Disabled
    @Order(1)
    @DisplayName("회원가입")
    @Test
    public void test6() {
        String memberId = "asdf1234";
        String password = "1234";
        String name = "씨몽키";
        String nickName = "몽키";
        String height = "170";


        Member member = new Member(
                "444", memberId, password, name, nickName, height, Role.A, null, null, 0, 0, "내가낸데", "1", "1"
        );

        int result = memberService.insertMember(member);
        assertThat(result).isEqualTo(1);

        Member member2 = memberService.findById(memberId);
        assertThat(member2).isNotNull();
        assertThat(member2.getMemberId()).isEqualTo(memberId);
        assertThat(member2.getPassword()).isEqualTo(password);
        assertThat(member2.getName()).isEqualTo(name);
    }
//    @Order(2)
//    @DisplayName("회원가입시 오류 체크")
//    @Test
//    public void test8() {
//        Member member =
//                new Member(
//                        "444", "sinsa", "sinsa123", "신사", "신사임당", "160", Role.A,null, null, 0, 0, "내가낸데", "1", "1"
//                );
//        Throwable th = catchThrowable(() -> {
//            int result = memberService.insertMember(member);
//        });
//        Assertions.assertThat(th).isInstanceOf(Exception.class);
//    }

    @Disabled
    @Order(3)
    @DisplayName("회원 삭제")
    @Test
    public void test12() {
        String memberId = "asdf1234";
        Member member = memberService.findById(memberId);
        Assertions.assertThat(member).isNotNull();

        int result = memberService.deleteMember(memberId);
        Assertions.assertThat(result).isGreaterThan(0);

        Member member2 = memberService.findById(memberId);
        Assertions.assertThat(member2).isNull();
    }

    @Order(4)
    @DisplayName("회원 비밀번호 수정")
    @Test
    public void test10() {
        // update member set password = ? where id = ?
        String id = "user123";
        Member member = memberService.findById(id);
        String newPassword = "qwer1234";
        member.setPassword(newPassword);

        int result = memberService.updateMemberPassword(member);

        Assertions.assertThat(result).isGreaterThan(0);
        Member member2 = memberService.findById(id);
        Assertions.assertThat(member2.getPassword()).isEqualTo(newPassword);
    }



}
