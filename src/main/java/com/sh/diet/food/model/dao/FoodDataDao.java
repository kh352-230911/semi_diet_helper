package com.sh.diet.food.model.dao;

import com.sh.diet.food.model.entity.FoodData;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

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

    public List<FoodData> findAll(SqlSession session, Map<String, Object> param) {
        int page = (int) param.get("page");
        int limit = (int) param.get("limit");

        int offset = (page - 1) * limit;
        RowBounds rowBounds = new RowBounds(offset, limit);
        return session.selectList("foodData.findAll", param, rowBounds);
    }

    public int getTotalCount(SqlSession session, Map<String, Object> param) {
        return session.selectOne("foodData.getTotalCount");
    }
}
