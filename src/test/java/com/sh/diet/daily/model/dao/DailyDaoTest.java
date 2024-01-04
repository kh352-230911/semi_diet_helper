package com.sh.diet.daily.model.dao;

import com.sh.diet.daily.model.entity.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import java.time.LocalDate;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class DailyDaoTest {

    DailyDao dailyDao;
    SqlSession session;

    // *** daily_recode -> 나머지 3개 기록 테이블 수정
    @BeforeEach
    void setUp(){
        this.dailyDao = new DailyDao();
        this.session = getSqlSession();
    }

    @AfterEach
    void tearDown(){
        this.session.rollback();
        this.session.close();
    }

    @Disabled
    @DisplayName("일일기록 테이블을 생성할 수 있습니다.")
    @Test
    public void test4(){
        int dailyWeight = 68;
        String memberNo = "M4";
        LocalDate recodeDate = null;
        boolean pointCheck = false;
        DailyRecode dailyRecode = new DailyRecode(null, dailyWeight, memberNo, recodeDate, pointCheck);

        dailyDao.insertDailyRecode(session, dailyRecode);


        int result = dailyDao.insertDailyRecode(session, dailyRecode);
        assertThat(result)
                .isGreaterThan(0);
    }

    @DisplayName("일일기록 테이블에 대한 운동, 식사, 눈바디 기록 테이블을 기록할 수 있습니다.")
    @Test
    public void test5(){
        int result = 0;
        String dailyNo = "DR2";
        DailyRecode dailyRecode = dailyDao.findByDailyNo(session, dailyNo);
        // EyebodyAttachment객체 생성
        EyebodyAttachment eyebodyAttachment = new EyebodyAttachment();
        eyebodyAttachment.setDailyNo(dailyNo);
        eyebodyAttachment.setOriginalFile("originalFileName");
        eyebodyAttachment.setRenamedFile("renamedFileName");
        //테이블 작성 완료시 reuslt += 1
        result += dailyDao.insertEyebodyAttachment(session, eyebodyAttachment);

        // DailyFood객체 생성
        DailyFood dailyFood = new DailyFood();
        FoodTime foodTime = FoodTime.D;
        String foodNo = "F1";
        dailyFood.setFoodTime(foodTime);
        dailyFood.setFoodNo(foodNo);
        dailyFood.setDailyNo(dailyNo);
        result += dailyDao.insertDailyFood(session, dailyFood);

        // 운동 일일기록 테이블
        DailyEx dailyEx = new DailyEx();
        String exId = "E2";
        int exSets = 4;
        dailyEx.setExId(exId);
        dailyEx.setDailyNo(dailyNo);
        dailyEx.setExSets(exSets);
        result += dailyDao.insertDailyEx(session, dailyEx);

        assertThat(result)
                .isEqualTo(3);

    }

}
