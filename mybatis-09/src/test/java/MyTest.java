import com.ibatis.dao.UserMapper;
import com.ibatis.pojo.User;
import com.ibatis.utils.IDUtils;
import com.ibatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void cacheTest() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        SqlSession sqlSession2 = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        User user2 = mapper2.queryUserById(1);//查询相同的sql语句，会触发mybatis一级缓存机制，SQL语句只执行一次
        System.out.println(user2);
        System.out.println(user==user2);

        sqlSession2.close();
    }
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper.queryUserById(2);//查询相同的sql语句，会触发mybatis一级缓存机制，SQL语句只执行一次
        System.out.println(user2);
        sqlSession.close();
    }
    @Test
    public void updateTest() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.clearCache();// 手动清理缓存
        //增删改操作都会刷新缓存
        //查询不同的东西会刷新缓存
        // 手动清理缓存
//        int res = mapper.updateUser(new User(1,"fdas","fsdaf"));
//       if (res>0){
//           System.out.println("修改成功！");
//       }
        User user2 = mapper.queryUserById(1);//查询相同的sql语句，会触发mybatis一级缓存机制，SQL语句只执行一次
        System.out.println(user2);
        sqlSession.close();
    }
}
