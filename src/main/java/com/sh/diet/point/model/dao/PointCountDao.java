package com.sh.diet.point.model.dao;

import com.sh.diet.point.model.entity.PointCount;
import org.apache.ibatis.session.SqlSession;

public class PointCountDao {
    public int insertRecodeSatisfiedPoint(SqlSession session, PointCount pointCount) {
        return session.insert("pointCount.insertRecodeSatisfiedPoint", pointCount);
    }

    public PointCount findTodayPointCountByMemberNo(SqlSession session, String memberNo) {
        return  session.selectOne("pointCount.findTodayPointCountByMemberNo", memberNo);
    }
}
