package com.sh.diet.qaboard.controller;

import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.service.QuestionBoardService;
import com.sh.diet.qaboard.model.vo.QuestionBoardVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/qaboard/questionBoardUpdate")
public class QuestionBoardUpdateServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.사용자 입력값 처리
        String qbNo = req.getParameter("qbNo");
        // 2. 업무로직
        QuestionBoardVo questionBoardVo = questionBoardService.findById(qbNo);

        req.setAttribute("questionBoard",questionBoardVo);
        // 3. forwarding
        req.getRequestDispatcher("/WEB-INF/views/qaboard/questionBoardUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String qbNo = req.getParameter("qbNo");
        String memberNo = req.getParameter("memberNo");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        QuestionBoardVo questionBoardVo = new QuestionBoardVo();
        questionBoardVo.setQbNo(qbNo);
        questionBoardVo.setMemberNo(memberNo);
        questionBoardVo.setTitle(title);
        questionBoardVo.setContent(content);

        System.out.println(qbNo);
        System.out.println(memberNo);
        System.out.println(title);
        System.out.println(content);
        System.out.println(questionBoardVo);

        int result = questionBoardService.updateQuestionBoard(questionBoardVo);
        req.getSession().setAttribute("msg", "게시글을 정상적으로 수정되었습니다. 🥰");

        resp.sendRedirect(req.getContextPath() + "/qaboard/questionBoardList");
    }
}