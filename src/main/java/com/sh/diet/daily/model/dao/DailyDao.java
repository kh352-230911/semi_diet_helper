package com.sh.diet.daily.model.dao;

import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.daily.model.entity.DailyFood;
import com.sh.diet.daily.model.entity.DailyRecode;
import com.sh.diet.daily.model.entity.EyebodyAttachment;
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

    public DailyRecode findDailyRecodeByMemberNo(SqlSession session, String memberNo) {
        return session.selectOne("daily.findDailyRecodeByMemberNo", memberNo);
    }
}
