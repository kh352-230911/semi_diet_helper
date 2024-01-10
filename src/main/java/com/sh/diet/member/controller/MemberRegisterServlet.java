package com.sh.diet.member.controller;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.entity.Role;
import com.sh.diet.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/member/memberRegister")
public class MemberRegisterServlet extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //memberId, password, name, nickName, height, birthDay, weightLossGoal, answer
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String memberId = req.getParameter("memberId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String nickName = req.getParameter("nickName");
        float height = Float.parseFloat(req.getParameter("height"));
        String _birthDay = req.getParameter("birthDay");
        int weightLossGoal = Integer.parseInt(req.getParameter("weightLossGoal"));
        String answer = req.getParameter("answer");
        System.out.println(memberId + ", " + password + ", " + name + ", " + nickName + ", " + height + ", " + _birthDay + ", " + weightLossGoal + ", " + answer );

//        LocalDate birthday = _birthDay != null && !"".equals(_birthDay) ?
//                LocalDate.parse(_birthDay, DateTimeFormatter.ISO_DATE) :
//                null;

        Member member = new Member(null, memberId, password, name, nickName, height, Role.M, null,
                _birthDay, weightLossGoal, 0, null, null, answer);
        System.out.println(member);

        int result = memberService.insertMember(member);
        System.out.println(result);
//
        req.getSession().setAttribute("msg", "회원가입 축하드립니다.");
//
        resp.sendRedirect(req.getContextPath() + "/");





    }


}