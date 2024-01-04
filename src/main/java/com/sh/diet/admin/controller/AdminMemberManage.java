package com.sh.diet.admin.controller;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.member.model.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/adminMemberManage")
public class AdminMemberManage extends HttpServlet {
    MemberService memberService = new MemberService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int limit = 10;

        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException ignore) {
        }

        Map<String, Object> param = new HashMap<>();
        param.put("page", page);
        param.put("limit", limit);

        List<Member>  members = memberService.findAll(param);
        req.setAttribute("members", members);
        // System.out.println(members);

        req.getRequestDispatcher("/WEB-INF/views/admin/adminMemberManage.jsp").forward(req,resp);;
    }
}
