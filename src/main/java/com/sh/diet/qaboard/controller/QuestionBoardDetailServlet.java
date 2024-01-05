package com.sh.diet.qaboard.controller;

import com.sh.diet.qaboard.model.entity.AnswerBoard;
import com.sh.diet.qaboard.model.exception.QuestionBoardException;
import com.sh.diet.qaboard.model.service.QuestionBoardService;
import com.sh.diet.qaboard.model.vo.AnswerBoardVo;
import com.sh.diet.qaboard.model.vo.QuestionBoardVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/qaboard/questionBoardDetail")
public class QuestionBoardDetailServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            String referer = req.getHeader("Referer");
//            System.out.println("referer = " + referer);

//            if(!referer.contains("/qaboard/questionBoardDetail"))
//                req.getSession().setAttribute("next",referer);

//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/qaboard/questionBoardDetail.jsp");
//            requestDispatcher.forward(req, resp);
            String qbNo = req.getParameter("qbNo");
            System.out.println(qbNo + ": qbNo");

            QuestionBoardVo questionBoardVo = questionBoardService.findById(qbNo);
            List<AnswerBoardVo> answerBoardVo = questionBoardService.findByAnswerBoardqbNo(qbNo);
//            List<AnswerBoard> answerBoard1 = questionBoardService.findByIdAnswer(qbNo);
            System.out.println(answerBoardVo);
            System.out.println(questionBoardVo);
//            System.out.println(answerBoards);
            req.setAttribute("answerBoardvo",answerBoardVo);
            req.setAttribute("questionBoardvo",questionBoardVo);
            req.getSession().setAttribute("qbNo", qbNo);
//            req.setAttribute("answerBoard",answerBoard1);

            req.getRequestDispatcher("/WEB-INF/views/qaboard/questionBoardDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            // 예외 전환해서 던지기 : 사용자친화적 메세지, 원인예외 wrapping
            throw new QuestionBoardException("게시글 상세보기 오류", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String qbNo = (String)req.getSession().getAttribute("qbNo");
        resp.sendRedirect(req.getContextPath() + "?qbNo=" + qbNo);
    }
}


