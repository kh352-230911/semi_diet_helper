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

@WebServlet("/member/memberLogin")
public class MemberLoginServlet extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         Referer(사용자가 머물었던 페이지)를 세션에 저장
        String referer = req.getHeader("Referer");
        System.out.println("referer = " + referer);

        if(!referer.equalsIgnoreCase("/member/memberLogin"))
            req.getSession().setAttribute("next", referer);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/member/memberLogin.jsp");

        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자입력값 인코딩처리
//        req.setCharacterEncoding("utf-8");

        // 2. 사용자입력값 가져오기
        String memberId = req.getParameter("memberId");
        String password = req.getParameter("password");
        System.out.println(memberId + ", " + password);

        // 3. 업무로직 (이번요청에 처리할 작업) -> 로그인(인증)
        // id/password - db에서 읽어온 데이터(member객체) 비교
        // 로그인 성공 (id/password 모두 일치)
        // 로그인 실패 (존재하지 않는 id | password가 틀린 경우)
        Member member = memberService.findById(memberId);
        System.out.println(member);

        // 세션생성/가져오기
        // getSession(), getSession(true) : 세션이 존재하지 않으면 생성, 혹은 존재하는 세션을 반환
        HttpSession session = req.getSession();



        if(member != null && password.equals(member.getPassword())) {
            // 로그인 성공
            // pageContext, request, session, application 컨텍스트객체중에 login처리에 적합한 것은 session
            // session객체는 사용자가 서버첫접속부터 세션해제시까지 유효
            session.setAttribute("loginMember", member);
            if(member.getRole() == Role.A){
                req.getRequestDispatcher("/adminMain").forward(req, resp);
            }else{
                req.getRequestDispatcher("/").forward(req, resp);
            }
        }
        else {
            // 로그인 실패
            session.setAttribute("msg", "아이디가 존재하지 않거나, 비밀번호가 틀립니다. 😎");
            resp.sendRedirect(req.getContextPath() + "/member/memberLogin"); // GET
        }
    }
}