package com.sh.diet.point.model.service;

import com.sh.diet.point.model.dao.PointCountDao;
import com.sh.diet.point.model.entity.PointCount;
import org.apache.ibatis.session.SqlSession;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;

public class PointCountService {
    PointCountDao pointCountDao = new PointCountDao();

    public int insertRecodeSatisfiedPoint(PointCount pointCount) {
        int result = 0;
        SqlSession session = getSqlSession();
        result = pointCountDao.insertRecodeSatisfiedPoint(session, pointCount);
        return result;
    }

//    public
}
