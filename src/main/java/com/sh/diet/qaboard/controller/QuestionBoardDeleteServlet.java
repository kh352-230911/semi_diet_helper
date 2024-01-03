package com.sh.diet.qaboard.controller;

import com.sh.diet.qaboard.model.service.QuestionBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/qaboard/questionBoardDelete")
public class QuestionBoardDeleteServlet extends HttpServlet {
    private QuestionBoardService questionboardService = new QuestionBoardService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자입력값 처리
        String qaNo = req.getParameter("qaNo");
        // 2. 업무로직
        int result = questionboardService.deleteQuestionBoard(qaNo);
        req.getSession().setAttribute("msg", "게시글을 삭제했습니다. 🤗");
        // 3. 리다이렉트
        resp.sendRedirect(req.getContextPath() + "/qaboard/questionBoardList");
    }
}