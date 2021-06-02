package com.ibatis.dao;

import com.ibatis.pojo.User;
import com.ibatis.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testLog4j() {
        System.out.println("1");
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User u : userByLimit
        ) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            //RowBounds实现
            RowBounds rowBounds = new RowBounds(1,2);

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //通过java代码层面实现分页
            List<User> userList = sqlSession.selectList("com.ibatis.dao.UserMapper.getUserByRowBounds",null,rowBounds);
            for (User user : userList) {
                System.out.println(user);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
