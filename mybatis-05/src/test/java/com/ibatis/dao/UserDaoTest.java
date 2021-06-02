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
    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
       //底层主要应用了反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.toString());
        }
        sqlSession.close();
    }
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        //底层主要应用了反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(9,"曾鑫","123456"));
        if(res>0){
            System.out.println("添加成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
