package com.test;

import com.dao.DeptDAO;
import com.dao.EmpDAO;
import com.entity.Dept;
import com.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nkc
 * @date 22/3/25
 */
public class MybatisTest {

    @Test
    public void insertBatchDept() throws IOException {
        InputStream asStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(asStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeptDAO mapper = sqlSession.getMapper(DeptDAO.class);
        Dept dept = new Dept();
        dept.setDeptName("设计部");
        Dept dept2 = new Dept();
        dept2.setDeptName("人力部");
        List<Dept> list = new ArrayList<>(2);
        list.add(dept);
        list.add(dept2);
        int flag = mapper.saveBatchDept(list);
        System.out.println("结果：" + flag);
    }

    @Test
    public void saveBatchEmp() throws IOException {
        InputStream asStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(asStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
        Emp emp = new Emp();
        emp.setUserName("张三");
        emp.setAge(23);
        emp.setPassword("123456");
        emp.setDept(new Dept(1, null));

        Emp emp2 = new Emp();
        emp2.setUserName("李四");
        emp2.setAge(30);
        emp2.setPassword("123456");
        emp2.setDept(new Dept(2, null));
        List<Emp> list = new ArrayList<>(2);
        list.add(emp2);
        int flag = mapper.saveBatchEmp(list);
        System.out.println("结果：" + flag);
    }

    @Test
    public void empFindAll() throws IOException {
        InputStream asStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(asStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
        List<Emp> list = mapper.findAll();
        System.out.println("结果：" + list);
    }

    @Test
    public void lazyFind() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
        List<Emp> list = mapper.findLazyAll();
        System.out.println("结果：" + list);

    }


}
