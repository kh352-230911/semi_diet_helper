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
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        HttpSession session = req.getSession();

        System.out.println("/member/memberMain의 doGet실행");
        //하드 코딩 지점
        List<String> gainKcals = (List<String>)session.getAttribute("gainKcals");
        List<String> consumes = (List<String>)session.getAttribute("consumes");

        System.out.println("gainKcals: " + gainKcals);
        System.out.println("consumes: " + consumes);

        int todayWeight = (Integer)session.getAttribute("todayWeight");
        System.out.println("todayWeight: " + todayWeight);
        DailyService dailyService = new DailyService();
        //로그인한 회원 고유번호로 일일 테이블을 가져옴(하드코딩지점)
        DailyRecode dailyRecode = dailyService.findTodayDailyRecodeByMemberNo("M4");
        // 로그인한 회원의 오늘 일일 기록 테이블 고유 번호
        String loginMemberTodayDailyNo = dailyRecode.getDailyNo();

        List<DailyEx> dailyExes = new DailyService().findTodayDailyExByDailyNo(loginMemberTodayDailyNo);
        System.out.println(dailyExes);
        List<DailyFood> dailyFoods = dailyService.findTodayDailyFoodByDailyNo(loginMemberTodayDailyNo);
        System.out.println(dailyFoods);
        EyebodyAttachment eyebodyAttachment = dailyService.findTodayEyebodyAttachmentByDailyNo(loginMemberTodayDailyNo);
        System.out.println(eyebodyAttachment);

        int totalConsumeKcal = 0;
        int totalGainKcal = 0;

        System.out.println(dailyExes.size());
        //일일 운동 기록 List를 순회하는 반복문
        for(int i = 0; i < dailyExes.size(); i++){
            System.out.println("dailyExes.get(i).getExId():" + dailyExes.get(i).getExId());
            System.out.println("dailyExes.get(i).getExSets():" + dailyExes.get(i).getExSets());
            System.out.println(new ExerciseDataService().findKcalByExId(dailyExes.get(i).getExId() + ": new ExerciseDataService().findKcalByExId(dailyExes.get(i).getExId()"));

            // 오늘 하루의 총 소비 칼로리
            totalConsumeKcal += dailyExes.get(i).getExSets() * new ExerciseDataService().findKcalByExId(dailyExes.get(i).getExId()).getKcal();
            System.out.println("totalConsumeKcal: " + totalConsumeKcal);
        }
        System.out.println("totalConsumeKcal for문 탈출 이후 값: " + totalConsumeKcal);
        System.out.println(dailyFoods.size());
        //일일 음식 기록 List를 순회하는 반복문
        for(int i = 0; i < dailyFoods.size(); i++){
            // 오늘 하루의 총 섭취 칼로리
            totalGainKcal += dailyService.findKcalByFoodNo(dailyFoods.get(i).getFoodNo()).getKcal();
            System.out.println("totalGainKcal for문 탈출 이후 값: " + totalGainKcal);
        }
        System.out.println("totalGainKcal: " + totalGainKcal);
        System.out.println("doGet 캘린더 로직 실행");
        // HandMadeCalendar를 요소로 하는 List 생성
        List<HandMadeCalendar> handMadeCalendarList = new ArrayList<HandMadeCalendar>();

        //String changeMonth = req.getParameter("changeMonth");

        // 오늘의 달을 의미하는 wantMonth
        int wantMonth = LocalDate.now().getMonth().getValue();

        // 오늘의 년도, 달, 이번 달의 1일을 나타내는 변수 currentDate
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
            // 0: 일, 1: 월, 2: 화, 3: 수.. 를 나타내는 변수 currentDayOfMonthInJspTitle
            int currentDayOfMonthInJspTitle = ((currentDate.getDayOfWeek().getValue()) % 7 ) + 1;

            // 더미 날짜 데이터, 한 달의 시작 일을 설정하도록 도움
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

        List<DailyRecode> dailyRecodes = new DailyService().findAllDailyRecode();
        System.out.println(dailyRecodes);

        session.setAttribute("handMadeCalendarList", handMadeCalendarList);
        session.setAttribute("currentDayOfMonthInJspTitle", HandMadeCalendar.currentDayOfMonthInJspTitle);
        session.setAttribute("dailyRecodes", dailyRecodes);

        System.out.println("forward수행 전!");

        req.getRequestDispatcher("/WEB-INF/views/member/memberMain.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberMainServlet의 doGet 실행");
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();

        List<HandMadeCalendar> HandMadeCalendarList = (List<HandMadeCalendar>)session.getAttribute("handMadeCalendarList");
        int prepageMonth = Integer.parseInt(req.getParameter("prepageMonth"));
        int parepageYear = Integer.parseInt(req.getParameter("prepageYear"));
        System.out.println(prepageMonth +"prepageMonth로직 실행");

        String pre = req.getParameter("pre");
        String next = req.getParameter("next");

        System.out.println("pre: " + pre);
        System.out.println("next: " + next);
        
        System.out.println("doPost 캘린더 로직 실행");

        List<HandMadeCalendar> handMadeCalendarList = new ArrayList<HandMadeCalendar>();

        //String changeMonth = req.getParameter("changeMonth");

        // 오늘의 달을 의미하는 wantMonth
        int wantMonth = prepageMonth;
        int wantYear = parepageYear;

        // preHandMadeCalendarList이 null인 경우(즉, 다음 달 버튼을 누른 경우)
//        if(pre == null){
//            wantMonth += 1 ;
//
//        }
//        // preHandMadeCalendarList이 null이 아닌 경우(즉, 이전 달 버튼을 누른 경우)
//        else if(pre != null){
//            wantMonth -= 1 ;
//        }

        if(pre != null){
            wantMonth -= 1 ;
            if(wantMonth == 0){
                wantMonth = 12;
                --wantYear;
            }
            System.out.println("pre가 null이 아닙니다. 이전 달 이동 버튼을 눌렀습니다.");
        }
        else if(next != null){
            wantMonth += 1 ;
            if((wantMonth / 12) == 1){
                wantMonth = 1;
                ++wantYear;
            }
            System.out.println("next가 null이 아닙니다. 다음 달 이동 버튼을 눌렀습니다.");
        }

        //wantMonth가 13이면 wantMonth -1, yearWeight + 1 처리
//        if((wantMonth / 12) == 1){
//            wantMonth = 1;
//            ++wantYear;
//        }



        // 오늘의 년도, 달, 이번 달의 1일을 나타내는 변수 currentDate
        LocalDate currentDate = LocalDate.of(wantYear, wantMonth, LocalDate.now().withDayOfMonth(1).getDayOfMonth());
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
        // 0: 일, 1: 월, 2: 화, 3: 수.. 를 나타내는 변수 currentDayOfMonthInJspTitle
        int currentDayOfMonthInJspTitle = ((currentDate.getDayOfWeek().getValue()) % 7 ) + 1;

        // 더미 날짜 데이터, 한 달의 시작 일을 설정하도록 도움
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
            
            // currentDate1.plusDays(i-1)이후에도 currentDate 값자체는 변경되지 않음.
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

        List<DailyRecode> dailyRecodes = new DailyService().findAllDailyRecode();
        System.out.println(dailyRecodes);

//        List<DailyRecode> dailyRecodesForJSP = new DailyService().findAllDailyRecodeByDate();

        session.setAttribute("handMadeCalendarList", handMadeCalendarList);
        session.setAttribute("currentDayOfMonthInJspTitle", HandMadeCalendar.currentDayOfMonthInJspTitle);
        session.setAttribute("dailyRecodes", dailyRecodes);

        req.getRequestDispatcher("/WEB-INF/views/member/memberMain.jsp").forward(req, resp);

    }
}
