package com.sh.diet.member.model.dao;

import com.sh.diet.member.model.entity.Member;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MemberDao {
    public Member findById(SqlSession session, String memberId) {
        // SqlSession#selectOne("namespace.id", param)
        return session.selectOne("member.findById", memberId);
    }

    public List<Member> findAll(SqlSession session) { return session.selectList("member.findAll");

    }
    public List<Member> findByName(SqlSession session, String name) {
        return session.selectList("member.findByName", name);
    }

    public int insertMember(SqlSession session, Member member) {

        return session.insert("member.insertMember", member);
    }

    public int deleteMember(SqlSession session, String id) {
        return session.delete("member.deleteMember", id);
    }

    public int updateMemberPassword(SqlSession session, Member member) {
        return session.update("member.updateMemberPassword", member);
    }
    public int updateMemberRole(SqlSession session, Member member) {
        return session.update("member.updateMemberRole", member);

    }

    public List<Member> findAll(SqlSession session, Map<String, Object> param) {
        int page = (int) param.get("page");
        int limit = (int) param.get("limit");

        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        return session.selectList("member.findAll", param, rowBounds);
    }
}
