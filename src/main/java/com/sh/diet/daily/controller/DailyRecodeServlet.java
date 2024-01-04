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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/daily/dailyRecode")
public class DailyRecodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/dailyrecode/dailyrecode.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("dailyRecode doPost실행");

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

        DailyRecode dailyRecode = new DailyService().findDailyRecodeByMemberNo("M4");

        // 일일기록 테이블 고유 번호 조회
        String dailyRecodeNo = dailyRecode.getDailyNo();

        // 눈바디 첨부파일 저장 테이블
        EyebodyAttachment eyebodyAttachment = new EyebodyAttachment();
        eyebodyAttachment.setDailyNo(dailyRecodeNo);

        // 운동 일일 기록 테이블
        DailyEx dailyEx = new DailyEx();
        dailyEx.setDailyNo(dailyRecodeNo);

        // 음식 일일 기록 테이블
        DailyFood dailyFood = new DailyFood();
        dailyFood.setDailyNo(dailyRecodeNo);

        // 사용자 입력값 처리
        try{
            // servletFileUpload.parseParameterMap(req): req를 파라미터로 멀티파트 요청에서 추출된 데이터를 가공한 맵을 반환
            // key(String): 필드의 이름, value(List<FileItem>): 필드에 대한 FileItem객체의 리스트
            // 일반적으로 name과 value는 1:1 대응 되지만, 파일 업로드의 경우에 다수개가 올 수 있기 떄문에 value에 List가 되어야 한다.
            Map<String, List<FileItem>> fileItemMap = servletFileUpload.parseParameterMap(req);
            String todayWeight = fileItemMap.get("today-weight").get(0).getString("utf-8");
            System.out.println(todayWeight + "todayWeight");
            
            // 식사 기록용 데이터
            FoodTime mealTime = FoodTime.valueOf(fileItemMap.get("meal-time").get(0).getString("utf-8"));
            String meal = fileItemMap.get("meal").get(0).getString("utf-8");
            String gainKcal = fileItemMap.get("gain-kcal").get(0).getString("utf-8");


            dailyFood.setFoodTime(mealTime);
            dailyFood.setFoodNo(meal);


            System.out.println(mealTime + "meal-time");
            System.out.println(meal + "meal");
            System.out.println(gainKcal + "gainKcal");
            
            // 운동 기록용 데이터
            String exercise = fileItemMap.get("exercise").get(0).getString("utf-8");
            String consume = fileItemMap.get("consume-kcal").get(0).getString("utf-8");
            int exerciseTime = Integer.parseInt(fileItemMap.get("exercise-time").get(0).getString("utf-8"));

            dailyEx.setExId(exercise);
            dailyEx.setExSets(exerciseTime);

            dailyService.insertDailyFood(dailyFood);
            exerciseDataService.insertDailyExercise(dailyEx);

            // 눈바디 기록용 데이터
            FileItem eyebodyFileItem = fileItemMap.get("eyebody-photo").get(0);
            if(eyebodyFileItem.getSize() > 0){
                // 업로드 원본 파이령
                String originalFilename = eyebodyFileItem.getName();
                int dotIndex = originalFilename.lastIndexOf(".");
                // 확장자가 없는 경우를 처리
                String ext = dotIndex > -1 ? originalFilename.substring(dotIndex) : "";
                
                UUID uuid = UUID.randomUUID();
                String  renamedFilename = uuid + ext;

                System.out.println("새 파일명 : " + renamedFilename);
                eyebodyFileItem.write(new File(repository, originalFilename));

                eyebodyAttachment.setOriginalFile(originalFilename);
                eyebodyAttachment.setRenamedFile(renamedFilename);
                System.out.println(eyebodyAttachment + "는 눈바디 객체 입니다.");
                dailyService.insertEyebodyAttachment(eyebodyAttachment);

            }





        }
        catch (Exception e){
            System.out.println("일일 등록 폼 처리중 Exception 발생");
            e.printStackTrace();
        }

    }

    public boolean pointIncreaseCheck(String memberNo){

        DailyRecode dailyRecode = new DailyService().findDailyRecodeByMemberNo("M4");
        String dailyNo = dailyRecode.getDailyNo();
//        new E

        return false;
    }

}
