package com.sh.diet.member.controller;

import com.google.gson.Gson;
import com.sh.diet.calendar.HandMadeCalendar;
import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.daily.model.entity.DailyFood;
import com.sh.diet.daily.model.entity.DailyRecode;
import com.sh.diet.daily.model.entity.EyebodyAttachment;
import com.sh.diet.daily.model.service.DailyService;
import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.service.ExerciseDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/member/memberMain")
public class MemberMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        LocalDate currentDate = LocalDate.now();

        System.out.println("/member/memberMain의 doGet실행");
        //하드 코딩 지점

        List<String> gainKcals = (List<String>)req.getAttribute("gainKcals");
        List<String> consumes = (List<String>)req.getAttribute("consumes");
        int todayWeight = Integer.parseInt((String) req.getAttribute("todayWeight"));

        DailyService dailyService = new DailyService();
        //로그인한 회원 고유번호로 일일 테이블을 가져옴(하드코딩지점)
        DailyRecode dailyRecode = dailyService.findTodayDailyRecodeByMemberNo("M4");
        // 로그인한 회원의 오늘 일일 기록 테이블 고유 번호
        String loginMemberTodayDailyNo = dailyRecode.getDailyNo();

        List<DailyEx> exerciseDatas = new ExerciseDataService().findDailyExerciseByDailyNo(loginMemberTodayDailyNo);
        List<DailyFood> dailyFoods = new DailyService().findTodayDailyFoodByDailyNo(loginMemberTodayDailyNo);
        EyebodyAttachment eyebodyAttachment = new DailyService().findTodayEyebodyAttachmentByDailyNo(loginMemberTodayDailyNo);

        
        int totalConsumeKcal = 0;

        //일일 운동 기록 List를 순회하는 반복문
        for(int i = 0; i < exerciseDatas.size(); i++){
            // 오늘 하루의
            totalConsumeKcal = exerciseDatas.get(i).getExSets() * Integer.parseInt(consumes.get(i));
        }


        int totalGainKcal = 0;

        //일일 음식 기록 List를 순회하는 반복문
        for(int i = 0; i < dailyFoods.size(); i++){
            // 오늘 하루의 총 섭취 칼로리
//            totalGainKcal = dailyFoods.get(i).getExSets() * Integer.parseInt(consumes.get(i));
        }

        System.out.println("MemberMainServlet의 doGet 실행");
        
        // HandMadeCalendar를 요소로 하는 List 생성
        List<HandMadeCalendar> handMadeCalendarList = new ArrayList<HandMadeCalendar>();

        String changeMonth = req.getParameter("changeMonth");

        int wantMonth = 0;

        wantMonth = LocalDate.now().getMonth().getValue();
        System.out.println("null일 떄,wantMonth:" + wantMonth);
        System.out.println("changeMonth:" + changeMonth);

        System.out.println("changeMonth: " + changeMonth);
        // 원하는 달을 나타내는 변수
        System.out.println("wantMonth: " + wantMonth);

        LocalDate currentDate = LocalDate.of(LocalDate.now().getYear(), wantMonth, LocalDate.now().withDayOfMonth(1).getDayOfMonth());
        System.out.println("currentDate의 초기값: " + currentDate);

//
////        // 현재 달의 마지막 일 ex) 31, 30, 28
            int lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth()).getDayOfMonth();
////        System.out.println("현재 달의 마지막 일은 " + lastDayOfMonth);
////
////        // 현재 달의 첫 번째 일 ex) 1
////        int firstDayOfMonth = currentDate.withDayOfMonth(1).getDayOfMonth();
////        System.out.println("현재 달의 첫번째 일은 " + firstDayOfMonth);
////
////        int currentDateMonth = currentDate.getMonth().getValue();
////        System.out.println("오늘은 " + currentDateMonth + "월 입니다.");
////
////        DayOfWeek dayOfWeek = currentDate.getDayOfWeek(); // enum
////        int _dayOfWeek = dayOfWeek.getValue(); // 월(1) ~ 일(7)
            char[] daysOfWeekArray = {'월', '화', '수', '목', '금', '토', '일'};

            int currentDayOfMonthInJspTitle = ((currentDate.getDayOfWeek().getValue()) % 7 ) + 1;

            for(int i = 0; i < (currentDayOfMonthInJspTitle - 1); i++){
                handMadeCalendarList.add(new HandMadeCalendar());
            }
//
//        char currentDayOfWeekChar = daysOfWeek[_dayOfWeek - 1];
//        System.out.println(currentDayOfWeekChar + ": 오늘의 요일(문자)");

//        for(int i = 1; i <= lastDayOfMonth; i++){

//        LocalDate monthStartDay = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), currentDate.withDayOfMonth(1).getDayOfMonth());
        
        // wantMonth에 첫 날을 가리키는 monthStartDay변수
        LocalDate monthStartDay = LocalDate.of(currentDate.getYear(), wantMonth, currentDate.withDayOfMonth(1).getDayOfMonth());

        // 현재 달의 일 수 만큼 반복
        for(int i = 1; i <= lastDayOfMonth; i++){

            currentDate = monthStartDay;

            // currentDate1.plusDays(i-1)이후에도 currentDate 값은 변경되지 않음.
            LocalDate calcCurrentDate = currentDate.plusDays(i-1);

            DayOfWeek dayOfWeek = calcCurrentDate.getDayOfWeek(); // enum
//            System.out.println(dayOfWeek + "입니다.");
            int _dayOfWeek = dayOfWeek.getValue(); // 월(1) ~ 일(7)

            // 현재의 년도
            int currentMonthYear = calcCurrentDate.getYear();

            // 현재의 월
            int currentDayMonth = calcCurrentDate.getMonth().getValue();

            // 현재의 일(숫자)
            int currentDayOfMonth = calcCurrentDate.getDayOfMonth();

            // 현재의 요일(문자)
            char currentDayOfWeekChar = daysOfWeekArray[_dayOfWeek - 1];

            // HandMadeCalendar객체 생성
            HandMadeCalendar handMadeCalendar = new HandMadeCalendar();
            handMadeCalendar.setCalc_year(currentMonthYear);
            handMadeCalendar.setCalc_month(currentDayMonth);
            handMadeCalendar.setCalc_day(currentDayOfMonth);
            handMadeCalendar.setCalc_dayOfWeek(currentDayOfWeekChar);

            // 현재 달의 시작 요일(목 -> 5)
            HandMadeCalendar.currentDayOfMonthInJspTitle = currentDayOfMonthInJspTitle;
//            System.out.println(HandMadeCalendar.currentDayOfMonthInJspTitle + "일요일 : 1");

            handMadeCalendarList.add(handMadeCalendar);
//            System.out.println("Today: " +currentMonthYear + "년, " + currentDayMonth + "월, " + currentDayOfMonth + "일, " + currentDayOfWeekChar + "요일입니다.");
        }

        System.out.println(handMadeCalendarList);

        req.setAttribute("handMadeCalendarList", handMadeCalendarList);
        req.setAttribute("currentDayOfMonthInJspTitle", HandMadeCalendar.currentDayOfMonthInJspTitle);
        req.setAttribute("totalConsumeKcal", totalConsumeKcal);
        req.setAttribute("totalGainKcal", totalGainKcal);

//        new DailyService().findAllDailyRecode();

        System.out.println("forward수행 전 !");
        req.getRequestDispatcher("/WEB-INF/views/member/memberMain.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberMainServlet의 doGet 실행");
        req.setCharacterEncoding("utf-8");

        // 1. 사용자입력값 처리
        int changeMonth = Integer.parseInt(req.getParameter("changeMonth"));
        System.out.println("changeMonth = " + changeMonth);

        // 2. 업무로직

        // 3. 응답에 데이터 직접 출력
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(changeMonth);

    }
}
