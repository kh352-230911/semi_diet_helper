package com.sh.diet.member.dao;

import com.sh.diet.member.model.dao.MemberDao;
import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.entity.Role;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberDaoTest {

    MemberDao memberDao;
    SqlSession session;
    @BeforeEach
    void setUp() {
        this.memberDao = new MemberDao();
        this.session = getSqlSession();
    }

    @AfterEach
    void tearDown() {
        this.session.rollback();
        this.session.close();
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
        long height = 170;


        Member member = new Member(
                "444", memberId, password, name, nickName, height, Role.A, null, null, 0, 0, "LC1", "N1", "내가낸데"
        );

        int result = memberDao.insertMember(session, member);
        assertThat(result).isEqualTo(1);

        Member member2 = memberDao.findById(session, memberId);
        assertThat(member2).isNotNull();
        assertThat(member2.getMemberId()).isEqualTo(memberId);
        assertThat(member2.getPassword()).isEqualTo(password);
        assertThat(member2.getName()).isEqualTo(name);
    }
}
