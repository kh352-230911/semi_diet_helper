package com.sh.diet.member.model.service;

import com.sh.diet.member.model.dao.MemberDao;
import com.sh.diet.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class MemberService {
    private MemberDao memberDao = new MemberDao();

    public Member findById(String memberId) {
        SqlSession session = getSqlSession();
        Member member = memberDao.findById(session, memberId);
        session.close();
        return member;

    }
    public List<Member> findAll() {
        SqlSession session = getSqlSession();
        List<Member> members = memberDao.findAll(session);
        session.close();
        return members;
    }

    public List<Member> findByName(String name) {
        SqlSession session = getSqlSession();
        List<Member> members = memberDao.findByName(session, name);
        session.close();
        return members;
    }

    public int insertMember(Member member) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = memberDao.insertMember(session, member);
            session.commit();
        } catch (Exception e){
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int deleteMember(String id) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = memberDao.deleteMember(session, id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int updateMemberPassword(Member member) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = memberDao.updateMemberPassword(session, member);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int updateMemberRole(Member member) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = memberDao.updateMemberRole(session, member);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }














    public List<Member> findAll(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        List<Member> members = memberDao.findAll(session, param);
        session.close();
        return members;
    }

    public int updateIncreaseOnePointToMember(String memberNo) {
        SqlSession session = getSqlSession();
        int result = 0;
        try{
            result = memberDao.updateIncreaseOnePointToMember(session, memberNo);
            session.commit();
        }
        catch (Exception e){
            session.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return result;
    }
}
