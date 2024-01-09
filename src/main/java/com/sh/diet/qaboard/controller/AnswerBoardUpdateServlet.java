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

@WebServlet("/qaboard/answerBoardUpdate")
public class
AnswerBoardUpdateServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String acNo = req.getParameter("acNo");
//        String memberNo = req.getSession().setAttribute("memberNo",memberNo);
//                //acNo에 해당하는 회원 고유번호를 찾아서 memberNo에 대입
//                // memberNo를 가지고 req.setAttribute("memberNo", memberNo)수행

        String qbNo = (String)req.getSession().getAttribute("qbNo");
        System.out.println(qbNo + " : 가져온 qbNo ANSWERBOARDUPDATESERVLET");

        //
        req.setAttribute("qbNo", qbNo);
        req.getRequestDispatcher("/WEB-INF/views/qaboard/answerBoardUpdate.jsp").forward (req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acNo = req.getParameter("acNo");
        String qbNo = req.getParameter("qbNo"); //여기 까지 성공
//        String qbNo = (String)req.getSession().getAttribute("qbNo");
        String memberNo = req.getParameter("memberNo");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        System.out.println(acNo + " " +qbNo + " " + memberNo + " " + title + " " + content);

        AnswerBoard answerBoard = new AnswerBoard();
        answerBoard.setAcNo(acNo);
        answerBoard.setQbNo(qbNo);
        answerBoard.setMemberNo(memberNo);
        answerBoard.setTitle(title);
        answerBoard.setContent(content);

        //-----------------------------여기 명준---

        int result = questionBoardService.updateAnswerBoard(answerBoard);
        req.getSession().setAttribute("msg", "게시글을 정상적으로 수정되었습니다. 🥰");

        req.setAttribute("answerBoard",answerBoard);

        //why?
        resp.sendRedirect(req.getContextPath()+"/qaboard/questionBoardDetail?qbNo="+qbNo);
    }
}