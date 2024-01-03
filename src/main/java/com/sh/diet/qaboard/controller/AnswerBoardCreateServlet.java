//package com.sh.diet.qaboard.controller;
//
//import com.sh.diet.qaboard.model.entity.AnswerBoard;
//import com.sh.diet.qaboard.model.service.QuestionBoardService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/qaboard/answerBoardCreate")
//public class AnswerBoardCreateServlet extends HttpServlet {
//    private QuestionBoardService questionBoardService = new QuestionBoardService();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 사용자 입력값 처리
//        String acNo = req.getParameter("acNo");
//        String memberNo = req.getParameter("memberNo");
//        String qbNo = req.getParameter("qbNo");
//        String title = req.getParameter("title");
//        String content = req.getParameter("content");
//
//        AnswerBoard answerBoard = new AnswerBoard();
//        answerBoard.setAcNo(acNo);
//        answerBoard.setMemberNo(memberNo);
//        answerBoard.setQbNo(qbNo);
//        answerBoard.setTitle(title);
//        answerBoard.setContent(content);
//
//        // 업무로직
//        int result = questionBoardService.insertAnswerBoard(answerBoard);
//        req.getSession().setAttribute("msg","답글을 정상등록했습니다.");
//
//        // redirect
//        resp.sendRedirect(req.getContextPath()+"/qaboard/questionBoardDetail?id"+memberNo);
//    }
//}