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
        try {
            result = pointCountDao.insertRecodeSatisfiedPoint(session, pointCount);
            session.commit();
        }
        catch (Exception e){
            session.rollback();
        }
        finally {
            session.close();
        }
        return result;
    }

    public PointCount findTodayPointCountByMemberNo(String memberNo) {
        SqlSession session = getSqlSession();
        PointCount pointCount = pointCountDao.findTodayPointCountByMemberNo(session, memberNo);
        session.close();
        return pointCount;
    }
}
