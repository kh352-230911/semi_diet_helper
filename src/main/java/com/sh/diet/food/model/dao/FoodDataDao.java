package com.sh.diet.food.model.dao;

import com.sh.diet.food.model.entity.FoodData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FoodDataDao {
    public List<FoodData> findFoodDataByName(SqlSession session, String foodName) {
        return session.selectList("foodData.findFoodDataByName", foodName);
    }

    public FoodData findByFoodNo(SqlSession session, String foodNo) {
        return session.selectOne("foodData.findByFoodNo", foodNo);
    }

    public List<FoodData> findAll(SqlSession session) {
        return session.selectList("foodData.findAll");
    }

    public int insertFoodData(SqlSession session, FoodData foodData) {
        return session.insert("foodData.insertFoodData", foodData);
    }

    public int updateFoodData(SqlSession session, FoodData foodData) {
        return session.update("foodData.updateFoodData", foodData);
    }

    public int deleteFoodData(SqlSession session, String foodNo) {
        return session.delete("foodData.deleteFoodData",foodNo);
    }
}
