package com.sh.diet.member.model.controller;

import com.sh.diet.common.DawumiUtils;
import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.entity.Role;
import com.sh.diet.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/member/memberRegister")
public class MemberRegisterServlet extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/memberRegister.jsp").forward(req, resp);
    }

    //memberId, password, name, nickName, height, birthDay, weightLossGoal, answer
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberId = req.getParameter("memberId");
        String password = DawumiUtils.getEncryptedPassword(req.getParameter("password"), memberId);
        String name = req.getParameter("name");
        String nickName = req.getParameter("nickName");
        String height = req.getParameter("height");
        String _birthDay = req.getParameter("birthDay");
        String weightLossGoal = req.getParameter("weightLossGoal");
        String answer = req.getParameter("answer");
        System.out.println(memberId + ", " + password + ", " + name + ", " + nickName + ", " + height + ", " + _birthDay + ", " + weightLossGoal + ", " + answer );

        LocalDate birthday = _birthDay != null && !"".equals(_birthDay) ?
                LocalDate.parse(_birthDay, DateTimeFormatter.ISO_DATE) :
                null;

        Member member = new Member(null, memberId, password, name, nickName, height, Role.U, null, birthday, weightLossGoal, null, answer, null, null);
        System.out.println(member);

        int result = memberService.insertMember(member);
        System.out.println(result);

        req.getSession().setAttribute("msg", "회원가입 축하드립니다.");

        resp.sendRedirect(req.getContextPath() + "/");





    }


}