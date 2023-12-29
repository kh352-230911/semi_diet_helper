package com.sh.diet.member.model.dao;

import com.sh.diet.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {
    public Member findById(SqlSession session, String memberId) {
        // SqlSession#selectOne("namespace.id", param)
        return session.selectOne("member.findById", memberId);
    }
}
