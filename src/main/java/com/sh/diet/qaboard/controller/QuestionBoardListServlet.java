package com.sh.diet.qaboard.controller;

import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.service.QuestionBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/qaboard/questionBoardList")
public class QuestionBoardListServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 사용자 입력값 가져오기
        int page = 1;
        int limit = 10;
        try{
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException ignore) {}
        Map<String,Object> param = Map.of("page", page, "limit", limit);

        // 2 업무 로직
        List<QuestionBoard> questionBoards = questionBoardService.findAll(param);
        req.setAttribute("questionBoards",questionBoards);
        System.out.println(questionBoards);
        req.getRequestDispatcher("/WEB-INF/views/qaboard/questionBoardList.jsp").forward(req, resp);
    }

}