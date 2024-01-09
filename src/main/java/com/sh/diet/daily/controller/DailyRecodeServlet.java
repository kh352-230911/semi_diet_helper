package com.sh.diet.daily.controller;

import com.sh.diet.daily.model.entity.*;
import com.sh.diet.daily.model.service.DailyService;
import com.sh.diet.exercise.model.service.ExerciseDataService;
import com.sh.diet.food.model.service.FoodDataService;
import com.sh.diet.member.model.service.MemberService;
import com.sh.diet.point.model.entity.PointCount;
import com.sh.diet.point.model.service.PointCountService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet("/daily/dailyRecode")
public class DailyRecodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/daily/dailyRecode의 doGet실행");
        DailyService dailyService = new DailyService();

        //회원 M4의 오늘 일일 기록 테이블 조회.(없으면 null)
        DailyRecode dailyRecode = dailyService.findTodayDailyRecodeByMemberNo("M4");
        System.out.println(dailyRecode + ": 입력 폼이동시 실행되는 doGet의 dailtRecode의 값");
        // 오늘 이미 생성한 dailyRecode가 있으면 생성하지 않고 넘어가기
        // 오늘 생성한 dailyRecode 객체가 없으면
        if(dailyRecode == null){
            // DailyRecode 생성 코드 작성
            dailyRecode = new DailyRecode();
            // 생성할 dailyRecode의 정보 설정
            //dailyRecode.setDailyWeight(50);
            // dailyRecode의 memberNo를 로그인 멤버의 memberNo의 값으로 변경해야함. (하드코딩지점)
            dailyRecode.setMemberNo("M4");
            dailyRecode.setPointCheck(false);

            // 오늘 생성한 dailyRecode 객체가 없으면 새로 생성(insert)
            dailyService.insertDailyRecode(dailyRecode);
        }
        req.getRequestDispatcher("/WEB-INF/views/dailyrecode/dailyrecode.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/daily/dailyRecode의 doPost실행");
        File repository = new File("C:\\dev\\workspaces\\semi_diet_helper\\src\\main\\webapp\\images");
        int sizeThreshold = 10 * 1024 * 1024;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(repository);
        factory.setSizeThreshold(sizeThreshold);
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

        // 서비스 객체 생성
        DailyService dailyService = new DailyService();

        ExerciseDataService exerciseDataService = new ExerciseDataService();

        PointCountService pointCountService = new PointCountService();

        FoodDataService foodDataService = new FoodDataService();

        // dailyRecode의 memberNo를 로그인 멤버의 memberNo의 값으로 변경해야함. (하드코딩지점)
        DailyRecode dailyRecode = new DailyService().findTodayDailyRecodeByMemberNo("M4");

        // 일일기록 테이블 고유 번호 조회
        String dailyRecodeNo = dailyRecode.getDailyNo();

        // 사용자 입력값 처리
        try{
            // servletFileUpload.parseParameterMap(req): req를 파라미터로 멀티파트 요청에서 추출된 데이터를 가공한 맵을 반환
            // key(String): 필드의 이름, value(List<FileItem>): 필드에 대한 FileItem객체의 리스트
            // 일반적으로 name과 value는 1:1 대응 되지만, 파일 업로드의 경우에 다수개가 올 수 있기 떄문에 value에 List가 되어야 한다.
            Map<String, List<FileItem>> fileItemMap = servletFileUpload.parseParameterMap(req);

            // 음식 Set가 몇 개인지 세는 변수 foodSetCount
            int foodSetCount = Integer.parseInt(fileItemMap.get("countFoodSet").get(0).getString("utf-8"));
            // 오늘의 몸무게를 의미하는 변수 todayWeight
            int todayWeight = Integer.parseInt(fileItemMap.get("today-weight").get(0).getString("utf-8"));
            // 멤버 M4의 오늘의 몸무게를 설정
            dailyRecode.setDailyWeight(todayWeight);
            System.out.println("**입력 폼 입력이후 오늘의 몸무게: " + dailyRecode.getDailyWeight());

            //fileItemMap을 통해 key값이 담겨있는 keySet반환
            Set<String> keySet = fileItemMap.keySet();

            FoodTime mealTime = null;
            String meal = null;
            String gainKcal = null;
            List<String> gainKcals = new ArrayList<>();

            String exercise = null;
            String consume = null;
            List<String> consumes = new ArrayList<>();
            int exerciseTime = 0;

            // 눈바디 첨부파일 저장 테이블
            EyebodyAttachment eyebodyAttachment = new EyebodyAttachment();
            eyebodyAttachment.setDailyNo(dailyRecodeNo);

            List<DailyFood> dailyFoods = new ArrayList<>();
            for(int i = 0; i < foodSetCount; i++){
                DailyFood dailyFood = new DailyFood();
                dailyFood.setDailyNo(dailyRecodeNo);
                System.out.println(dailyFood + "dailyFood");
                dailyFoods.add(dailyFood);
            }

            List<DailyEx> dailyExes = new ArrayList<>();
            for(int i = 0; i < foodSetCount; i++){
                DailyEx dailyEx = new DailyEx();
                dailyEx.setDailyNo(dailyRecodeNo);
                System.out.println(dailyEx + "dailyEx");
                dailyExes.add(dailyEx);
            }


            //keySet의 담긴 값을 하나씩 가져와서 key에 대입한후 keySet의 크기만큼 반복
            for(String key : keySet){
               System.out.println(key +  ": 가장 바깥쪽 forEach문의 key값");
               
               // key가 식사 기록용 데이터와 관련된 것이라면, DailyFood 객체의 필드 값 세팅
               if(key.equals("meal") || key.equals("meal-time") || key.equals("gain-kcal")) {
                   //key값이 meal이라면 다음을 수행 (key를 통해 가져오는 것은 List인 것에 주의)
                   if (key.equals("meal")) {
                       //key값이 meal인 List<FileItem>을 생성
                       List<FileItem> fileItemListInForEach = fileItemMap.get(key);
                       //List<FileItem>의 크기  만큼 반복을 수행
                       for (int i = 0; i < fileItemListInForEach.size(); i++) {
                           //List<FileItem>의 i번째 요소를 가져와 변수 meal에 대입
                           meal = fileItemListInForEach.get(i).getString("utf-8");
                           dailyFoods.get(i).setFoodNo(meal);
                           System.out.println("******* setMeal *******" + meal);
                       }
                   }
                   //key값이 meal-time이라면 다음을 수행 (key를 통해 가져오는 것은 List인 것에 주의)
                   else if (key.equals("meal-time")) {
                       //key값이 meal-time인 List<FileItem>을 생성
                       List<FileItem> fileItemListInForEach = fileItemMap.get(key);
                       //List<FileItem>의 크기  만큼 반복을 수행
                       for (int i = 0; i < fileItemListInForEach.size(); i++) {
                           //List<FileItem>의 i번째 요소를 가져와 변수 mealTime에 대입
                           mealTime = FoodTime.valueOf(fileItemListInForEach.get(i).getString("utf-8"));
                           dailyFoods.get(i).setFoodTime(mealTime);
                           System.out.println("******* setMealTime *******" + mealTime);
                       }
                   }
                   //key값이 gain-kcal이라면 다음을 수행 (key를 통해 가져오는 것은 List인 것에 주의)
                   else if (key.equals("gain-kcal")) {
                       //key값이 gain-kcal인 List<FileItem>을 생성
                       List<FileItem> fileItemListInForEach = fileItemMap.get(key);
                       //List<FileItem>의 크기  만큼 반복을 수행
                       for (int i = 0; i < fileItemListInForEach.size(); i++) {
                           //List<FileItem>의 i번째 요소를 가져와 변수 gainKcal에 대입
                           gainKcal = fileItemListInForEach.get(i).getString("utf-8");
                           //**** 칼로리 계산 사용 로직 없음 ****
                           gainKcals.add(gainKcal);

                       }
                   }
               }
               // key가 눈바디 기록용 데이터와 관련된 것이라면, EyebodyAttachment 객체의 필드 값 세팅
               else if (key.equals("eyebody-photo")){
                    //단순 구분용(눈바디 기록 로직은 하단에 작성)
               }
               // key가 운동 기록용 데이터와 관련된 것이라면, DailyExercise 객체의 필드 값 세팅
               else{
                   //key값이 exercise이라면 다음을 수행 (key를 통해 가져오는 것은 List인 것에 주의)
                   if (key.equals("exercise")) {
                       //key값이 exercise인 List<FileItem>을 생성
                       List<FileItem> fileItemListInForEach = fileItemMap.get(key);
                       //List<FileItem>의 크기  만큼 반복을 수행
                       for (int i = 0; i < fileItemListInForEach.size(); i++) {
                           //List<FileItem>의 i번째 요소를 가져와 변수 exercise에 대입
                           exercise = fileItemListInForEach.get(i).getString("utf-8");
                           dailyExes.get(i).setExId(exercise);

                       }
                   }
                   //key값이 consume-kcal이라면 다음을 수행 (key를 통해 가져오는 것은 List인 것에 주의)
                   else if (key.equals("consume-kcal")) {
                       //key값이 consume-kcal인 List<FileItem>을 생성
                       List<FileItem> fileItemListInForEach = fileItemMap.get(key);
                       //List<FileItem>의 크기  만큼 반복을 수행
                       System.out.println(fileItemListInForEach + ": fileItemListInForEach");
                       for (int i = 0; i < fileItemListInForEach.size(); i++) {
                           //List<FileItem>의 i번째 요소를 가져와 변수 consume-kcal에 대입
                           consume = fileItemListInForEach.get(i).getString("utf-8");
                           System.out.println(consume + "for문 consume");
                           //**** 소비 칼로리 계산 사용 로직 없음 ****
                           consumes.add(consume);
                       }
                       //key값이 exercise-time이라면 다음을 수행 (key를 통해 가져오는 것은 List인 것에 주의)
                       }
                   else if (key.equals("exercise-time")) {
                       //key값이 exercise-time인 List<FileItem>을 생성
                       List<FileItem> fileItemListInForEach = fileItemMap.get(key);
                       //List<FileItem>의 크기  만큼 반복을 수행
                       for (int i = 0; i < fileItemListInForEach.size(); i++) {
                           //List<FileItem>의 i번째 요소를 가져와 변수 exercise-time에 대입
                           exerciseTime = Integer.parseInt(fileItemListInForEach.get(i).getString("utf-8"));
                           dailyExes.get(i).setExSets(exerciseTime);
                       }
                   }
               }
               
            }

            // DailyFood를 담고있는 List를 순회하여 요소를 DB에 삽입
            for(DailyFood dailyFoodInforeEach : dailyFoods){
                dailyService.insertDailyFood(dailyFoodInforeEach);
            }

            // DailyEx를 담고있는 List를 순회하여 요소를 DB에 삽입
            // EyebodyAttachment를 DB에 삽입하는 로직은 하단에 따로 존재.
            for(DailyEx dailyExInforeEach : dailyExes) {
                exerciseDataService.insertDailyExercise(dailyExInforeEach);
            }

            System.out.println("---- 일일 식단, 운동 기록 정상 insert 성공 이후 ----");
            
            System.out.println(dailyFoods.get(0).getFoodNo() + "는 첫 번째의 음식 고유 번호 입니다.");;

            // 눈바디 기록용 데이터
            FileItem eyebodyFileItem = fileItemMap.get("eyebody-photo").get(0);
            if(eyebodyFileItem.getSize() > 0){
                // 업로드 원본 파이령
                String originalFilename = eyebodyFileItem.getName();
                int dotIndex = originalFilename.lastIndexOf(".");
                // 확장자가 없는 경우를 처리
                String ext = dotIndex > -1 ? originalFilename.substring(dotIndex) : "";

                // UUID 생성
                UUID uuid = UUID.randomUUID();
                // 새로운 파일 이름 = UUID + 확장자
                String  renamedFilename = uuid + ext;

                System.out.println("새 파일명 : " + renamedFilename);
                eyebodyFileItem.write(new File(repository, originalFilename));

                eyebodyAttachment.setOriginalFile(originalFilename);
                eyebodyAttachment.setRenamedFile(renamedFilename);
                System.out.println(eyebodyAttachment + "는 눈바디 객체 입니다.");
                dailyService.insertEyebodyAttachment(eyebodyAttachment);


            }
            
            // "M4"를 로그인한 멤버의 memberNo로 변경 (하드코딩지점)
            // 멤버 M4의 일일기록 3개 테이블이 모두 작성되었는지 확인한 후 3개다 작성되었다면, 이하 if문을 실행
            if(pointIncreaseCheck("M4")){
                System.out.println("pointIncreaseCheck를 사용한 if문 실행");
                // "M4"를 로그인한 멤버의 memberNo로 변경 (하드코딩지점)

                PointCount pointCount = new PointCount(null, null, 1,
                        "M4", dailyRecodeNo, null);
                // 로그인 멤버의 point를 올려주는 로직 (하드코딩지점)
                // 회원고유 번호를 주고, 포인트 테이블 조회 일일기록 테이블 고유번호가 null인지 조회해서 null일떄 실행 하도록

                // memberNo로 오늘 만들어진 pointCount테이블을 조회한 후 테이블이 존재한다면, 이하 if문을 실행
                if(new PointCountService().findTodayPointCountByMemberNo("M4") == null){
                    //밑에 2줄의 코드는 멤버가 오늘 일일기록으로 포인트를 증가 시킨 기록이 있다면 실행되서는 안됨(수정필요) ****************
                    new MemberService().updateIncreaseOnePointToMember("M4");
                    // 작성중인 일일 기록 테이블의 포인트 부여여부가 1로 설정하는 로직 필요 (수정필요) ******************
                    // insert가 아닌 update로 로직을 수정해야 한다.
                    new PointCountService().insertRecodeSatisfiedPoint(pointCount);
                }
            }

            HttpSession session = req.getSession();
            System.out.println(gainKcals + "gainKcals");
            System.out.println(consume + "consume");
            System.out.println(todayWeight + "todayWeight");

            session.setAttribute("gainKcals", gainKcals);
            session.setAttribute("consumes", consumes);
            session.setAttribute("todayWeight", todayWeight);

        }
        catch (Exception e){
            System.out.println("일일 등록 폼 처리중 Exception 발생");
            e.printStackTrace();
        }

        System.out.println("flag-final");
        // " "안에 이동할 주소 입력
        resp.sendRedirect(req.getContextPath() + "/member/memberMain");

    }

    public boolean pointIncreaseCheck(String memberNo){
        System.out.println("pointIncreaseCheck실행");
        // 포인트 증가 여부를 판단하는 변수, 3이되면 포인트 증가 여부를 true로 설정
        int increasePointCheck = 0;

        // 특정 회원의 오늘 일일기록 테이블 가져오기
        DailyRecode dailyRecode = new DailyService().findTodayDailyRecodeByMemberNo(memberNo);
        // 특정 회원이 가지는 오늘 일일기록 테이블의 고유 번호
        String dailyNo = dailyRecode.getDailyNo();

        // 오늘 일일기록 테이블의 고유번호와 관련된 운동 일일기록 테이블들 조회(하루에 운동을 여러개 할 수 있으므로)
        List<DailyEx> dailyExes = new DailyService().findTodayDailyExByDailyNo(dailyNo);

        // 가져온 운동 일일기록 리스트에서 하나씩 요소를 순회
        for(DailyEx dailyEx : dailyExes){
            System.out.println("dailyExForEach 실행");
            // 가져온 운동 일일기록 리스트에서 하나라도 0이 아니면 check
            if(dailyEx.getExSets() != 0){
                ++increasePointCheck;
                break;
            }
        }

        // 오늘 일일기록 테이블의 고유번호와 관련된 운동 일일기록 테이블들 조회(하루에 운동을 여러개 할 수 있으므로)
        List<DailyFood> dailyFoods = new DailyService().findTodayDailyFoodByDailyNo(dailyNo);
        // 가져온 음식 일일기록 리스트에서 하나씩 요소를 순회
        for(DailyFood dailyFood : dailyFoods){
            System.out.println("dailyFoodForEach 실행");
            // 가져온 음식 일일기록 리스트에서 하나라도 null이 아니면 check
            if(dailyFood.getFoodNo() != null){
                ++increasePointCheck;
                break;
            }
        }

        EyebodyAttachment eyebodyAttachment = new DailyService().findTodayEyebodyAttachmentByDailyNo(dailyNo);
        // 가져온 운동 일일기록 리스트에서 하나씩 요소를 순회
        // 가져온 운동 일일기록 리스트에서 하나라도 0이 아니면 check
        if(eyebodyAttachment != null && eyebodyAttachment.getOriginalFile() != null){
            ++increasePointCheck;
        }

        System.out.println(increasePointCheck + "increasePointCheck");
        // 3가지 일일 기록 테이블을 다 작성하면 true를 리턴
        if(increasePointCheck == 3)
            return true;
        return false;
    }

}
