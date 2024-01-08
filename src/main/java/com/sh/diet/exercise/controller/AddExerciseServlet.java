package com.sh.diet.exercise.controller;

import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.service.ExerciseDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exercise/addExercise")
public class AddExerciseServlet extends HttpServlet {
    ExerciseDataService exerciseDataService = new ExerciseDataService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/exerciseBoard/exerciseRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exName = req.getParameter("exName");
        int kcal = Integer.parseInt(req.getParameter("kcal"));
        String bodyPart = req.getParameter("bodyPart");
        String exUrl = req.getParameter("exUrl");

        ExerciseData exerciseData = new ExerciseData();
        exerciseData.setExName(exName);
        exerciseData.setKcal(kcal);
        exerciseData.setBodyPart(bodyPart);
        exerciseData.setExUrl(exUrl);

        int result = exerciseDataService.insertExerciseData(exerciseData);

        req.getSession().setAttribute("msg", "신규 운동이 정상등록 되었습니다.");
        resp.sendRedirect(req.getContextPath() + "/exercise/bodyPartList");
    }
}