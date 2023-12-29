package com.sh.diet.member.model.service;

import com.sh.diet.member.model.dao.MemberDao;
import com.sh.diet.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class MemberService {
    private MemberDao memberDao = new MemberDao();

    public Member findById(String memberId) {
        SqlSession session = getSqlSession();
        Member member = memberDao.findById(session, memberId);
        session.close();
        return member;

    }

}
