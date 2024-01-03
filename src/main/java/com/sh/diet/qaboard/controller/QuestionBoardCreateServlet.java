package com.sh.diet.qaboard.controller;

import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.service.QuestionBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/qaboard/questionBoardCreate")
public class QuestionBoardCreateServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/qaboard/questionBoardCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberNo = req.getParameter("memberNo");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        QuestionBoard questionBoard = new QuestionBoard();
        questionBoard.setMemberNo(memberNo);
        questionBoard.setTitle(title);
        questionBoard.setContent(content);

        int result = questionBoardService.insertQuestionBoard(questionBoard);
        req.getSession().setAttribute("msg", "게시글을 정상등록했습니다. 🥰");

        resp.sendRedirect(req.getContextPath() + "/qaboard/questionBoardList");
    }
}
