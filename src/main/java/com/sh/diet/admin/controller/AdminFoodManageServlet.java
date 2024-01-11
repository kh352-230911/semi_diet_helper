package com.sh.diet.admin.controller;

import com.sh.diet.common.DawumiUtils;
import com.sh.diet.food.model.entity.FoodData;
import com.sh.diet.food.model.service.FoodDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/adminFoodManage")
public class AdminFoodManageServlet extends HttpServlet {
    FoodDataService foodDataService = new FoodDataService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int limit = 10;

        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (NumberFormatException ignore) {
        }

        Map<String, Object> param = new HashMap<>();
        param.put("page", page);
        param.put("limit", limit);

        List<FoodData> foodDatas = foodDataService.findAll(param);
        req.setAttribute("foodDatas", foodDatas);

        int totalCount = foodDataService.getTotalCount(param);
        String url = req.getRequestURI();
        String pagebar = DawumiUtils.getPagebar(page, limit, totalCount, url);

        req.setAttribute("pagebar", pagebar);
        req.getRequestDispatcher("/WEB-INF/views/admin/adminFoodManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foodNo = req.getParameter("foodNo");
        // System.out.println(foodNo);

        int result = foodDataService.deleteFoodData(foodNo);

        req.getSession().setAttribute("msg", "음식 삭제에 성공하였습니다.");
        resp.sendRedirect(req.getContextPath() + "/adminFoodManage");
    }
}