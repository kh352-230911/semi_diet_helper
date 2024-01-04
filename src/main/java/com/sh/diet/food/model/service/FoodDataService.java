package com.sh.diet.food.model.service;

import com.sh.diet.food.model.dao.FoodDataDao;
import com.sh.diet.food.model.entity.FoodData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class FoodDataService {
    FoodDataDao foodDataDao = new FoodDataDao();

    public List<FoodData> findFoodDataByName(String  name){
        SqlSession session = getSqlSession();
        List<FoodData>  foodDatas = foodDataDao.findFoodDataByName(session, name);
        session.close();
        return foodDatas;
    }

}
