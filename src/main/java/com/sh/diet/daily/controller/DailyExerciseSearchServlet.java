package com.sh.diet.daily.controller;

import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.service.ExerciseDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/text/exerciseSearch")
public class DailyExerciseSearchServlet extends HttpServlet {

    private ExerciseDataService exerciseDataService = new ExerciseDataService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1. 사용자입력값 처리
        String term = req.getParameter("term");
        System.out.println(term);

        // 2. 업무로직
        List<ExerciseData> exerciseDatas = exerciseDataService.findByName(term);
        System.out.println(exerciseDatas);

        // 3. 응답출력 csv
        // 1,홍길동\n2,고길동
        resp.setContentType("text/csv; charset=utf-8");
        PrintWriter out = resp.getWriter();
        for(int i = 0; i < exerciseDatas.size(); i++) {
            ExerciseData exerciseData = exerciseDatas.get(i);
            out.print("%s,%s".formatted(exerciseData.getExNo(), exerciseData.getExName()));
            if(i < exerciseDatas.size() - 1) {
                out.println();
            }
        }
    }
}
