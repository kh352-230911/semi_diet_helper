package com.sh.diet.member.controller;



import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/memberDelete")
public class MemberDeleteServlet extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 인코딩처리
        // 2. 사용자입력값처리
        HttpSession session = req.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember");
        String id = loginMember.getMemberId();
        System.out.println(id);
        // 3. 업무로직
        int result = memberService.deleteMember(id);
        // 세션해제
        session.invalidate();

        // 세션 새로 생성. msg 속성 저장
        session = req.getSession();
        session.setAttribute("msg", "성공적으로 탈퇴했습니다. \n다음에 더 좋은 서비스로 만나요 🖐");

        // 4. redirect
        resp.sendRedirect(req.getContextPath() + "/");
    }
}