package com.sh.diet.member.controller;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.entity.Role;
import com.sh.diet.member.model.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/passwordLookup")
public class PasswordLookupServlet extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/passwordLookup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 사용자 입력값 받기
        String memberId = req.getParameter("memberId");
        String name = req.getParameter("name");
        String birthDay = req.getParameter("birthDay");
        String answer = req.getParameter("answer");

        Member member = new Member(null, memberId, null, name, null, 0, Role.M, null,
                birthDay, 0, 0, null, null, answer);


        Member matchMember = memberService.findPassword(member);
        // 패스워드 찾기 로직 수행
        String findPassword = matchMember.getPassword();

        System.out.println(matchMember);
        if (findPassword != null) {
            // 세션에 찾은 비밀번호 및 로그인 정보 저장
            HttpSession session = req.getSession();
//            session.setAttribute("findPassword", findPassword);
            session.setAttribute("matchMember", matchMember);

            // 리다이렉트
//            resp.sendRedirect(req.getContextPath() + "/member/updatePasswordAfterLookup");
            req.getRequestDispatcher("/WEB-INF/views/member/updatePasswordAfterLookup.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "입력하신 정보와 일치하는 회원을 찾을 수 없습니다.");
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }
}
