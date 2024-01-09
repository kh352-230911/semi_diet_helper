//package com.sh.diet.daily.controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("/text/changeMonth")
//public class ChangeMonth extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        // 1. 사용자입력값
//        String changeMonth = req.getParameter("changeMonth");
//        System.out.println("changeMonth = " + changeMonth);
//
//        // 3. 응답 출력
//        // 일치하지 않아도 유연하게 처리함.
////        resp.setContentType("text/plain; charset=utf-8");
////        PrintWriter out = resp.getWriter();
////        out.println("텍스트 보내드립니다.");
////        out.println("이름은 " + name + "입니다.");
////        out.println("숫자는 " + num + "입니다.");
//
//        req.setAttribute("changeMonth", changeMonth);
//        req.getRequestDispatcher("/WEB-INF/views/member/memberMain").forward(req, resp);
//    }
//}
