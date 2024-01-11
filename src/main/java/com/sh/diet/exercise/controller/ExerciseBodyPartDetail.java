package com.sh.diet.exercise.controller;

import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.entity.ScrapExercise;
import com.sh.diet.exercise.model.service.ExerciseDataService;
import com.sh.diet.exercise.model.service.ScrapExerciseService;
import com.sh.diet.exercise.model.vo.ExerciseDataVo;
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

        //"https://img.youtube.com/vi/" + 영상 고유주소 + "/mqdefault.jpg" 로 변환
        ArrayList<String> imgUrls = new ArrayList<>();
        List<ScrapExercise> scrapExercises = new ArrayList<>();

        for(int i = 0; i < exerciseDatas.size(); i++){
            // 썸네일 출력부
            String url = exerciseDatas.get(i).getExUrl();
            // https://youtu.be/Hv5BsujA3Ys 식으로 뜨는 주소의 마지막이 필요하기에
            // /을 기준으로 4번째 요소가 필요
            String[] splurl = url.split("/");
            String videoId = splurl[3];

            String imgUrl = "https://img.youtube.com/vi/" + videoId + "/mqdefault.jpg";
            imgUrls.add(imgUrl);

            //스크랩 여부를 확인하기
            String exNo = exerciseDatas.get(i).getExNo();
            String memberNo = member.getMemberNo();

            ScrapExercise scrapExercise = new ScrapExercise();
            scrapExercise.setExNo(exNo);
            scrapExercise.setMemberNo(memberNo);

            //조회된 값이 존재한다면 scrapExercise 객체를, 없다면 null이 담기게 됨
            scrapExercise = scrapExerciseService.findByScrapChecker(scrapExercise);
            scrapExercises.add(scrapExercise);
        }
        System.out.println(scrapExercises);

        // System.out.println(imgUrls);
        req.setAttribute("scrapCheck", scrapExercises);
        req.setAttribute("loginMember",member);
        req.setAttribute("imgUrls", imgUrls);
        req.setAttribute("exerciseDatas", exerciseDatas);
        req.getRequestDispatcher("/WEB-INF/views/exerciseBoard/exerciseBodyPartDetail.jsp").forward(req,resp);
    }
}
