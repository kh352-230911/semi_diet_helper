package com.sh.diet.point.dao;

import com.sh.diet.point.model.dao.PointCountDao;
import com.sh.diet.point.model.entity.PointCount;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sh.diet.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class PointCountDaoTest {
    private PointCountDao pointCountDao;
    private SqlSession session;

    @BeforeEach
    void setUp(){
        this.pointCountDao = new PointCountDao();
        this.session = getSqlSession();
    }

    @AfterEach
    void tearDown(){
        this.session.rollback();
        this.session.close();
    }

    @DisplayName("포인트 카운트 테이블에 값을 저장할 수 있습니다.")
    @Test
    public void test1(){
        int result = 0;
        PointCount pointCount = new PointCount(null, null, 1,
                "M4", "DR2", null);
        result = new PointCountDao().insertRecodeSatisfiedPoint(session, pointCount);
        assertThat(result)
                .isEqualTo(1);

    }


}
