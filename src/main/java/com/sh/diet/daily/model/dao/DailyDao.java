package com.sh.diet.daily.model.dao;

import com.sh.diet.daily.model.entity.*;
import com.sh.diet.food.model.entity.FoodData;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.List;

public class DailyDao {
    public EyebodyAttachment findByEaNo(SqlSession session, String eaNo) {
        return session.selectOne("daily.findByEaNo", eaNo);
    }

    public int insertEyebodyAttachment(SqlSession session, EyebodyAttachment eyebodyAttachment) {
        return session.insert("daily.insertEyebodyAttachment", eyebodyAttachment);
    }

    public int insertDailyFood(SqlSession session, DailyFood dailyFood) {
        return session.insert("daily.insertDailyFood", dailyFood);
    }

    public DailyRecode findByDailyNo(SqlSession session, String dailyNo) {
        return session.selectOne("daily.findByDailyNo", dailyNo);
    }

    public int insertDailyRecode(SqlSession session, DailyRecode dailyRecode) {
        return session.insert("daily.insertDailyRecode", dailyRecode);
    }

    public int insertDailyEx(SqlSession session, DailyEx dailyEx) {
        return session.insert("daily.insertDailyEx", dailyEx);
    }

    public List<DailyRecode> findByTodayDailyRecode(SqlSession session, LocalDate today) {
        return session.selectList("daily.findByTodayDailyRecode", today);
    }

    public DailyRecode findTodayDailyRecodeByMemberNo(SqlSession session, String memberNo) {
        return session.selectOne("daily.findDailyRecodeByMemberNo", memberNo);
    }

    public List<DailyEx> findTodayDailyExByDailyNo(SqlSession session, String dailyNo) {
        return session.selectList("daily.findTodayDailyExByDailyNo", dailyNo);
    }

    public List<DailyFood> findTodayDailyFoodByDailyNo(SqlSession session, String dailyNo) {
        return session.selectList("daily.findTodayDailyFoodByDailyNo", dailyNo);
    }

    public List<EyebodyAttachment> findTodayEyebodyAttachmentByDailyNo(SqlSession session, String dailyNo) {
        return session.selectList("daily.findTodayEyebodyAttachmentByDailyNo", dailyNo);
    }

    public List<DailyRecode> findAllDailyRecode(SqlSession session) {
        return session.selectList("daily.findAllDailyRecode");
    }

    public FoodData findKcalByFoodNo(SqlSession session, String foodNo) {
        return session.selectOne("daily.findKcalByFoodNo", foodNo);
    }

    public List<DailyRecode> findAllDailyRecodeByDate(SqlSession session, Daily daily) {
        return session.selectList("daily.findAllDailyRecodeByDate", daily);
    }

    public int updateDailyRecode(SqlSession session, DailyRecode dailyRecode) {
        return session.update("daily.updateDailyRecode", dailyRecode);
    }

    public int deletePreEyebodyAttachment(SqlSession session, EyebodyAttachment eyebodyAttachment) {
        return session.delete("daily.deletePreEyebodyAttachment", eyebodyAttachment);
    }

    public int updateIncreaseOnePointToDailyRecode(SqlSession session, String dailyRecodeNo) {
        return session.update("daily.updateIncreaseOnePointToDailyRecode", dailyRecodeNo);
    }
}
