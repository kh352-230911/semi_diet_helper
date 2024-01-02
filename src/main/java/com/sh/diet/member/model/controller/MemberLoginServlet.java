package com.sh.diet.member.model.controller;

import com.sh.diet.common.DawumiUtils;
import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/memberLogin")
public class MemberLoginServlet extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Referer(사용자가 머물었던 페이지)를 세션에 저장
//        String referer = req.getHeader("Referer");
//        System.out.println("referer = " + referer);
//
//        if(!referer.equalsIgnoreCase("/member/memberLogin"))
//            req.getSession().setAttribute("next", referer);
        System.out.println("plag1");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/member/memberLogin.jsp");
        System.out.println("plag2");
        requestDispatcher.forward(req, resp);
        System.out.println("plag3");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String memberId = req.getParameter("memberId");
        String password = DawumiUtils.getEncryptedPassword(req.getParameter("password"), memberId);

        Member member = memberService.findById(memberId);
        System.out.println(member);

        HttpSession session = req.getSession();
        if(member != null && password.equals(member.getPassword())) {

            session.setAttribute("loginMember", member);
            String location = req.getContextPath() + "/";
            String next = (String) req.getSession().getAttribute("next");
            if(next != null) {
                location = next;
                req.getSession().removeAttribute("next");
            }
            resp.sendRedirect(location);
        }
        else{
            session.setAttribute("msg", "아이디가 존재하지 않거나, 비밀번호가 틀립니다.");
            resp.sendRedirect(req.getContextPath() + "/member/memberLogin"); //get방식
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}