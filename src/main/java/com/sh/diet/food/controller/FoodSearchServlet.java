package com.sh.diet.food.controller;

import com.sh.diet.food.model.entity.FoodData;
import com.sh.diet.food.model.service.FoodDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/text/foodSearch")
public class FoodSearchServlet extends HttpServlet {

    private FoodDataService foodDataService = new FoodDataService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String term = req.getParameter("term");
        System.out.println(term);


        List<FoodData> foodDatas = foodDataService.findFoodDataByName(term);
        System.out.println(foodDatas);

        resp.setContentType("text/csv; charset=utf-8");
        PrintWriter out = resp.getWriter();
        for(int i = 0; i < foodDatas.size(); i++) {
            FoodData foodData = foodDatas.get(i);
            out.print("%s,%s".formatted(foodData.getFoodNo(), foodData.getName()));
            if(i < foodDatas.size() - 1) {
                out.println();
            }
        }


    }
}
