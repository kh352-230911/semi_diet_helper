package com.sh.diet.member.controller;

import com.google.gson.Gson;
import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/member/checkIdDuplicate")
public class CheckIdDuplicateServlet extends HttpServlet {
    private MemberService memberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자입력값처리
        String memberId = req.getParameter("memberId");
        System.out.println(memberId);
        // 2. 업무로직
        Member member = memberService.findById(memberId);
        boolean result = member == null;
        // 3. 응답 json 작성
        resp.setContentType("application/json; charset=utf-8");
        Map<String, Object> map = Map.of("result", result);
        new Gson().toJson(map, resp.getWriter());
    }
}