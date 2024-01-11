package com.sh.diet.admin.controller;

import com.sh.diet.food.model.entity.FoodData;
import com.sh.diet.food.model.service.FoodDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addFoodData")
public class AddFoodDataServlet extends HttpServlet {
    FoodDataService foodDataService = new FoodDataService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/food/foodRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int kcal = Integer.parseInt(req.getParameter("kcal"));
        int carbo = Integer.parseInt(req.getParameter("carbo"));
        int prot = Integer.parseInt(req.getParameter("prot"));
        int fat = Integer.parseInt(req.getParameter("fat"));

        FoodData foodData = new FoodData(null, name, kcal, carbo, prot, fat);

        int result = foodDataService.insertFoodData(foodData);
        req.getSession().setAttribute("msg", "신규 음식이 정상등록 되었습니다.");
        resp.sendRedirect(req.getContextPath() + "/adminFoodManage");
    }
}