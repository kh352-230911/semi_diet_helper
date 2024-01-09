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

@WebServlet("/exercise/myScrapPage")
public class MyScrapExerciseServlet extends HttpServlet {
    ExerciseDataService exerciseDataService = new ExerciseDataService();
    ScrapExerciseService scrapExerciseService = new ScrapExerciseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 접속중인 멤버
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("loginMember");
        // System.out.println(member);

        // memberNo 추출 후 해당 번호로 scrap 내역 조회
        String memberNo = member.getMemberNo();
        List<ScrapExercise> scrapExercises = scrapExerciseService.findExScrapByMemberNo(memberNo);
        System.out.println(scrapExercises);

        List<ExerciseData> exerciseDatas = new ArrayList<>();
        ArrayList<String> imgUrls = new ArrayList<>();

        for(int i = 0; i < scrapExercises.size(); i++){
            System.out.println(scrapExercises.get(i).getExNo());
            String exNo = scrapExercises.get(i).getExNo();
            ExerciseData exerciseData = exerciseDataService.findByExNo(exNo);

            String url = exerciseData.getExUrl();
            String[] splurl = url.split("/");
            String videoId = splurl[3];

            String imgUrl = "https://img.youtube.com/vi/" + videoId + "/mqdefault.jpg";
            // System.out.println(imgUrl);
            imgUrls.add(imgUrl);
            // String exNo = exerciseDatas.get(i).getExNo();
            // String memberNo = member.getMemberNo();
            //
            // ScrapExercise scrapExercise = new ScrapExercise();
            // ScrapExercise _scrapExercise;
            // scrapExercise.setExNo(exNo);
            // scrapExercise.setMemberNo(memberNo);
            //
            // _scrapExercise = scrapExerciseService.findByScrapChecker(scrapExercise);
            // scrapExercises.add(_scrapExercise);
            exerciseDatas.add(exerciseData);
        }

        System.out.println(imgUrls);
        req.setAttribute("scrapCheck", scrapExercises);
        req.setAttribute("loginMember",member);
        req.setAttribute("imgUrls", imgUrls);
        req.setAttribute("exerciseDatas", exerciseDatas);
        req.getRequestDispatcher("/WEB-INF/views/exerciseBoard/exerciseBodyPartDetail.jsp").forward(req,resp);
    }

}