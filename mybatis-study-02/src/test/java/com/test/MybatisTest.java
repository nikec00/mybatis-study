package com.test;

import com.dao.IUserMapper;
import com.entity.User;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import java.util.List;

/**
 * @author nkc
 * @date 22/3/24
 */
public class MybatisTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void findUserAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        IUserMapper mapper2 = sqlSession.getMapper(IUserMapper.class);
        List<User> userAll = mapper.getUserAll();
        System.out.println("结果：" + userAll);
        List<User> userAll2 = mapper2.getUserAll2();
        System.out.println("结果2：" + userAll2);
    }
}
