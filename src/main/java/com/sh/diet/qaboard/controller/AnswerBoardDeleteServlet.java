package com.sh.diet.qaboard.controller;

import com.sh.diet.qaboard.model.entity.AnswerBoard;
import com.sh.diet.qaboard.model.service.QuestionBoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/qaboard/answerBoardDelete")
public class AnswerBoardDeleteServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String qbNo = req.getParameter("qbNo");
//        String qbNo = (String)req.getSession().getAttribute("qbNo");
        System.out.println(qbNo);
        String acNo = req.getParameter("acNo");
        System.out.println(acNo + "acNo 입니다..");
//        AnswerBoard answerBoard = new AnswerBoard();
//        answerBoard.setQbNo(qbNo);
//        answerBoard.setAcNo(acNo);
        int result = questionBoardService.deleteAnswerBoard(acNo);

        req.getSession().setAttribute("msg","답변게시글을 삭제했습니다 😭");

//        req.setAttribute("answerBoard",answerBoard);
        resp.sendRedirect(req.getContextPath()+"/qaboard/questionBoardDetail?qbNo="+qbNo);


    }
}
