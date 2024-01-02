package com.sh.diet.daily.model.dao;

import com.sh.diet.daily.model.entity.DailyFood;
import com.sh.diet.daily.model.entity.EyebodyAttachment;
import org.apache.ibatis.session.SqlSession;

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
}
