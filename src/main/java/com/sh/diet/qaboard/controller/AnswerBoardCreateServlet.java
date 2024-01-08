package com.sh.diet.qaboard.controller;

import com.sh.diet.qaboard.model.entity.AnswerBoard;
import com.sh.diet.qaboard.model.service.QuestionBoardService;
import com.sh.diet.qaboard.model.vo.QuestionBoardVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/qaboard/answerBoardCreate")
public class AnswerBoardCreateServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/qaboard/answerBoardCreate.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자 입력값 처리
        String memberNo = req.getParameter("memberNo");
        String qbNo = req.getParameter("qbNo");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        AnswerBoard answerBoard = new AnswerBoard();
        answerBoard.setMemberNo(memberNo);
        answerBoard.setQbNo(qbNo);
        answerBoard.setTitle(title);
        answerBoard.setContent(content);

        System.out.println(memberNo);
        System.out.println(qbNo);
        System.out.println(title);
        System.out.println(content);
        // 업무로직
        int result = questionBoardService.insertAnswerBoard(answerBoard);
        req.getSession().setAttribute("msg","답글을 정상등록했습니다.");
        // redirect
        resp.sendRedirect(req.getContextPath()+"/qaboard/questionBoardDetail?qbNo="+qbNo);
    }
}