package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author nkc
 * @date 22/3/24
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
