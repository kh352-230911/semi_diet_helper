package com.sh.diet.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *  sqlSessionFactoryBuilder
 *  SqlSessionFactory
 *  SqlSession
 */
public class SqlSessionTemplate {
    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis-config.xml"; //  src/main/resources/mybatis-config.xml

        //Resource객체를 통해 resource파일로부터 스트림을 생성하여 값을 가져옴
        try(InputStream is = Resources.getResourceAsStream(resource)){
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //설정 정보 is인자로 하여 build 메소드를 호출한다. 이후 SqlSessionFactory객체를 연결한다.
            factory = builder.build(is);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //false 매개변수는 트랜잭션 오토 커밋(auto-commit) 여부를 나타냅니다.
    public static SqlSession getSqlSession(){
        return factory.openSession(false);
    }
}
