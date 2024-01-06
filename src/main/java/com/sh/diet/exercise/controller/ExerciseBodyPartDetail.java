package com.sh.diet.exercise.controller;

import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.entity.ScrapExercise;
import com.sh.diet.exercise.model.service.ExerciseDataService;
import com.sh.diet.exercise.model.service.ScrapExerciseService;
import com.sh.diet.member.model.entity.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/exercise/bodyPartDetail")
public class ExerciseBodyPartDetail extends HttpServlet {
    private ExerciseDataService exerciseDataService = new ExerciseDataService();
    private ScrapExerciseService scrapExerciseService = new ScrapExerciseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 접속중인 멤버
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("loginMember") ;
        System.out.println(member);
        String bodyPart = req.getParameter("id");
        // System.out.println(bodyPart);

        List<ExerciseData> exerciseDatas = exerciseDataService.findByBodyPart(bodyPart);
        // System.out.println(exerciseDatas);
        ArrayList<String> imgUrls = new ArrayList<>();
        // List<ScrapExercise> loginMemberScrap =

        for(int i = 0; i < exerciseDatas.size(); i++){
            // System.out.println(exerciseDatas.get(i).getExUrl());
            String url = exerciseDatas.get(i).getExUrl();

            String[] splurl = url.split("/");
            String videoId = splurl[3];

            String imgUrl = "https://img.youtube.com/vi/" + videoId + "/mqdefault.jpg";
            // System.out.println(imgUrl);
            imgUrls.add(imgUrl);
        }
        // System.out.println(imgUrls);
        req.setAttribute("loginMember",member);
        req.setAttribute("imgUrls", imgUrls);
        req.setAttribute("exerciseDatas", exerciseDatas);
        req.getRequestDispatcher("/WEB-INF/views/exerciseBoard/exerciseBodyPartDetail.jsp").forward(req,resp);
    }
}
