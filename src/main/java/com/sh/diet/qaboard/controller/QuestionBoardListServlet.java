package com.sh.diet.qaboard.controller;

import com.sh.diet.common.DawumiUtils;
import com.sh.diet.qaboard.model.entity.QuestionBoard;
import com.sh.diet.qaboard.model.service.QuestionBoardService;
import com.sh.diet.qaboard.model.vo.QuestionBoardVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/qaboard/questionBoardList")
public class QuestionBoardListServlet extends HttpServlet {
    private QuestionBoardService questionBoardService = new QuestionBoardService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자입력값 가져오기
        int page = 1; // 기본값
        int limit = 10;
        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException ignore) {}
        String searchType = req.getParameter("search-type");
        String searchKeyword = req.getParameter("search-keyword");

        Map<String, Object> param = new HashMap<>();
        param.put("searchType", searchType);
        param.put("searchKeyword", searchKeyword);
        param.put("page", page);
        param.put("limit", limit);
        System.out.println(param);

        // 2 업무 로직
        List<QuestionBoardVo> questionBoardvos = questionBoardService.findAll(param);
        req.setAttribute("questionBoardvos",questionBoardvos);
        System.out.println(questionBoardvos);

        int totalCount = questionBoardService.getTotalCount(param);
        String url = req.getRequestURI();
        if(searchType != null && searchKeyword != null) {
            url += "?search-type=" + searchType + "&search-keyword=" + searchKeyword;
        }
        String pagebar = DawumiUtils.getPagebar(page, limit, totalCount, url);
        req.setAttribute("pagebar", pagebar);
        req.getRequestDispatcher("/WEB-INF/views/qaboard/questionBoardList.jsp").forward(req, resp);
    }

}


