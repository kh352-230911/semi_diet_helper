package com.sh.diet.daily.model.service;

import com.sh.diet.daily.model.dao.DailyDao;
import com.sh.diet.daily.model.entity.DailyFood;
import com.sh.diet.daily.model.entity.EyebodyAttachment;
import org.apache.ibatis.session.SqlSession;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class DailyService {
    DailyDao dailyDao = new DailyDao();

    public EyebodyAttachment findByEaNo(String eaNo) {
        SqlSession session = getSqlSession();
        EyebodyAttachment eyebodyAttachment = dailyDao.findByEaNo(session, eaNo);
        session.close();
        return eyebodyAttachment;
    }


    public int insertEyebodyAttachment(EyebodyAttachment eyebodyAttachment) {
        int result = 0;
        SqlSession session = getSqlSession();
        try{
            result = dailyDao.insertEyebodyAttachment(session, eyebodyAttachment);
            session.commit();
        }
        catch (Exception e){
            session.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return result;
    }

    public int insertDailyFood(DailyFood dailyFood) {
        int result = 0;
        SqlSession session = getSqlSession();
        try{
            result = dailyDao.insertDailyFood(session, dailyFood);
            session.commit();
        }
        catch (Exception e){
            session.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return result;
    }
}
