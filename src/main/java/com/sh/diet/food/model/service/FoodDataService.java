package com.sh.diet.food.model.service;

import com.sh.diet.food.model.dao.FoodDataDao;
import com.sh.diet.food.model.entity.FoodData;
import com.sh.diet.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class FoodDataService {
    FoodDataDao foodDataDao = new FoodDataDao();

    public List<FoodData> findFoodDataByName(String  name){
        SqlSession session = getSqlSession();
        List<FoodData>  foodDatas = foodDataDao.findFoodDataByName(session, name);
        session.close();
        return foodDatas;
    }

    public FoodData findByFoodNo(String foodNo) {
        SqlSession session = getSqlSession();
        FoodData foodData = foodDataDao.findByFoodNo(session, foodNo);
        session.close();
        return foodData;
    }

    public List<FoodData> findAll() {
        SqlSession session = getSqlSession();
        List<FoodData> foodData = foodDataDao.findAll(session);
        session.close();
        return foodData;
    }

    public int insertFoodData(FoodData foodData) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = foodDataDao.insertFoodData(session, foodData);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int updateFoodData(FoodData foodData) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = foodDataDao.updateFoodData(session, foodData);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int deleteFoodData(String foodNo) {
        int result = 0;
        SqlSession session = getSqlSession();
        try {
            result = foodDataDao.deleteFoodData(session, foodNo);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public List<FoodData> findAll(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        List<FoodData> foodDatas = foodDataDao.findAll(session, param);
        session.close();
        return foodDatas;
    }

    public int getTotalCount(Map<String, Object> param) {
        SqlSession session = getSqlSession();
        int totalCount = foodDataDao.getTotalCount(session, param);
        session.close();
        return totalCount;
    }
}
