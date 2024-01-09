package com.sh.diet.daily.model.service;

import com.sh.diet.daily.model.entity.DailyRecode;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class DailyServiceTest {
    DailyService dailyService;

    // *** daily_recode -> 나머지 3개 기록 테이블 수정
    @BeforeEach
    public void beforeEach(){
        dailyService = new DailyService();
    }

    @AfterEach
    public void AfterEach(){

    }


    @DisplayName("dailyService는 null이 아닙니다.")
    @Test
    public void test1(){
        assertThat(dailyService)
                .isNotNull();
    }

    @Disabled
    @DisplayName("현재 날짜의 일일 테이블 전체를 조회할 수 있습니다.")
    @Test
    public void test2(){
        System.out.println(LocalDate.now().getYear() + "년");
        System.out.println(LocalDate.now().getMonth().getValue() + "월");
        System.out.println(LocalDate.now().getDayOfMonth() + "일");

        LocalDate today = LocalDate.now();

        List<DailyRecode> dailyRecodes = dailyService.findByTodayDailyRecode(today);
        assertThat(dailyRecodes)
                .isNotNull()
                .isNotEmpty();
        assertThat(dailyRecodes)
                .allSatisfy((dailyRecode) -> {
                    assertThat(dailyRecode)
                            .isNotNull();
                });


    }



    // 일일기록 테이블 생성: 일일기록 테이블의 포인트 부여여부 0 -> 테이블 3개 작성 -> 일일기록 테이블의 포인트 부여여부 1로 수정
//    @DisplayName("일일기록 테이블을 생성할 수 있습니다.")
//    @Test
//    public void test2(){
//        int result;
//        String DailyNo = "";
//        String DailyWeight = "";
//        String memberNo = "";
//        LocalDate recodeDate = null;
//        boolean pointCheck = false;
//        DailyRecode dailyRecode = new DailyRecode();
//        result = dailyService.insertDailyRecode();
//    }

    @DisplayName("일일기록 테이블을 일일기록 테이블 고유번호로 조회할 수 있습니다.")
    @Test
    public void test3() {
        DailyRecode dailyRecode = dailyService.findByDailyNo("DR2");
        assertThat(dailyRecode)
                .isNotNull();
        System.out.println(dailyRecode.getDailyNo());
        assertThat(dailyRecode.getDailyNo())
                .isEqualTo("DR2");
    }



//    @Disabled
//    @DisplayName("눈바디 첨부파일을 고유번호로 조회 할 수 있습니다.")
//    @Test
//    public void test2(){
//        EyebodyAttachment eyebodyAttachment = dailyService.findByEaNo("1");
//        System.out.println(eyebodyAttachment);
//        assertThat(eyebodyAttachment)
//                .isNotNull();
//        assertThat(eyebodyAttachment.getEaNo()).isNotNull();
//        assertThat(eyebodyAttachment.getDailyNo()).isNotNull();
//        assertThat(eyebodyAttachment.getOriginalFile()).isNotNull();
//        assertThat(eyebodyAttachment.getRenamedFile()).isNotNull();
//    }
//
//    @Disabled
//    @DisplayName("눈바디 첨부파일을 저장할 수 있습니다.")
//    @Test
//    public void test3(){
//        EyebodyAttachment eyebodyAttachment = new EyebodyAttachment();
//        String originalFileName = "oldFileName";
//        String renamedFileName = "newFileName";
//        String dailyNo = "20240101";
//        eyebodyAttachment.setOriginalFile(originalFileName);
//        eyebodyAttachment.setRenamedFile(renamedFileName);
//        eyebodyAttachment.setDailyNo(dailyNo);
//        int result = dailyService.insertEyebodyAttachment(eyebodyAttachment);
//        assertThat(result)
//                .isGreaterThan(0);
//
//    }
//
//    @Disabled
//    @DisplayName("끼니 분할 기록")
//    @Test
//    public void test4(){
//        int result = 0;
//        DailyFood dailyFood = new DailyFood("1", FoodTime.D, "2", "3");
//        result = dailyService.insertDailyFood(dailyFood);
//        assertThat(result)
//                .isGreaterThan(1);
//    }




}
