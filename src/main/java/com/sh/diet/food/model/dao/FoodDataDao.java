package com.sh.diet.food.model.dao;

import com.sh.diet.food.model.entity.FoodData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FoodDataDao {
    public List<FoodData> findFoodDataByName(SqlSession session, String foodName) {
        return session.selectList("foodData.findFoodDataByName", foodName);
    }
}
