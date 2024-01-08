package com.sh.diet.exercise.controller;

import com.sh.diet.exercise.model.entity.ScrapExercise;
import com.sh.diet.exercise.model.service.ScrapExerciseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exercise/deleteScrapExercise")
public class DeleteScrapExerciseServlet extends HttpServlet {
    private ScrapExerciseService scrapExerciseService = new ScrapExerciseService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberNo = req.getParameter("memberNo");
        String exNo = req.getParameter("exNo");
        // System.out.println(memberNo + "  " + exNo);

        ScrapExercise scrapExercise = new ScrapExercise();
        scrapExercise.setMemberNo(memberNo);
        scrapExercise.setExNo(exNo);

        ScrapExercise _scrapExercise = scrapExerciseService.findByScrapChecker(scrapExercise);
        String exScrapNo= _scrapExercise.getExScrapNo();

        int result = scrapExerciseService.deleteScrapExercise(exScrapNo);
        if(result > 0){
            req.getSession().setAttribute("msg", "스크랩을 해제하였습니다");
        }

        resp.sendRedirect(req.getContextPath() + "/exercise/myScrapPage");
    }
}