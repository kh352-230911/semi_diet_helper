package com.sh.diet.exercise.controller;

import com.sh.diet.exercise.model.service.ExerciseDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exercise/deleteExerciseData")
public class DeleteExerciseDataServlet extends HttpServlet {
    ExerciseDataService exerciseDataService = new ExerciseDataService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exNo = req.getParameter("exNo");
        String bodyPart = req.getParameter("bodyPart");

        int result = exerciseDataService.deleteExerciseData(exNo);

        req.getSession().setAttribute("msg", "운동 삭제에 성공하였습니다");
        resp.sendRedirect(req.getContextPath() + "/exercise/bodyPartDetail?id=" + bodyPart);
    }
}