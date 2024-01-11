package com.sh.diet.member.controller;

import com.sh.diet.calendar.entity.HandMadeCalendar;
import com.sh.diet.daily.model.entity.*;
import com.sh.diet.daily.model.service.DailyService;
import com.sh.diet.exercise.model.service.ExerciseDataService;
import com.sh.diet.member.model.entity.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/member/memberMain")
public class MemberMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // HttpSession 객체 생성
        HttpSession session = req.getSession();
        // 로그인한 멤버의 정보를 member객체에  저장
        Member loginMember = (Member)session.getAttribute("loginMember");
        System.out.println("/member/memberMain의 doGet실행");
        
        List<String> gainKcals = (List<String>)session.getAttribute("gainKcals");
        List<String> consumes = (List<String>)session.getAttribute("consumes");

        System.out.println("gainKcals: " + gainKcals);
        System.out.println("consumes: " + consumes);

        // 오늘의 몸무게를 기록하는 변수 todatWeight를 초기화
        int todayWeight = (Integer)session.getAttribute("todayWeight");
        System.out.println("todayWeight: " + todayWeight);
        DailyService dailyService = new DailyService();

        //로그인한 회원 고유번호로 오늘의 일일 테이블을 가져옴(* System시간 기반 *)
        DailyRecode dailyRecode = dailyService.findTodayDailyRecodeByMemberNo(loginMember.getMemberNo());
        // 로그인한 회원의 오늘 일일 기록 테이블 고유 번호(* System시간 기반 *)
        String loginMemberTodayDailyNo = dailyRecode.getDailyNo();

        // 로그인한 회원의 일일 기록과 관련된 일일 운동 리스트
        // 처음 접근하는 get방식 일 때는 Syetem시간 기반으로 조회해도 문제 발생x
        // but, 버튼을 눌러 달의 이동이 발생하는 경우에 이 방식을 사용불가
        List<DailyEx> dailyExes = new DailyService().findTodayDailyExByDailyNo(loginMemberTodayDailyNo);
        System.out.println(dailyExes);
        // 로그인한 회원의 일일 기록과 관련된 일일 음식 리스트
        List<DailyFood> dailyFoods = dailyService.findTodayDailyFoodByDailyNo(loginMemberTodayDailyNo);
        System.out.println(dailyFoods);
        
        // 로그인한 회원의 일일 기록과 관련된 일일 눈바디 리스트
        EyebodyAttachment eyebodyAttachment = null;
        try{
            eyebodyAttachment = new DailyService().findTodayEyebodyAttachmentByDailyNo(dailyRecode.getDailyNo()).get(0);
        }
        catch (IndexOutOfBoundsException ignore){
        }
        System.out.println(eyebodyAttachment);

        int totalConsumeKcal = 0;
        int totalGainKcal = 0;

        System.out.println(dailyExes.size());
        //일일 운동 기록 List를 순회하는 반복문
        for(int i = 0; i < dailyExes.size(); i++){
            // 오늘 하루의 총 소비 칼로리
            totalConsumeKcal += dailyExes.get(i).getExSets() * new ExerciseDataService().findKcalByExId(dailyExes.get(i).getExId()).getKcal();
            System.out.println("totalConsumeKcal: " + totalConsumeKcal);
        }
//        System.out.println("totalConsumeKcal for문 탈출 이후 값: " + totalConsumeKcal);
//        System.out.println(dailyFoods.size());
        //일일 음식 기록 List를 순회하는 반복문
        for(int i = 0; i < dailyFoods.size(); i++){
            // 오늘 하루의 총 섭취 칼로리
            totalGainKcal += dailyService.findKcalByFoodNo(dailyFoods.get(i).getFoodNo()).getKcal();
            System.out.println("totalGainKcal: " + totalGainKcal);
        }

        System.out.println("doGet 캘린더 로직 실행");

        // HandMadeCalendar를 요소로 하는 List 생성
        List<HandMadeCalendar> handMadeCalendarList = new ArrayList<HandMadeCalendar>();

        // 오늘의 달을 의미하는 wantMonth
        int wantMonth = LocalDate.now().getMonth().getValue();

        // 오늘의 년도, 달, 이번 달의 1일을 나타내는 변수 currentDate
        LocalDate currentDate = LocalDate.of(LocalDate.now().getYear(), wantMonth, LocalDate.now().withDayOfMonth(1).getDayOfMonth());
        System.out.println("currentDate의 초기값: " + currentDate);

//
//        // 현재 달의 마지막 일 ex) 31, 30, 28
            int lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth()).getDayOfMonth();
//        System.out.println("현재 달의 마지막 일은 " + lastDayOfMonth);
//
//        // 현재 달의 첫 번째 일 ex) 1
//        int firstDayOfMonth = currentDate.withDayOfMonth(1).getDayOfMonth();
//        System.out.println("현재 달의 첫번째 일은 " + firstDayOfMonth);
//
//        int currentDateMonth = currentDate.getMonth().getValue();
//        System.out.println("오늘은 " + currentDateMonth + "월 입니다.");
//
//        DayOfWeek dayOfWeek = currentDate.getDayOfWeek(); // enum
//        int _dayOfWeek = dayOfWeek.getValue(); // 월(1) ~ 일(7)
            char[] daysOfWeekArray = {'월', '화', '수', '목', '금', '토', '일'};
            // 0: 일, 1: 월, 2: 화, 3: 수.. 를 나타내는 변수 currentDayOfMonthInJspTitle
            int currentDayOfMonthInJspTitle = ((currentDate.getDayOfWeek().getValue()) % 7 ) + 1;

            // 더미 날짜 데이터, 한 달의 시작 일을 설정하도록 도움
            for(int i = 0; i < (currentDayOfMonthInJspTitle - 1); i++){
                handMadeCalendarList.add(new HandMadeCalendar());
            }

        // wantMonth에 첫 날을 가리키는 monthStartDay변수
        LocalDate monthStartDay = LocalDate.of(currentDate.getYear(), wantMonth, currentDate.withDayOfMonth(1).getDayOfMonth());

        int currentMonthYear = 0;
        int currentDayMonth = 0;

        // 현재 달의 일 수 만큼 반복
        for(int i = 1; i <= lastDayOfMonth; i++){

            currentDate = monthStartDay;

            // currentDate1.plusDays(i-1)이후에도 currentDate 값은 변경되지 않음.
            LocalDate calcCurrentDate = currentDate.plusDays(i-1);

            DayOfWeek dayOfWeek = calcCurrentDate.getDayOfWeek(); // enum
//            System.out.println(dayOfWeek + "입니다.");
            int _dayOfWeek = dayOfWeek.getValue(); // 월(1) ~ 일(7)

            // 현재의 년도
            currentMonthYear = calcCurrentDate.getYear();

            // 현재의 월
            currentDayMonth = calcCurrentDate.getMonth().getValue();

            // 현재의 일(숫자)
            int currentDayOfMonth = calcCurrentDate.getDayOfMonth();

            // 현재의 요일(문자)
            char currentDayOfWeekChar = daysOfWeekArray[_dayOfWeek - 1];

            // HandMadeCalendar객체 생성 & 값 날짜 정보 설정
            HandMadeCalendar handMadeCalendar = new HandMadeCalendar();
            handMadeCalendar.setCalcYear(currentMonthYear);
            handMadeCalendar.setCalcMonth(currentDayMonth);
            handMadeCalendar.setCalcDay(currentDayOfMonth);
            handMadeCalendar.setCalcDayOfWeek(currentDayOfWeekChar);

            // 현재 달의 시작 요일(목 -> 5)
            HandMadeCalendar.currentDayOfMonthInJspTitle = currentDayOfMonthInJspTitle;

            handMadeCalendarList.add(handMadeCalendar);
      }


        // *** 현재 모든 정보는 년도와 달을 기준으로 관리 됨. ***
        
        // 현재 로그인한 멤버를 기준으로 이번 년도, 달의 일일기록 테이블을 모두 변수 dailyRecodes에 저장
        // loginMemberTodayDailyNo: 로그인한 멤버의 일일 기록 테이블 고유번호

        // 현재 날짜의 년, 월과 같은 모든 일일 기록 테이블을 가져옴.
        List<DailyRecode> currentDailyRecodes = new DailyService().findAllDailyRecodeByLocalDate(LocalDate.now());
        List<DailyRecode> currentDailyRecodesForLoginMember = new ArrayList<>();
        for(DailyRecode dailyRecodeInforEach : currentDailyRecodes){
            // 현재 날짜의 년, 월과 같은 모든 일일 기록 테이블중에서 로그인 멤버와 회원 고유번호가 같은  모든 리스트를
            // currentDailyRecodesForLoginMember에 추가(최종적으로 현재 날짜의 년, 월과 같고 회원번호가 같은 일일 기록 테이블이 저장됨)
            if(dailyRecodeInforEach.getMemberNo().equals(loginMember.getMemberNo())){
                currentDailyRecodesForLoginMember.add(dailyRecodeInforEach);
            }
        }

        System.out.println("currentDailyRecodesForLoginMember: "
                + currentDailyRecodesForLoginMember);

//      System.out.println(dailyRecodes);

        List<DailyRecode> dailyRecodesForJSP = new ArrayList<>();

        // 날짜를 기록하는 Daily객체를 생성
        Daily daily = new Daily();
        // daily에 날짜 정보를 설정
        daily.setDailyYear(currentMonthYear);
        daily.setDailyMonth(currentDayMonth);

        try{

            List<DailyRecode> resultDailyRecodesIntry = null;
            // 찾고자하는 날짜정보를 가진 dailyRecodeList를 resiltDailyRecodesIntry에 저장
            resultDailyRecodesIntry = new DailyService().findAllDailyRecodeByDate(daily);

            
            // currentDayOfMonthInJspTitle: 더미 날짜 데이터, JSP에서 한 달의 시작 일을 설정하도록 도움
            for(int i = 0; i < (currentDayOfMonthInJspTitle - 1) + lastDayOfMonth; i++){
                // JSP에서 달력 폼을 만들도록 도와주는 빈 DailyRecode 객체를 List에 추가
                dailyRecodesForJSP.add(new DailyRecode());
            }

            int recodeDay = 0;

            // 아래 for문을 거치면 dailyRecodesForJSP list에
            // 일(1, 2, 3), dailyNo, 일일기록 이행 여부에 대한 정보가 담김
            for(int i = 0; i < currentDailyRecodesForLoginMember.size(); i++){
                recodeDay = currentDailyRecodesForLoginMember.get(i).getRecodeDate().getDayOfMonth();
                dailyRecodesForJSP.get(recodeDay + (currentDayOfMonthInJspTitle - 2)).
                        setDailyWeight(currentDailyRecodesForLoginMember.get(i).getDailyWeight());

                dailyRecodesForJSP.get(recodeDay + (currentDayOfMonthInJspTitle - 2)).
                        setDailyNo(currentDailyRecodesForLoginMember.get(i).getDailyNo());

                dailyRecodesForJSP.get(recodeDay + (currentDayOfMonthInJspTitle - 2)).
                        setPointCheck(currentDailyRecodesForLoginMember.get(i).isPointCheck());
            }

            System.out.println("handMadeCalendarList.size()" + handMadeCalendarList.size());
            System.out.println("dailyRecodesForJSP.size()"  + dailyRecodesForJSP.size());

            // 아래 for문을 통해 handMadeCalendarList의 요소에 dailyRecodesForJSP의 정보를 다시 설정해준다.
            for(int i = 0; i < handMadeCalendarList.size(); i++){
                handMadeCalendarList.get(i).setDailyWeight(dailyRecodesForJSP.get(i).getDailyWeight());
                handMadeCalendarList.get(i).setDailyNo(dailyRecodesForJSP.get(i).getDailyNo());
                handMadeCalendarList.get(i).setPointCheck(dailyRecodesForJSP.get(i).isPointCheck());
            }


            System.out.println("resultDailyRecodesIntry : " + resultDailyRecodesIntry);
            System.out.println("dailyRecodesForJSP" + dailyRecodesForJSP);

//            session.setAttribute("dailyRecodesIntry", dailyRecodesIntry);
            session.setAttribute("currentDailyRecodesForLoginMember", currentDailyRecodesForLoginMember);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("handMadeCalendarList", handMadeCalendarList);
        session.setAttribute("currentDayOfMonthInJspTitle", HandMadeCalendar.currentDayOfMonthInJspTitle);

        System.out.println("forward수행 전!");

        req.getRequestDispatcher("/WEB-INF/views/member/memberMain.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberMainServlet의 doGet 실행");
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        Member loginMember = (Member)session.getAttribute("loginMember");

        List<HandMadeCalendar> HandMadeCalendarList = (List<HandMadeCalendar>)session.getAttribute("handMadeCalendarList");
        // prepageMonth: input태그의 hidden으로 가져온 이전 페이지의 'Month'
        int prepageMonth = Integer.parseInt(req.getParameter("prepageMonth"));
        // parepageYear: nput태그의 hidden으로 가져온 이전 페이지의 'Year'
        int parepageYear = Integer.parseInt(req.getParameter("prepageYear"));

        System.out.println(parepageYear + ": parepageYear" + prepageMonth + ": prepageMonth");

        // 사용자가 누른 버튼이 '이전'버튼인지 '다음'버튼인지 구분하기 위해
        // input태그의 hidden속성으로 설정한 식별자 값.
        String pre = req.getParameter("pre");
        String next = req.getParameter("next");

        List<HandMadeCalendar> handMadeCalendarList = new ArrayList<HandMadeCalendar>();

        // 오늘의 달을 의미하는 wantMonth
        int wantMonth = prepageMonth;
        int wantYear = parepageYear;

        // 달력의 'Month'값 변경에 따른 'Year'값 변경 로직
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

        // 오늘의 년도, 달, 이번 달의 1일을 나타내는 변수 currentDate
        LocalDate currentDate = LocalDate.of(wantYear, wantMonth, LocalDate.now().withDayOfMonth(1).getDayOfMonth());
        System.out.println("currentDate의 초기값: " + currentDate);

//
//       // 현재 달의 마지막 일 ex) 31, 30, 28
         int lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth()).getDayOfMonth();
//       System.out.println("현재 달의 마지막 일은 " + lastDayOfMonth);
//
//       // 현재 달의 첫 번째 일 ex) 1
//       int firstDayOfMonth = currentDate.withDayOfMonth(1).getDayOfMonth();
//       System.out.println("현재 달의 첫번째 일은 " + firstDayOfMonth);
//
//       int currentDateMonth = currentDate.getMonth().getValue();
//       System.out.println("오늘은 " + currentDateMonth + "월 입니다.");
//
//       DayOfWeek dayOfWeek = currentDate.getDayOfWeek(); // enum
//       int _dayOfWeek = dayOfWeek.getValue(); // 월(1) ~ 일(7)
        char[] daysOfWeekArray = {'월', '화', '수', '목', '금', '토', '일'};
        // 0: 일, 1: 월, 2: 화, 3: 수.. 를 나타내는 변수 currentDayOfMonthInJspTitle
        int currentDayOfMonthInJspTitle = ((currentDate.getDayOfWeek().getValue()) % 7 ) + 1;


        // 더미 날짜 데이터, 한 달의 시작 일을 설정하도록 도움
        for(int i = 0; i < (currentDayOfMonthInJspTitle - 1); i++){
            handMadeCalendarList.add(new HandMadeCalendar());
        }

        // wantMonth에 첫 날을 가리키는 monthStartDay변수
        LocalDate monthStartDay = LocalDate.of(currentDate.getYear(), wantMonth, currentDate.withDayOfMonth(1).getDayOfMonth());
        System.out.println("monthStartDay: " + monthStartDay);
        System.out.println("currentDate" + currentDate);

        int currentMonthYear = 0;
        int currentDayMonth = 0;

        // 현재 달의 일 수 만큼 반복
        for(int i = 1; i <= lastDayOfMonth; i++){

            currentDate = monthStartDay;

            // currentDate1.plusDays(i-1)이후에도 currentDate 값자체는 변경되지 않음.
            LocalDate calcCurrentDate = currentDate.plusDays(i-1);

            DayOfWeek dayOfWeek = calcCurrentDate.getDayOfWeek(); // enum
//            System.out.println(dayOfWeek + "입니다.");
            int _dayOfWeek = dayOfWeek.getValue(); // 월(1) ~ 일(7)

            // 현재의 년도
            currentMonthYear = calcCurrentDate.getYear();

            // 현재의 월
            currentDayMonth = calcCurrentDate.getMonth().getValue();

            // 현재의 일(숫자)
            int currentDayOfMonth = calcCurrentDate.getDayOfMonth();

            // 현재의 요일(문자)
            char currentDayOfWeekChar = daysOfWeekArray[_dayOfWeek - 1];

            // HandMadeCalendar객체 생성
            HandMadeCalendar handMadeCalendar = new HandMadeCalendar();
            handMadeCalendar.setCalcYear(currentMonthYear);
            handMadeCalendar.setCalcMonth(currentDayMonth);
            handMadeCalendar.setCalcDay(currentDayOfMonth);
            handMadeCalendar.setCalcDayOfWeek(currentDayOfWeekChar);

            // 현재 달의 시작 요일(목 -> 5)
            HandMadeCalendar.currentDayOfMonthInJspTitle = currentDayOfMonthInJspTitle;
//            System.out.println(HandMadeCalendar.currentDayOfMonthInJspTitle + "일요일 : 1");

            handMadeCalendarList.add(handMadeCalendar);
//            System.out.println("Today: " +currentMonthYear + "년, " + currentDayMonth + "월, " + currentDayOfMonth + "일, " + currentDayOfWeekChar + "요일입니다.");
        }

        // *** 현재 모든 정보는 년도와 달을 기준으로 관리 됨. ***

        // 현재 날짜의 년, 월과 같은 모든 일일 기록 테이블을 가져옴.
        List<DailyRecode> currentDailyRecodes = new DailyService().findAllDailyRecodeByLocalDate(monthStartDay);
        List<DailyRecode> currentDailyRecodesForLoginMember = new ArrayList<>();
        for(DailyRecode dailyRecodeInforEach : currentDailyRecodes){
            // 현재 날짜의 년, 월과 같은 모든 일일 기록 테이블중에서 로그인 멤버와 회원 고유번호가 같은  모든 리스트를
            // currentDailyRecodesForLoginMember에 추가(최종적으로 현재 날짜의 년, 월과 같고 회원번호가 같은 일일 기록 테이블이 저장됨)
            if(dailyRecodeInforEach.getMemberNo().equals(loginMember.getMemberNo())){
                currentDailyRecodesForLoginMember.add(dailyRecodeInforEach);
            }
        }

        System.out.println("currentDailyRecodesForLoginMember: "
                + currentDailyRecodesForLoginMember);


        List<DailyRecode> dailyRecodesForJSP = new ArrayList<>();

        Daily daily = new Daily();
        daily.setDailyYear(currentMonthYear);
        daily.setDailyMonth(currentDayMonth);

        try{


            List<DailyRecode> resultDailyRecodesIntry = null;

            // 찾고자하는 날짜정보를 가진 dailyRecodeList를 resiltDailyRecodesIntry에 저장
            resultDailyRecodesIntry = new DailyService().findAllDailyRecodeByDate(daily);


            // currentDayOfMonthInJspTitle: 더미 날짜 데이터, JSP에서 한 달의 시작 일을 설정하도록 도움
            for(int i = 0; i < (currentDayOfMonthInJspTitle - 1) + lastDayOfMonth; i++){
                // JSP에서 달력 폼을 만들도록 도와주는 빈 DailyRecode 객체를 List에 추가
                dailyRecodesForJSP.add(new DailyRecode());
            }

            int recodeDay = 0;

            // 아래 for문을 거치면 dailyRecodesForJSP list에
            // 일(1, 2, 3), dailyNo, 일일기록 이행 여부에 대한 정보가 담김
            for(int i = 0; i < currentDailyRecodesForLoginMember.size(); i++){
                recodeDay = currentDailyRecodesForLoginMember.get(i).getRecodeDate().getDayOfMonth();
                dailyRecodesForJSP.get(recodeDay + (currentDayOfMonthInJspTitle - 2)).
                        setDailyWeight(currentDailyRecodesForLoginMember.get(i).getDailyWeight());

                dailyRecodesForJSP.get(recodeDay + (currentDayOfMonthInJspTitle - 2)).
                        setDailyNo(currentDailyRecodesForLoginMember.get(i).getDailyNo());

                dailyRecodesForJSP.get(recodeDay + (currentDayOfMonthInJspTitle - 2)).
                        setPointCheck(currentDailyRecodesForLoginMember.get(i).isPointCheck());
            }

            System.out.println("handMadeCalendarList.size()" + handMadeCalendarList.size());
            System.out.println("dailyRecodesForJSP.size()"  + dailyRecodesForJSP.size());

            // 아래 for문을 통해 handMadeCalendarList의 요소에 dailyRecodesForJSP의 정보를 다시 설정해준다.
            for(int i = 0; i < handMadeCalendarList.size(); i++){
                handMadeCalendarList.get(i).setDailyWeight(dailyRecodesForJSP.get(i).getDailyWeight());
                handMadeCalendarList.get(i).setDailyNo(dailyRecodesForJSP.get(i).getDailyNo());
                handMadeCalendarList.get(i).setPointCheck(dailyRecodesForJSP.get(i).isPointCheck());
            }

            System.out.println("dailyRecodesForJSP" + dailyRecodesForJSP);

            session.setAttribute("currentDailyRecodesForLoginMember", currentDailyRecodesForLoginMember);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        session.setAttribute("handMadeCalendarList", handMadeCalendarList);
        session.setAttribute("currentDayOfMonthInJspTitle", HandMadeCalendar.currentDayOfMonthInJspTitle);

        req.getRequestDispatcher("/WEB-INF/views/member/memberMain.jsp").forward(req, resp);

    }
}
