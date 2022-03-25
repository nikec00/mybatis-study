package com;

import com.entity.User;
import com.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author nkc
 * @date 22/3/24
 */
public class TestMybatis {

    @Test
    public void insert() throws IOException {
        // 1.读取mybatis核心配置文件
        InputStream asStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 3.通过核心配置文件输入流创建工厂类，生产sqlsession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(asStream);
        // 4.自动提交或回滚事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 5.通过代理模式创建UserMapper接口的代理实现类对象（代理模式）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法
        mapper.insert();
    }


    @Test
    public void update() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update();

    }

    @Test
    public void selectAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println("结果：" + users);
    }
}
