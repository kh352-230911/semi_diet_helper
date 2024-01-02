package com.sh.diet.daily.model.service;

import com.sh.diet.daily.model.entity.DailyFood;
import com.sh.diet.daily.model.entity.EyebodyAttachment;
import com.sh.diet.daily.model.entity.FoodTime;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DailyServiceTest {
    DailyService dailyService;

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
    @DisplayName("눈바디 첨부파일을 고유번호로 조회 할 수 있습니다.")
    @Test
    public void test2(){
        EyebodyAttachment eyebodyAttachment = dailyService.findByEaNo("1");
        System.out.println(eyebodyAttachment);
        assertThat(eyebodyAttachment)
                .isNotNull();
        assertThat(eyebodyAttachment.getEaNo()).isNotNull();
        assertThat(eyebodyAttachment.getDailyNo()).isNotNull();
        assertThat(eyebodyAttachment.getOriginalFile()).isNotNull();
        assertThat(eyebodyAttachment.getRenamedFile()).isNotNull();
    }

    @Disabled
    @DisplayName("눈바디 첨부파일을 저장할 수 있습니다.")
    @Test
    public void test3(){
        EyebodyAttachment eyebodyAttachment = new EyebodyAttachment();
        String originalFileName = "oldFileName";
        String renamedFileName = "newFileName";
        String dailyNo = "20240101";
        eyebodyAttachment.setOriginalFile(originalFileName);
        eyebodyAttachment.setRenamedFile(renamedFileName);
        eyebodyAttachment.setDailyNo(dailyNo);
        int result = dailyService.insertEyebodyAttachment(eyebodyAttachment);
        assertThat(result)
                .isGreaterThan(0);

    }

    @Disabled
    @DisplayName("끼니 분할 기록")
    @Test
    public void test4(){
        int result = 0;
        DailyFood dailyFood = new DailyFood("1", FoodTime.D, "2", "3");
        result = dailyService.insertDailyFood(dailyFood);
        assertThat(result)
                .isGreaterThan(1);
    }


}
