package com.ibatis.dao;

import com.ibatis.pojo.User;
import com.ibatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            //执行SQL 方式一：getMapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.getUserList();
            //方式二
//        List<User> userList = sqlSession.selectList("com.ibatis.dao.UserDao.getUserList");
            for (User user : userList
            ) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            User user = userDao.getUserById(1);
//            Map<String, Object> map = userDao.getUserById(1);
//            Object id = map.get("id");
//            System.out.println(id);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test//增删改需要提交事务
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            User user = new User(7, "ggg", "123");
            int res = userDao.addUser(user);
            if (res > 0) {
                System.out.println("插入成功");
            }
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.updateUser(new User(1, "asd", "222"));
            if (res > 0) {
                System.out.println("修改成功！");
            }
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.deleteUser(3);
            if (res > 0) {
                System.out.println("删除成功！");
            }
            //事物提交
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUserMap() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", 1);
            map.put("userName", "sss");
            map.put("userPwd", "123");
            int res = mapper.addUser(map);
            if (res > 0) {
                System.out.println("插入成功！");
            }
            //事物提交
            sqlSession.commit();
        } catch (Exception e) {

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserLike("f");
            for (User user : userList
            ) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
