//package com.sh.diet.qaboard.controller;
//
//import com.sh.diet.qaboard.model.service.QuestionBoardService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/qaboard/answerBoardLink")
//public class AnswerBoardLinkServlet extends HttpServlet {
//    private QuestionBoardService questionBoardService = new QuestionBoardService();
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String qbNo = req.getParameter("qbNo");
//        String acNo = req.getParameter("acNo");
//        System.out.println(acNo + "acNo 입니다..");
//
//        int result = questionBoardService.linkCountAnswerBoard(acNo);
//        req.getSession().setAttribute("msg","답변이 채택되었습니다 💕");
//
//        resp.sendRedirect(req.getContextPath()+"/qaboard/questionBoardDetail?qbNo="+qbNo);
//    }
//}