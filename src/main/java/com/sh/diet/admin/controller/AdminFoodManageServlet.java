package com.sh.diet.admin.controller;

import com.sh.diet.food.model.service.FoodDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/adminFoodManage")
public class AdminFoodManageServlet extends HttpServlet {
    FoodDataService foodDataService;

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

        // List<FoodData> foodDatas = FoodDataService.findAll(param);
        // req.setAttribute("foodDatas", foodDatas);

        req.getRequestDispatcher("/WEB-INF/views/admin/adminFoodManage.jsp").forward(req, resp);
    }
}