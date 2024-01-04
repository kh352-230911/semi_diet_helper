package com.sh.diet.daily.model.service;

import com.sh.diet.daily.model.dao.DailyDao;
import com.sh.diet.daily.model.entity.DailyEx;
import com.sh.diet.daily.model.entity.DailyFood;
import com.sh.diet.daily.model.entity.DailyRecode;
import com.sh.diet.daily.model.entity.EyebodyAttachment;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.List;

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

    public DailyRecode findByDailyNo(String dailyNo) {
        SqlSession session = getSqlSession();
        DailyRecode dailyRecode = dailyDao.findByDailyNo(session, dailyNo);
        return dailyRecode;
    }

    public int insertDailyRecode(DailyRecode dailyRecode) {
        int result = 0;
        SqlSession session = getSqlSession();
        try{
            result = dailyDao.insertDailyRecode(session, dailyRecode);
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

    public List<DailyRecode> findByTodayDailyRecode(LocalDate today) {
        SqlSession session = getSqlSession();
        List<DailyRecode> todayDailyRecode = dailyDao.findByTodayDailyRecode(session, today);
        return todayDailyRecode;
    }

    public DailyRecode findTodayDailyRecodeByMemberNo(String memberNo) {
        SqlSession session = getSqlSession();
        DailyRecode dailyRecode = dailyDao.findTodayDailyRecodeByMemberNo(session, memberNo);
        return dailyRecode;
    }

    public List<DailyEx> findTodayDailyExByDailyNo(String dailyNo) {
        SqlSession session = getSqlSession();
        List<DailyEx> dailyExes = dailyDao.findTodayDailyExByDailyNo(session, dailyNo);
        return dailyExes;
    }


    public List<DailyFood> findTodayDailyFoodByDailyNo(String dailyNo) {
        SqlSession session = getSqlSession();
        List<DailyFood> dailyFoods = dailyDao.findTodayDailyFoodByDailyNo(session, dailyNo);
        return dailyFoods;
    }

    public EyebodyAttachment findTodayEyebodyAttachmentByDailyNo(String dailyNo) {
        SqlSession session = getSqlSession();
        EyebodyAttachment eyebodyAttachment = dailyDao.findTodayEyebodyAttachmentByDailyNo(session, dailyNo);
        return eyebodyAttachment;
    }
}
