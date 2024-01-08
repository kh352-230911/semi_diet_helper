//package com.sh.diet.qaboard.controller;
//
//import com.sh.diet.common.DawumiUtils;
//import com.sh.diet.qaboard.model.service.QuestionBoardService;
//import com.sh.diet.qaboard.model.vo.QuestionBoardVo;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@WebServlet("/qaboard/questionsearchBoardList")
//public class QuestionSearchBoardListServlet extends HttpServlet {
//    private QuestionBoardService questionBoardService = new QuestionBoardService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 1. 사용자입력값 가져오기
//        String searchType = req.getParameter("search-type");
//        String searchKeyword = req.getParameter("search-keyword");
//
//        Map<String, Object> param = new HashMap<>();
//        param.put("searchType", searchType);
//        param.put("searchKeyword", searchKeyword);
//        System.out.println(param);
//
//        // 2 업무 로직
//        List<QuestionBoardVo> questionBoardvos = questionBoardService.searchList(param);
//        req.setAttribute("questionBoardvos", questionBoardvos);
//        System.out.println(questionBoardvos);
//        req.getRequestDispatcher("/WEB-INF/views/qaboard/questionBoardList.jsp").forward(req, resp);
//    }
//
//}
