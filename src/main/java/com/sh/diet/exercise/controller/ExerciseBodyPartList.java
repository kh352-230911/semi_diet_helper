package com.sh.diet.exercise.controller;

import com.sh.diet.exercise.model.service.ExerciseDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/exercise/bodyPartList")
public class ExerciseBodyPartList extends HttpServlet {
    private ExerciseDataService exerciseDataService = new ExerciseDataService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> bodyParts = exerciseDataService.findBodyParts();
        req.setAttribute("bodyParts", bodyParts);
        req.getRequestDispatcher("/WEB-INF/views/exerciseBoard/exerciseBodyPartList.jsp").forward(req,resp);
    }
}